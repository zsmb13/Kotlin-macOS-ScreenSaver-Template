import ScreenSaver
import KotlinSaver

class KotlinScreenSaver : ScreenSaverView {
    let kotlinScreenSaverView = KotlinScreenSaverViewKt.create()

    override init?(frame: NSRect, isPreview: Bool) {
        super.init(frame: frame, isPreview: isPreview)
        kotlinScreenSaverView.doInit(screenSaverView: self, isPreview: isPreview)
        DistributedNotificationCenter.default.addObserver(
            self,
            selector: #selector(KotlinScreenSaver.willStop(_:)),
            name: Notification.Name("com.apple.screensaver.willstop"),
            object: nil
        )
    }

    @objc func willStop(_ aNotification: Notification) {
        if (!isPreview) {
            NSApplication.shared.terminate(nil)
        }
    }

    required init?(coder decoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    override func animateOneFrame() {
        super.animateOneFrame()
        kotlinScreenSaverView.animateOneFrame()
    }

    override var hasConfigureSheet: Bool {
        kotlinScreenSaverView.configureSheet != nil
    }
    override var configureSheet: NSWindow? {
        kotlinScreenSaverView.configureSheet
    }
}
