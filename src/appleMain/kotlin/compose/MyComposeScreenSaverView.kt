@file:OptIn(ExperimentalForeignApi::class)

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.ScreenSaver.ScreenSaverView

class MyComposeScreenSaverView : KotlinScreenSaverView() {
    private lateinit var screenSaverView: ScreenSaverView
    private lateinit var composeContentHolder: ComposeContentHolder

    override fun init(screenSaverView: ScreenSaverView, isPreview: Boolean) {
        this.screenSaverView = screenSaverView
        screenSaverView.animationTimeInterval = 1 / 60.0
    }

    override fun startAnimation() {
        super.startAnimation()

        val screenWidth = screenSaverView.frame.useContents { this.size.width }
        val screenHeight = screenSaverView.frame.useContents { this.size.height }
        composeContentHolder = ComposeContentHolder(
            density = requireNotNull(screenSaverView.window).backingScaleFactor.toFloat(),
            size = DpSize(screenWidth.dp, screenHeight.dp),
        )
        screenSaverView.addSubview(composeContentHolder.view)

        composeContentHolder.setContent {
            ScreenSaverContent()
        }
    }
}
