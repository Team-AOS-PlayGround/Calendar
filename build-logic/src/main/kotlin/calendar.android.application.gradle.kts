import com.calendar2023.configureHiltAndroid
import com.calendar2023.configureKotestAndroid
import com.calendar2023.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
