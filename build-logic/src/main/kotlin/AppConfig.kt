@file:Suppress("ConstPropertyName")

import org.gradle.api.JavaVersion


object AppConfig {
    const val compileSdk = 36
    const val targetSdk = 36
    const val minSdk = 30

    const val applicationId = "com.omiwrench.homes"
    const val versionCode = 1
    const val versionName = "1.0"

    object Debug {
        // Specialized debug constants go here
    }
    object Sprint {
        // Specialized sprint constants go here
    }
    object Release {
        // Specialized release constants go here
    }
}