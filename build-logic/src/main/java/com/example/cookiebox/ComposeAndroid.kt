package com.example.cookiebox

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureComposeAndroid(commonExtension: CommonExtension<*, *, *, *, *>) {
    with(commonExtension) {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().toString()
        }

        dependencies {
            "implementation"(libs.findLibrary("compose").get())
            "implementation"(libs.findLibrary("compose-tooling").get())
            "implementation"(libs.findLibrary("compose-material").get())
            "implementation"(libs.findLibrary("compose-preview").get())
        }
    }
}
