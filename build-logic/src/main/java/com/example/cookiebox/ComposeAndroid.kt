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
            // TODO: versionCatalog 에서 compiler version 관리
            kotlinCompilerExtensionVersion = "1.4.3"
        }

        dependencies {
            "implementation"(libs.findLibrary("compose").get())
            "implementation"(libs.findLibrary("compose-tooling").get())
            "implementation"(libs.findLibrary("compose-material").get())
            "implementation"(libs.findLibrary("compose-preview").get())
        }
    }
}
