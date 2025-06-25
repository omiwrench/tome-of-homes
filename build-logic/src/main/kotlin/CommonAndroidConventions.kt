import org.gradle.api.Project
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

internal fun Project.configureCommonAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = AppConfig.compileSdk

        buildFeatures {
            buildConfig = true
        }

        defaultConfig {
            minSdk = AppConfig.minSdk
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }
}