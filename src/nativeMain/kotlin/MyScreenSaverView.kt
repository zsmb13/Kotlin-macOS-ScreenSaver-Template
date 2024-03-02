@file:OptIn(ExperimentalForeignApi::class)

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.AppKit.*
import platform.Foundation.NSMakeRect
import platform.ScreenSaver.ScreenSaverView


class MyScreenSaverView : KotlinScreenSaverView() {
    override val configureSheet: NSWindow? = null

    private lateinit var textView: NSTextView
    
    override fun init(screenSaverView: ScreenSaverView, isPreview: Boolean) {
        super.init(screenSaverView, isPreview)
        screenSaverView.animationTimeInterval = 1 / 60.0

        val screenWidth = view.frame.useContents { this.size.width }
        val screenHeight = view.frame.useContents { this.size.height }
        
        val width = 150.0
        val height = 30.0
        
        textView = NSTextView().apply {
            frame = NSMakeRect(x = screenWidth / 2 - width / 2, y = screenHeight / 2 - height / 2, w = width, h = height)
            drawsBackground = false
            textColor = NSColor.whiteColor
            font = NSFont.userFontOfSize(25.0)
            alignment = NSTextAlignmentCenter
            string = "Hello Kotlin"
        }
        view.addSubview(textView)
    }

    override fun animateOneFrame() {
        // Update UI
    }
}
