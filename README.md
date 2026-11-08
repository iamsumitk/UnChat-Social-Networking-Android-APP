# UnChat

UnChat is a native Android app written in Java. Users sign up with a username, name, email, password, gender, birthdate, and avatar, then log in, pick interests, and browse a home screen with connections, notifications, and settings.

The app talks to a PHP backend (`login.php`, `signup.php`, `Interests.php`) over HTTPS. The backend code is not part of this repository.

This project was developed for learning purposes aroung 2021. It is a student project to practise Android development, and it is not intended for production use.

## Project layout

```
.
├── unChat/                  # The Android app (Gradle module :app)
│   ├── app/                 # Source code, resources, manifest
│   ├── gradle/wrapper/      # Gradle wrapper
│   └── ...
└── unChat Dependencies/     # Practice/sample Android projects (not part of the app build)
```

## Tech stack

- Java 8 source level, Android (min SDK 23, target/compile SDK 31)
- Android Gradle Plugin 7.0.2, Gradle 7.0.2 (wrapper)
- AndroidX AppCompat, ConstraintLayout, Preference, RecyclerView
- Material Components
- Volley for HTTP requests
- CircleImageView for avatars

## Requirements

- [Android Studio](https://developer.android.com/studio) (Arctic Fox or newer recommended)
- JDK 11 (Gradle 7.0.2 does not run on newer JDKs)
- Android SDK Platform 31 and Build-Tools 31.0.0 (install from the SDK Manager)
- Gradle 7.0.2 via the wrapper. Keep `unChat/gradle/wrapper/gradle-wrapper.properties` pointing at `gradle-7.0.2-bin.zip`. Newer Gradle versions don't work with this project's Android Gradle Plugin 7.0.2, so don't accept IDE prompts to upgrade the wrapper.

## Setup

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd "UnChat Android Application/unChat"
   ```

2. Open the `unChat` folder in Android Studio. It creates `local.properties` with your SDK path automatically.

3. Build and run the app from Android Studio, or from the command line.

   Command line, Linux/macOS (set `JAVA_HOME` to your JDK 11 and `ANDROID_HOME` to your Android SDK):

   ```bash
   cd unChat
   JAVA_HOME=/path/to/jdk11 ANDROID_HOME=/path/to/Android/Sdk ./gradlew assembleDebug
   ```

   Command line, Windows:

   ```bat
   cd unChat
   gradlew.bat assembleDebug
   ```

   The debug APK is written to `unChat/app/build/outputs/apk/debug/app-debug.apk`.

4. Install on a phone (optional):

   - On the phone, enable **Developer options**  then turn on **USB debugging**.
   - Connect the phone by USB, allow the debugging prompt, and check it appears:

     ```bash
     adb devices
     adb install -r unChat/app/build/outputs/apk/debug/app-debug.apk
     ```

   The phone needs internet access, because the app calls the backend.


## Backend URL

The app calls the backend at the URL set in `unChat/app/build.gradle`:

```groovy
buildConfigField "String", "BASE_URL", "\"https://wallflowernetwork.000webhostapp.com/\""
```

The build exposes it to the code as `BuildConfig.BASE_URL`. To use a different backend, change that line and rebuild.
