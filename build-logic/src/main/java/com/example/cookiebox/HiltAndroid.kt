package com.example.cookiebox

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {
    with(pluginManager) {
        apply("com.google.dagger.hilt.android")
        apply("com.google.devtools.ksp")
    }

    dependencies {
        "implementation"(libs.findLibrary("google-hilt").get())
        "ksp"(libs.findLibrary("google-hilt-compiler").get())
    }
}
