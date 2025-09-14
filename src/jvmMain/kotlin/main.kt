import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    application {
        val windowState = rememberWindowState(width = 800.dp, height = 600.dp)
        Window(
            title = "KotlinLogo JVM",
            onCloseRequest = ::exitApplication,
            state = windowState,
            alwaysOnTop = true,
        ) {
            ScreenSaverContent()
        }
    }
}
