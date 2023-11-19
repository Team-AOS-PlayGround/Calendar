import com.calendar2023.configureHiltAndroid
import com.calendar2023.libs

plugins {
    id("calendar.android.library")
    id("calendar.android.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
configureHiltAndroid()

dependencies {

    val libs = project.extensions.libs
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())

    implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
    implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
}