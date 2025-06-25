plugins {
    id("homes.library-conventions")
}

android {
    namespace = "com.omiwrench.homes.feature"
}

dependencies {
    implementation(projects.repository.listing)
}