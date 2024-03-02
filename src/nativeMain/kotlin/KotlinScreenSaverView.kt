import platform.AppKit.NSWindow
import platform.Foundation.NSBundle
import platform.ScreenSaver.ScreenSaverView

fun create(): KotlinScreenSaverView = MyScreenSaverView()

abstract class KotlinScreenSaverView {
    protected lateinit var view: ScreenSaverView
        private set

    protected lateinit var bundle: NSBundle
        private set

    protected var isPreview = false
        private set

    open fun init(screenSaverView: ScreenSaverView, isPreview: Boolean) {
        this.view = screenSaverView
        this.bundle = NSBundle.bundleWithIdentifier("com.example.KotlinScreenSaver")!!
        this.isPreview = isPreview
    }

    abstract fun animateOneFrame()

    open val configureSheet: NSWindow? = null
}
