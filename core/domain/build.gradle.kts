plugins {
    id("cookiebox.android.library")
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(project(":core:data"))

}
