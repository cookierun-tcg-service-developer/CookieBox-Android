plugins {
    id("cookiebox.android.application")
}

android {
    namespace = "com.example.cookiebox"

    defaultConfig {
        applicationId = "com.example.cookiebox"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:card"))
    implementation(project(":feature:deck"))
}
