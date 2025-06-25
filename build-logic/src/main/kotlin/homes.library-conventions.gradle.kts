import com.android.build.api.dsl.LibraryExtension

plugins {
    `android-library`
    `kotlin-android`
    id("homes.kotlin-conventions")
    id("homes.hilt-conventions")
}

extensions.configure<LibraryExtension> {
    configureCommonAndroid(this)

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
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.android)

    coreLibraryDesugaring(libs.android.desugar)
}