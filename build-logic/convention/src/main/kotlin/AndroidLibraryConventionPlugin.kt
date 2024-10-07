import com.android.build.gradle.LibraryExtension
import extensions.configureKotlinAndroid
import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.kotlin.plugin.parcelize")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig.targetSdk = 35
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true
                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix = path.split("""\W""".toRegex())
                    .drop(1).distinct().joinToString(separator = "_")
                    .lowercase() + "_"
                buildFeatures {
                    buildConfig = true
                }
                lint {
                    checkTestSources = true
                }
                configureKotlinAndroid(this)
            }

            dependencies {
                "implementation"(libs.findLibrary("kotlinx.collections").get())
                "implementation"(libs.findLibrary("kotlinx.coroutines").get())
                "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
                "androidTestImplementation"(kotlin("test"))
                "testImplementation"(kotlin("test"))
            }
        }
    }
}
