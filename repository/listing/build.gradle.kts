plugins {
    id("homes.library-conventions")
}

android {
    namespace = "com.omiwrench.homes.repository.listing"
}

dependencies {
    implementation(projects.data.backend)
}