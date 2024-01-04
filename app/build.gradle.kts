import java.io.FileInputStream
import java.util.Properties

plugins {
    id("cookiebox.android.application")
}

android {
    namespace = "com.example.cookiebox"

    defaultConfig {
        applicationId = "com.example.cookiebox"
        versionCode = 1
        versionName = "1.0"

        buildConfigField(
            "String",
            "BASE_URL",
            getApiKey("BASE_URL")
        )
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":feature:card"))
    implementation(project(":feature:deck"))

    implementation(libs.libraries.retrofit)
    implementation(libs.libraries.okhttp)
    implementation(libs.libraries.okhttp.logging.interceptor)

    implementation(libs.libraries.moshi.converter)
    implementation(libs.libraries.moshi)
    ksp(libs.libraries.moshi.codegen)
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}
