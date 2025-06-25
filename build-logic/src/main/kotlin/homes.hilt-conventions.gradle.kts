plugins {
    `android-library`
    `kotlin-android`
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("homes.kotlin-conventions")
}

ksp {
    arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
}

dependencies {
    implementation(libs.javax.inject)

    ksp(libs.dagger.compiler)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.dagger)
    implementation(libs.dagger.hilt)
}