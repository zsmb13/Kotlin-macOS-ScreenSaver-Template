import appkit.MyAppKitScreenSaverView
import platform.AppKit.NSWindow
import platform.Foundation.NSBundle
import platform.ScreenSaver.ScreenSaverView

// Choose implementation here
fun create(): KotlinScreenSaverView = MyComposeScreenSaverView() // or MyAppKitScreenSaverView()

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

    open fun animateOneFrame() {}

    open fun startAnimation() {}

    open val configureSheet: NSWindow? = null
}
