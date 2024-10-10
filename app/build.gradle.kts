plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.application.compose)
    alias(libs.plugins.application.hilt)
    alias(libs.plugins.application.detekt)
}

android {
    namespace = "com.github.weslleystos.navigation"

    defaultConfig {
        applicationId = "com.github.weslleystos.navigation"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:home"))
    implementation(project(":feature:orders"))
    implementation(project(":feature:search"))
    // Base
    implementation(libs.androidx.core.ktx)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
