plugins {
    id("homes.common-conventions")
    id("homes.compose-conventions")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
}

dependencies {
    implementation(project(":library:ui"))
    implementation(project(":library:resources"))
    implementation(project(":library:molecule"))

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}