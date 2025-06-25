plugins {
    id("homes.library-conventions")
    id("homes.hilt-conventions")
    //TODO add?: id("homes.test-conventions")
}

android {
    defaultConfig {
        //TODO resourceConfigurations += setOf("sv", "en")
    }
}

dependencies {
    //TODO needed?: implementation(platform(libs.okhttp.bom))

    implementation(libs.annotations)
    implementation(libs.timber)
}