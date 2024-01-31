plugins {
    id("calendar.android.library")
}

android {
    namespace = "com.bluesky.data"
}

dependencies {
    implementation(libs.androidx.datastore)
    implementation(project(mapOf("path" to ":domain")))

//    implementation(libs.calendar.compose)
    implementation(projects.composecalendar)
    implementation(libs.kotlinx.serialization.json)
}