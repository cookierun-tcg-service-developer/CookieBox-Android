package com.example.cookiebox

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {
    with(pluginManager) {
        apply("com.google.dagger.hilt.android")
        // TODO: Kapt에서 KSP로 마이그레이션
        apply("org.jetbrains.kotlin.kapt")
    }

    dependencies {
        "implementation"(libs.findLibrary("google-hilt").get())
        // TODO: Kapt에서 KSP로 마이그레이션
        "kapt"(libs.findLibrary("google-hilt-compiler").get())
    }
}
