plugins {
    id("homes.library-conventions")
    id("homes.compose-conventions")
    //alias(libs.plugins.molecule)
}

android {
    namespace = "com.omiwrench.homes.library.molecule"
}

dependencies {
    implementation(libs.molecule.runtime)
}