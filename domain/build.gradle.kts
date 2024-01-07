plugins {
    id("calendar.android.library")
}

android {
    namespace = "com.bluesky.domain"
}

dependencies {
    implementation(projects.data)
    implementation(libs.calendar.compose)
}