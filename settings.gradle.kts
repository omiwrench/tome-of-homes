enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TomeOfHomes"

include(":app")
include(":library")
include(":library:ui")
include(":feature")
include(":feature:listings")
include(":library:resources")
include(":feature:listings:detail")
include(":data")
include(":library:molecule")
include(":repository")
include(":repository:listing")
include(":data:backend")
