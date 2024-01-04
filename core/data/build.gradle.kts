plugins {
    id("cookiebox.android.library")
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.datastore)

    implementation(libs.google.gson)

    implementation(libs.libraries.retrofit)
    implementation(libs.libraries.okhttp)
    implementation(libs.libraries.okhttp.logging.interceptor)

    implementation(libs.libraries.moshi.converter)
    implementation(libs.libraries.moshi)
    ksp(libs.libraries.moshi.codegen)
}
