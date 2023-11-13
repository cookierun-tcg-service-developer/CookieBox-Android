package com.example.cookiebox

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureTestAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {
    with(commonExtension) {
        defaultConfig {
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    dependencies {
        "testImplementation"(libs.findLibrary("test.junit").get())
        "androidTestImplementation"(libs.findLibrary("test.android.junit").get())
        "androidTestImplementation"(libs.findLibrary("test.espresso").get())
    }
}
