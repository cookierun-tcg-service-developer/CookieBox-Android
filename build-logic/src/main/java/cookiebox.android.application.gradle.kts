import com.example.cookiebox.android
import com.example.cookiebox.configureComposeAndroid
import com.example.cookiebox.configureHiltAndroid
import com.example.cookiebox.configureKotlinAndroid
import com.example.cookiebox.configureTestAndroid
import com.example.cookiebox.libs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    configureKotlinAndroid(this)
    configureComposeAndroid(this)
    configureTestAndroid(this)
}

configureHiltAndroid()

dependencies {
    "implementation"(project(":core:navigation"))

    "implementation"(libs.findLibrary("androidx.core").get())
    "implementation"(libs.findLibrary("androidx.appcompat").get())
    "implementation"(libs.findLibrary("androidx.navigation").get())

    "implementation"(libs.findLibrary("google.material").get())
}
