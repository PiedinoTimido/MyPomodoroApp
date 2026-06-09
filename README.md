# Let's Create an Android Pomodoro App! 🍅

Well, today we're going to try building an app with Android Studio! Did you know that about 70%–72% of the phones in the world are Androids? Now, we are going to create an app specifically for them.

We’re going to create a Pomodoro app that will help you concentrate. When we are finished, you'll have your very own working app!

---

## 📋 Requirements

Because Android Studio is a powerful IDE, it's going to take up some system resources. Let's check what your computer needs. You can view all the official system requirements [here](https://developer.android.com/studio/system-requirements).

---

## 🚚 Prepare the Installer

Now that we know our system can handle Android Studio, we can start the installation process:

1. Go to the [official Android Studio site](https://developer.android.com/studio) to download the installer.
2. Accept the terms and conditions and download the file.
3. Once the download finishes, open the installer (it may require admin permissions).
4. When the installer opens, click **Next**.
5. Select the checkbox for **"Android Virtual Device"** if you want to use an emulator, then click **Next**. 
   > **WARNING:** Virtual devices take up significant resources! Please double-check the system requirements.
6. Choose your installation path (it's okay to leave it as the default) and click **Next**.
7. Choose whether you want a Start Menu shortcut, then click **Install**.
8. Wait for the installation to complete.
9. Leave the **"Open Android Studio"** checkbox checked and click **Finish**. It will automatically open the IDE.

---

## 📱 Prepare Your Physical Device

If you decide to test the app on your real phone, follow this quick guide to enable USB Debugging. **This step is mandatory!**

1. Go to your phone's **Settings**.
2. Tap on **About phone** or **Phone info**.
3. Find the **Build Number** (usually under system information or software information).
4. Tap it repeatedly! (Keep tapping until a message says "You are now a developer!").
5. If you have a lock screen password, enter it when prompted.
6. Go back and find the new **Developer Options** menu (usually in Settings > System, or just search for it).
7. Scroll down to the **Debugging** section.
8. Toggle on **USB Debugging**.
9. You are done! Keep a USB cable handy to connect your phone when the app is ready.

---

## 🛠️ A Bit of Info Before Starting

Before we click that tempting "New Project" button, let’s talk about the *three musketeers* behind every Android app. When you open a project, Android Studio will throw a lot of files at you. Don't panic! 99% of the time, you'll only care about these three things: **XML**, **Kotlin**, and **Gradle**. Everything else is just what Android needs behind the scenes to compile your app.

Think of building an app like building a house:

### 1. 📐 XML (Extensible Markup Language) – The Bricks and Paint
XML is the design of your app. It doesn't "think"; it just looks pretty. If you want a button, a text box, or an image on the screen, you declare it in an XML file.
* **In our house metaphor:** XML is the blueprint that says where the walls go, what color the front door is, and where the windows are placed. It's the skeleton and the aesthetics.
* **Every screen is an XML file:** Think of it like rooms in a house—every room is different, and no two rooms are exactly the same!

### 2. 🧠 Kotlin – The Brains and Electricity
Kotlin handles the logic of your app. It's a modern, super-clean programming language that tells the app what to do when something happens.
* **In our house metaphor:** Kotlin is the electrical wiring and smart-home automation. XML creates the light switch, but Kotlin is the electricity that actually turns on the light when you click it. When a user taps a button, Kotlin decides what happens next.

### 3. 😈 The Gradle Daemon – The Grumpy Backstage Worker
Ah, Gradle. You will hear this name a lot. Gradle is a build automation tool. When you test your app, Gradle gathers your XML files, your Kotlin code, and your images, mixes them all together, and compiles them into a single `.apk` file that your phone can actually run.
* **Why is it called a "Daemon" (Demon)?** In computer science, a daemon is just a background process. But Gradle feels like a grumpy demon because every time you open a project, it starts loading and takes up a lot of your PC's power.
* **The Golden Rule:** When you see "Gradle syncing" or "Building Gradle" at the bottom of the screen, **do not touch anything**. Just let it do its dark magic. If it takes 2 minutes, that's completely normal. Your computer is not broken; Gradle is just working hard.

Now that you know who's who, we are finally ready to build something real. Let's create our first official project!

---

## 🚀 Creating the Project!

Since this is your first app, we are going to build... **A POMODORO APP!** Yes, I chose this because I’m Italian and I love *pomodori*! 🍅

Let's start:
1. On the welcome screen, click **New Project**.
2. Select **Empty Views Activity** and click **Next**.
3. Set the Name to **"My Pomodoro App"** (or whatever you prefer!).
4. Set the Package name as `com.pomodoro.app`.
5. Leave the save location as default, or choose a custom folder.
6. For the Minimum SDK, leave it as the default (API 24, Android 7).
7. Set the Build Configuration Language to **"Kotlin DSL"**.
8. Click **Finish**.

Great! We've created the project. Now, let the Gradle Daemon do its thing until it finishes syncing.

---

## 👁️ How Android Studio Looks

Let's explore the main interface tools we'll be using. At the bottom of the screen, you'll see various tabs. The ones you need to know today are **BUILD 🔨**, **PROBLEMS ⚠️**, and **LOGCAT 😼**.

* **BUILD 🔨**: Lets you watch your code compile into an app, thanks to the Daemon.
* **PROBLEMS ⚠️**: Shows you any errors, warnings, or information you need to address.
* **LOGCAT 😼**: My favorite! It displays all the logs in real-time while your app is running. Don't worry if you see errors here; Android logs absolutely *everything*.

On the left side, you should see your project directory. If you don't, click the **Project 📂** tab to open it.

---

## 🔨 Let's Develop the App!

Here is how we will work:
1. You will customize how the app looks.
2. I will provide examples, instructions, and the ready-made logic.
3. You just need to ensure the IDs match up.
4. If you find any bugs and don't know how to fix them, just ask!

Good luck!

### 📐 The Visual Part

Navigate to `app -> src -> main -> res -> layout` and open the only file there: `activity_main.xml`. You should see a preview with "Hello World". Click the **Split** option (top right corner of the design view) so you can see both the visual preview and the code. 

**What you SHOULD do:**
* Customize the background.
* Customize `<TextView>` (Text, Color, Size, Type).
* Customize `<View>` (Background only).
* Customize `<EditText>` (Hints only).
* Customize `<Button>` (Text, Color, Size, Type, Background Tint).
* Be creative and make the app your own!

**What you SHOULDN'T do:**
* Modify the structural parts that aren't customizable.
* Delete or change the `android:id` values (this will break the Kotlin code!).
* Change the name of the `activity_main.xml` file.

Start by replacing the existing code with the layout below, then customize it!

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    android:background="#F5F5F5"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp"
        android:gravity="center_horizontal">

        <TextView
            android:id="@+id/textStatus"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="Pomodoro Timer"
            android:textColor="#E53935"
            android:textSize="22sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/textTimer"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:layout_marginBottom="32dp"
            android:text="Waiting..."
            android:textColor="#212121"
            android:textSize="64sp"
            android:textStyle="bold" />

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#DDDDDD"
            android:layout_marginBottom="24dp"/>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Time of the pomodoro timer (minutes)"
            android:textColor="#555555"
            android:textStyle="bold"
            android:textSize="14sp" />

        <EditText
            android:id="@+id/editWorkDuration"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="20dp"
            android:hint="Ex. 25"
            android:inputType="number"
            android:minHeight="48dp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="After how much time do you want a pause? (minutes)"
            android:textColor="#555555"
            android:textStyle="bold"
            android:textSize="14sp" />

        <EditText
            android:id="@+id/editIntervalBeforeBreak"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="20dp"
            android:hint="Ex. 25"
            android:inputType="number"
            android:minHeight="48dp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Length of the pause? (minutes)"
            android:textColor="#555555"
            android:textStyle="bold"
            android:textSize="14sp" />

        <EditText
            android:id="@+id/editBreakDuration"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="32dp"
            android:hint="Ex. 5"
            android:inputType="number"
            android:minHeight="48dp" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="center"
            android:layout_marginTop="16dp"
            android:layout_marginBottom="16dp">

            <Button
                android:id="@+id/btnStart"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_margin="4dp"
                android:backgroundTint="#4CAF50"
                android:text="PLAY"
                android:textColor="#FFFFFF"
                android:textStyle="bold" />

            <Button
                android:id="@+id/btnPause"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_margin="4dp"
                android:backgroundTint="#FF9800"
                android:text="PAUSE"
                android:textColor="#FFFFFF"
                android:textStyle="bold" />

            <Button
                android:id="@+id/btnReset"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_margin="4dp"
                android:backgroundTint="#757575"
                android:text="RESET"
                android:textColor="#FFFFFF"
                android:textStyle="bold" />
        </LinearLayout>
    </LinearLayout>
</ScrollView>
```

---

### 🔔 Bonus Part 1: A Custom Ringtone!

Prepare your favorite song in `.mp3` or `.wav`, because we are going to add a custom ringtone! It needs to be placed in a special folder called `raw`.

1. Download your ringtone and rename the file to `ringtone` (e.g., `ringtone.mp3`).
2. Right-click the `res` folder in Android Studio.
3. Select **New -> Android Resource Directory**.
4. Change the **Resource type** to `raw` and click **OK**.
5. Copy and paste your audio file into this new `raw` directory.
6. Click **Refactor** to confirm.

---

### 🪧 The Manifest

Before we write the logic, we need to update our manifest. The `AndroidManifest.xml` tells Android what permissions and rules the app needs to run. 

Navigate to `app -> src -> main -> AndroidManifest.xml` and replace its contents with this code (you can customize the `android:label`):

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    
    <uses-permission android:name="android.permission.VIBRATE" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="My Pomodoro App"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyPomodoroApp">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

---

### 🧠 The Logic: Kotlin

Now we are ready to code the brain of the app! You can customize strings where you see the `// YOU CAN CUSTOMIZE` comments.

Open `MainActivity.kt` (located in `app -> src -> main -> java -> com.pomodoro.app -> MainActivity.kt`) and replace everything with the code below:

```kotlin
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
    // Graphic Design
    private lateinit var textTimer: TextView
    private lateinit var textStatus: TextView
    private lateinit var editWorkDuration: EditText
    private lateinit var editIntervalBeforeBreak: EditText
    private lateinit var editBreakDuration: EditText
    private lateinit var btnStart: Button

    // Variables
    private var countDownTimer: CountDownTimer? = null
    private var timerRunning = false
    private var isWorkMode = true
    private var timeLeftInMillis: Long = 0
    private var workMinutes: Long = 25
    private var breakMinutes: Long = 5

    // Android Media player
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This keeps the screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // Bind Graphics by ID
        textTimer = findViewById(R.id.textTimer)
        textStatus = findViewById(R.id.textStatus)
        editWorkDuration = findViewById(R.id.editWorkDuration)
        editIntervalBeforeBreak = findViewById(R.id.editIntervalBeforeBreak)
        editBreakDuration = findViewById(R.id.editBreakDuration)
        btnStart = findViewById(R.id.btnStart)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnStart.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                fermaMusica()
                btnStart.text = "PLAY" // YOU CAN CUSTOMIZE THIS TEXT!
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
        if (timeLeftInMillis == 0L) {
            workMinutes = editIntervalBeforeBreak.text.toString().toLongOrNull() ?: 25L
            breakMinutes = editBreakDuration.text.toString().toLongOrNull() ?: 5L
            gestisciModificheInput(false)
            timeLeftInMillis = workMinutes * 60 * 1000
            isWorkMode = true
            textStatus.text = "Pomodoro Timer starts!" // YOU CAN CUSTOMIZE THIS!
            textStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark)) 
        }
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }
            override fun onFinish() {
                timerRunning = false
                if (isWorkMode) {
                    textStatus.text = "Pause! Relax" // YOU CAN CUSTOMIZE THIS!
                    textStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_green_dark))
                    isWorkMode = false
                    timeLeftInMillis = breakMinutes * 60 * 1000
                    attivavibrazione()
                    riproduciMusica()
                    btnStart.text = "Stop Music" // YOU CAN CUSTOMIZE THIS TEXT!
                } else {
                    textStatus.text = "Time to focus!" // YOU CAN CUSTOMIZE THIS!
                    textStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_dark))
                    isWorkMode = true
                    timeLeftInMillis = workMinutes * 60 * 1000
                    fermaMusica()
                    btnStart.text = "PLAY" // YOU CAN CUSTOMIZE THIS TEXT!
                }
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
        btnStart.text = "PLAY" // YOU CAN CUSTOMIZE THIS TEXT!
        gestisciModificheInput(true)
    }

    private fun updateCountDownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        textTimer.text = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
    }

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
```

---

### 📷 Bonus Part 2: A Custom Icon

The only thing missing now is an app icon! Create a custom design (Canva is a great tool for this) at 512 x 512 px and save it as a PNG.

1. Right-click the `res` folder.
2. Click **New -> Image Asset**.
3. Leave the icon type and name as they are.
4. Click the folder icon next to the **Path** box and select your PNG file.
5. Scale it so your design fits entirely inside the safe zone (the black circle).
6. Click **Next**, then **Finish**.

Congratulations! You've just created a custom icon for your app. Now let's test it.

---

## 🚀 Building and Testing Your App

Now we are ready to install your Pomodoro app! 

### 📱 How to Use a Virtual Device (Emulator)
If you don't have an Android phone, use an emulator:
1. In the top right corner, click the **Device Manager** (the icon with a phone and an Android head).
2. Click the **Plus (+)** button.
3. Click **Create Virtual Device**.
4. Select a phone model (a medium-sized phone is recommended).
5. Click **Finish** and wait for the process to complete.
6. Once finished, click the **Play** button next to your virtual device and wait for the emulator to boot up.

### 📲 How to Use Your Physical Phone
1. Unlock your phone.
2. Connect it to your computer via USB.
3. On your phone, a prompt will appear. **Accept the USB Debugging / ADB request.**
4. To confirm it's connected, look at the top toolbar in Android Studio; you should see your phone's model number (e.g., *Samsung SM-A145R*).

---

### ⚠️ Checking for Errors

Before hitting build, go to the **Problems** tab at the bottom, switch to **Project Problems**, and click **Inspect Code**. 

If there are no errors, you can start building! If errors pop up, check here:
* **"XML declaration should precede all document content":** Right-click the error and click "Jump to source". Ensure that `<?xml version="1.0" encoding="utf-8"?>` is on the very first line of your XML file. Remove any empty lines or comments above it, then inspect the code again.
* **AAR Metadata error:** Go to `app -> build.gradle.kts` (the Module: app file). Change the `compileSdk` and `targetSdk` lines from 36 to 37. Click the **"Sync Now"** elephant icon in the top right.
* **"Failed to find Platform SDK with path: platforms;android-37.1":** Click the Settings gear (top right) -> SDK Manager. Select version 37.1 (Cinnamon), click Apply, confirm, and wait. Resync your project. If it persists, open `gradle.properties` and add `android.suppressUnsupportedCompileSdk=37.1` at the bottom. Sync and rebuild. 

> *Tip: If you encounter a new bug, leave a comment so we can add the fix here!*

---

## 🔨 Build the App

Click the green **Play** button at the top toolbar! 

The Daemon will gather your code, compile it into an APK, and install it directly onto your phone or emulator. Open the **LOGCAT** tab to watch the magic happen behind the scenes!

---

## 🐙 GitHub and Additional Info

The app is now complete! If you find a bug, please report it via GitHub Issues or in the comments. I will also upload a pre-built APK of my app on the GitHub Releases page.

Feel free to suggest modifications and features on GitHub!

Thank You,  
**Piedino Timido**
> *Info: The text you are reading is adjusted by AI, cause I'm not very good at writing in english, the original version is in my Codédex submission here:* https://www.codedex.io/community/monthly-challenge/submission/bHj8dk6DI78Hmu7nfInr
