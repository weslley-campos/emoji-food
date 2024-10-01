import extensions.libs
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

/**
 * A Gradle plugin that configures the Detekt static code analysis tool for Android projects.
 * This plugin applies and configures the Detekt plugin with predefined settings.
 *
 * Check the link to see how to configure Detekt if different options are needed
 *
 * See [Options for detekt configuration closure](https://detekt.dev/docs/gettingstarted/gradle#options-for-detekt-configuration-closure)
 *
 * Detekt supports 4 different types of output reporting formats.
 *
 * See [Detekt reporting](https://detekt.dev/docs/introduction/reporting)
 */
class AndroidDetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }
            configureDetekt()
        }
    }

    private fun Project.configureDetekt() {
        extensions.getByType<DetektExtension>().apply {
            // preconfigure defaults.
            buildUponDefaultConfig = true
            // To enable or disable auto formatting.
            autoCorrect = true
            // To enable or disable parallel execution of detekt on multiple submodules.
            parallel = true
            // point to your custom config defining rules to run, overwriting default behavior.
            config.setFrom(files("$rootDir/detekt-config.yml"))
        }

        tasks.withType<Detekt>().configureEach {
            reports {
                md.required.set(true)
            }
        }

        dependencies {
            "detektPlugins"(libs.findLibrary("detekt.formatting").get())
        }
    }
}
