plugins {
    id("calendar.android.library")
}

android {
    namespace = "com.bluesky.data"
}

dependencies {
    implementation(libs.androidx.datastore)
    implementation(project(mapOf("path" to ":domain")))
}