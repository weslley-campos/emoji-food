import com.android.build.api.dsl.ApplicationExtension
import extensions.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * A Gradle plugin that configures Android Compose for a project.
 * This plugin applies necessary Kotlin and Android plugins, and sets up Compose-related configurations.
 *
 * Key features:
 * - Applies Kotlin Compose plugin
 * - Configures Android Navigation with Safe Args
 *
 * The plugin leverages bundles from the Version Catalog to efficiently manage and group related dependencies,
 * ensuring consistent versioning across the project.
 *
 * See [Compose Compiler Gradle plugin](https://developer.android.com/develop/ui/compose/compiler)
 */
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("androidx.navigation.safeargs.kotlin")
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }
}
