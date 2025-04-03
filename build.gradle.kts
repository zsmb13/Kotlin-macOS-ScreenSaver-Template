import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    val xcf = XCFramework("KotlinSaver")

    val targets = listOf(macosX64(), macosArm64())
    targets.forEach { target ->
        target.binaries.framework {
            binaryOption("bundleId", "com.example.KotlinScreenSaver")
            baseName = "KotlinSaver"
            isStatic = true
            xcf.add(this)
        }
    }

    jvm {
        binaries {
            executable {
                mainClass.set("MainKt")
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.coroutines.core)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }

    targets.forEach {
        it.binaries {
            executable {
                entryPoint = "compose.main"
            }
        }
    }
}
