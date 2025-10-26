# Kotlin screen saver template for macOS

See also: [KotlinLogo-ScreenSaver](https://github.com/zsmb13/KotlinLogo-ScreenSaver) for a more complex implementation and more references.

### Contents:

* KotlinScreenSaver: an Xcode screen saver project
* `src/appleMain`:
  * `KotlinScreenSaverView`: an abstract screen saver class that the Swift code delegates calls to, choose the concrete implementation used at the top of this file
  * `MyAppKitScreenSaverView`: demo of AppKit being used to put content on the screen with Kotlin code
  * `MyComposeScreenSaverView`: demo of Compose Multiplatform rendering on macOS native target
  * `Main.kt`: a macOS native main function to run the Compose code on native, in a window, without needing to package and load a screen saver
* `src/commonMain` contains the shared Compose UI code
* `src/jvmMain` contains a JVM entry point to run the Compose code as a desktop app, with [Compose Hot Reload](https://github.com/JetBrains/compose-hot-reload) configured for easier editing 

### Running the apps:

Build the screen saver:

```
cd KotlinScreenSaver
xcodebuild -scheme KotlinScreenSaver build
```

Run the native app:

```
./gradlew runDebugExecutableMacosArm64
```

Run the JVM desktop app with Compose Hot Reload:

```
./gradlew hotRunJvm --mainClass "MainKt" --auto
```
