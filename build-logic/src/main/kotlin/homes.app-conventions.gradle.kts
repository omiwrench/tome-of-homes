import com.android.build.api.dsl.ApplicationExtension
import gradle.kotlin.dsl.accessors._20b42a3b8999007a5928bebdfb1e475b.implementation
import gradle.kotlin.dsl.accessors._20b42a3b8999007a5928bebdfb1e475b.ksp

plugins {
    `kotlin-android`
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("homes.kotlin-conventions")
}

extensions.configure<ApplicationExtension> {
    configureCommonAndroid(this)

    defaultConfig {
        targetSdk = AppConfig.targetSdk
    }

    buildTypes {
        debug {
            (this as ExtensionAware).extra["alwaysUpdateBuildId"] = false
        }
        create("sprint") {
            matchingFallbacks += listOf("release", "debug")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "../proguard-rules.pro")
        }
        release {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "../proguard-rules.pro")
        }
    }
}

dependencies {
    ksp(libs.dagger.compiler)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.dagger)
    implementation(libs.dagger.hilt)

    implementation(libs.androidx.navigation.compose)

    coreLibraryDesugaring(libs.android.desugar)
}