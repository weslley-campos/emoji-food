plugins {
    alias(libs.plugins.application.feature)
    alias(libs.plugins.library.compose)
}

android {
    namespace = "com.github.weslleystos.feature.search"
}
dependencies {
    implementation(project(":core:data"))
}
