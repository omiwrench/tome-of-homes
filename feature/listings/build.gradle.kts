plugins {
    id("homes.feature-conventions")
}

android {
    namespace = "com.omiwrench.homes.feature.listings"
}

dependencies {
    implementation(projects.repository.listing)
}