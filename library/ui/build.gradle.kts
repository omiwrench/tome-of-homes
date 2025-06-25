plugins {
    id("homes.compose-conventions")
}

android {
    namespace = "com.omiwrench.homes.library.ui"
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling)
}