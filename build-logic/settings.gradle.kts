@file:Suppress("UnstableApiUsage")
/**
 * @see <a href="https://github.com/android/nowinandroid/blob/main/build-logic/README.md">Convention Plugins</a>
 * Convention plugins, used to keep a single source of truth for common module configurations.
 */

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
