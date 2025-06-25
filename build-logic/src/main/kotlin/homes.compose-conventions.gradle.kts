import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("homes.library-conventions")
    id("org.jetbrains.kotlin.plugin.compose")
}

//TODO needed?
//android {
//    buildFeatures {
//        compose = true
//    }
//}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.addAll(listOf(
            "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
            "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
            "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
        ))
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
}