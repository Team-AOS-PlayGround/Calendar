plugins {
    id("calendar.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    namespace = "com.bluesky.calendar"

    defaultConfig {
        applicationId = "com.bluesky.calendar"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.presentation)
}