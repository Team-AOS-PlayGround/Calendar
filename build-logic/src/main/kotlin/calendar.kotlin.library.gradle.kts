import com.calendar2023.configureKotest
import com.calendar2023.configureKotlin

plugins {
    kotlin("jvm")
    id("calendar.verify.detekt")
}

configureKotlin()
configureKotest()