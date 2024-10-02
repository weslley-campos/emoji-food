import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * A Gradle plugin for configuring Dagger Hilt in Android projects.
 *
 * This plugin simplifies the addition of dependencies and configurations
 * required to use Dagger Hilt in an Android project.
 *
 * It applies the KSP (Kotlin Symbol Processing) and Dagger Hilt Android plugins,
 * and adds the Hilt runtime and compilation dependencies.
 */
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }
            dependencies {
                "implementation"(libs.findBundle("hilt").get())
                "ksp"(libs.findBundle("hilt.compiler").get())
            }
        }
    }
}
