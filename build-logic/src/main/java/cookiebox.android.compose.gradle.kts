import com.example.cookiebox.android
import com.example.cookiebox.configureComposeAndroid
import com.example.cookiebox.libs

android {
    configureComposeAndroid(this)
}

dependencies {
    "implementation"(libs.findLibrary("libraries.coil").get())
    "implementation"(libs.findLibrary("libraries-bottomsheetdialog-compose").get())
}
