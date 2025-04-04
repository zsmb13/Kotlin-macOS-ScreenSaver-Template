package compose

import ScreenSaverContent
import androidx.compose.ui.window.Window
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AppKit.NSApp

// A standalone main function to run the Compose content on native macOS
@OptIn(ExperimentalForeignApi::class)
fun main() {
    Window("Compose macOS native") {
        ScreenSaverContent()
    }

    NSApp?.run()
}
