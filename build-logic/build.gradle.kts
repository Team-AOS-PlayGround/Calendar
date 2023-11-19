plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.verify.detektPlugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "calendar.android.hilt"
            implementationClass = "calendar.android.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "calendar.kotlin.hilt"
            implementationClass = "calendar.android..HiltKotlinPlugin"
        }
    }
}