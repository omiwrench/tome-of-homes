plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "com.omiwrench.homes.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://central.sonatype.com/repository/maven-snapshots/")
    google()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.google.ksp.gradle)
    implementation(libs.compose.gradle)
    implementation(libs.kotlin.serialization.gradle)
    implementation(libs.dagger.hilt.gradle)

    /** This is a hack to allow precompiled convention plugins access version catalog in a
    compile time safe way - see https://github.com/gradle/gradle/issues/15383 */
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location.path))
}