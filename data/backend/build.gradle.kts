plugins {
    id("homes.data-conventions")
}

android {
    namespace = "com.omiwrench.homes.data.backend"
}

dependencies {
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.logging.jvm)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client)
    implementation(libs.ktor.client.resources)
    implementation(libs.ktor.client.content.negotiation)
}