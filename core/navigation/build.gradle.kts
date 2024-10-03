plugins {
    alias(libs.plugins.application.library)
    alias(libs.plugins.application.hilt)
}

android {
    namespace = "com.github.weslleystos.navigation"
    compileSdk = 34

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.compose.navigation)
}
