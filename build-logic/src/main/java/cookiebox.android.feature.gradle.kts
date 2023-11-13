import com.example.cookiebox.configureHiltAndroid
import com.example.cookiebox.libs

plugins {
    id("cookiebox.android.library")
    id("cookiebox.android.compose")
}

configureHiltAndroid()

dependencies {
    "implementation"(project(":core:model"))
    "implementation"(project(":core:domain"))
    "implementation"(project(":core:ui"))
    "implementation"(project(":core:navigation"))

    "implementation"(libs.findLibrary("androidx.core").get())
    "implementation"(libs.findLibrary("androidx.appcompat").get())
    "implementation"(libs.findLibrary("androidx.navigation").get())
    "implementation"(libs.findLibrary("androidx.viewmodel").get())

    "implementation"(libs.findLibrary("google.material").get())

    "implementation"(libs.findLibrary("libraries.coil").get())
}
