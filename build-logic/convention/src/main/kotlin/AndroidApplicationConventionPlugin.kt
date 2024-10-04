import com.android.build.api.dsl.ApplicationExtension
import extensions.configureKotlinAndroid
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.kotlin.plugin.parcelize")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = 35
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                defaultConfig.vectorDrawables.useSupportLibrary = true
                configureKotlinAndroid(this)
                buildFeatures {
                    buildConfig = true
                }
                lint {
                    checkTestSources = true
                }
            }

            dependencies {
                "implementation"(libs.findBundle("base").get())
            }
        }
    }
}
