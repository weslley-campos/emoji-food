import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.github.weslleystos.android.library")
                apply("com.github.weslleystos.android.hilt")
            }

            dependencies {
                "implementation"(project(":core:navigation"))
            }
        }
    }
}