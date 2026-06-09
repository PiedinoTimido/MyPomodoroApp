package com.pomodoro.app

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    // Graphic Design, here kotlin get the graphic of the app
    private lateinit var textTimer: TextView
    private lateinit var textStatus: TextView
    private lateinit var editWorkDuration: EditText
    private lateinit var editIntervalBeforeBreak: EditText
    private lateinit var editBreakDuration: EditText
    private lateinit var btnStart: Button // Moved here to change its text dynamically!

    // Variables
    private var countDownTimer: CountDownTimer? = null
    private var timerRunning = false
    private var isWorkMode = true
    private var timeLeftInMillis: Long = 0
    private var workMinutes: Long = 25
    private var breakMinutes: Long = 5

    // Android Media player (win. 7 vibes)
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This keeps the screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // graphic by ID XML
        textTimer = findViewById(R.id.textTimer)
        textStatus = findViewById(R.id.textStatus)
        editWorkDuration = findViewById(R.id.editWorkDuration)
        editIntervalBeforeBreak = findViewById(R.id.editIntervalBeforeBreak)
        editBreakDuration = findViewById(R.id.editBreakDuration)
        btnStart = findViewById(R.id.btnStart)

        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // If the buttons click
        btnStart.setOnClickListener {
            // If music is playing, clicking PLAY will stop the music!
            if (mediaPlayer?.isPlaying == true) {
                fermaMusica()
                btnStart.text = "PLAY" //YOU CAN CUSTOMIZE THIS TEXT!
            } else if (!timerRunning) {
                startTimer()
            }
        }

        btnPause.setOnClickListener {
            if (timerRunning) {
                pauseTimer()
            }
        }

        btnReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        // if the timer is resetted, it reads the new ones
        if (timeLeftInMillis == 0L) {
            workMinutes = editIntervalBeforeBreak.text.toString().toLongOrNull() ?: 25L
            breakMinutes = editBreakDuration.text.toString().toLongOrNull() ?: 5L

            // once it starts, you cant modify the values
            gestisciModificheInput(false)

            // first cicle always in work mode
            timeLeftInMillis = workMinutes * 60 * 1000
            isWorkMode = true
            textStatus.text = "Pomodoro Timer starts!" //YOU CAN CUSTOMIZE THIS!
            textStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))//THIS TOO, can customize only "red_dark" ex. light orange
        }

        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                timerRunning = false
                if (isWorkMode) {
                    // once the timer ends, pause!
                    textStatus.text = "Pause! Relax" //YOU CAN CUSTOMIZE THIS!
                    textStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_green_dark))//THIS TOO, SAME AS LAST TIME!
                    isWorkMode = false
                    timeLeftInMillis = breakMinutes * 60 * 1000

                    attivavibrazione()
                    riproduciMusica()

                    // Change PLAY button to music stopper during pause
                    btnStart.text = "Stop Music" //YOU CAN CUSTOMIZE THIS TEXT!
                } else {
                    // Pause ends -> Back to WORK
                    textStatus.text = "Time to focus!" //YOU CAN CUSTOMIZE THIS!
                    textStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_dark))//SAME AS START
                    isWorkMode = true
                    timeLeftInMillis = workMinutes * 60 * 1000

                    fermaMusica()
                    btnStart.text = "PLAY" //YOU CAN CUSTOMIZE THIS TEXT!
                }

                // Automatically starts the next cycle (Work <-> Pause)
                startTimer()
            }
        }.start()

        timerRunning = true
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        timerRunning = false
        Toast.makeText(this, "Timer paused", Toast.LENGTH_SHORT).show()
    }

    private fun resetTimer() {
        countDownTimer?.cancel()
        timerRunning = false
        isWorkMode = true
        timeLeftInMillis = 0L

        textTimer.text = "Waiting..."
        textStatus.text = "Pomodoro Timer"
        textStatus.setTextColor(ContextCompat.getColor(this, android.R.color.black))

        fermaMusica()
        btnStart.text = "PLAY" //YOU CAN CUSTOMIZE THIS TEXT!

        // When the user resets, the fields become EDITABLE again
        gestisciModificheInput(true)
    }

    private fun updateCountDownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        textTimer.text = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
    }

    // Funzione per bloccare/sbloccare gli EditText
    private fun gestisciModificheInput(abilitati: Boolean) {
        editWorkDuration.isEnabled = abilitati
        editIntervalBeforeBreak.isEnabled = abilitati
        editBreakDuration.isEnabled = abilitati
    }

    private fun attivavibrazione() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION") getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(1500, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            @Suppress("DEPRECATION") vibrator.vibrate(1500)
        }
    }

    private fun riproduciMusica() {
        fermaMusica()
        // THE FILE MUST BE IN RAW.RINGTONE! else error
        mediaPlayer = MediaPlayer.create(this, R.raw.ringtone)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    private fun fermaMusica() {
        mediaPlayer?.let {
            if (it.isPlaying) it.stop()
            it.release()
            mediaPlayer = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fermaMusica()
    }
}