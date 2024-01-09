plugins {
    id("calendar.android.library")
}

android {
    namespace = "com.bluesky.domain"
}

dependencies {
    implementation(libs.calendar.compose)
}