plugins {
    alias(libs.plugins.application.feature)
    alias(libs.plugins.library.compose)
    alias(libs.plugins.application.detekt)
}

android {
    namespace = "com.github.weslleystos.feature.orders"
}
