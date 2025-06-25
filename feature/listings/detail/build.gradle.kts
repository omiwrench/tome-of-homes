plugins {
    id("homes.feature-conventions")
}

android {
    namespace = "com.omiwrench.homes.feature.listings.detail"
}

dependencies {
    implementation(projects.repository.listing)

    implementation(libs.coil)
}