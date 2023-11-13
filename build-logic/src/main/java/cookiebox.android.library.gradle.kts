import com.example.cookiebox.android
import com.example.cookiebox.configureHiltAndroid
import com.example.cookiebox.configureKotlinAndroid
import com.example.cookiebox.configureTestAndroid

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    configureTestAndroid(this)
    configureKotlinAndroid(this)
}

configureHiltAndroid()
