import com.calendar2023.configureCoroutineAndroid
import com.calendar2023.configureHiltAndroid
import com.calendar2023.configureKotest
import com.calendar2023.configureKotlinAndroid

plugins{
    id("com.android.library")
    id("calendar.verify.detekt")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()
