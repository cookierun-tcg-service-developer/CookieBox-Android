pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
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

rootProject.name = "CookieBox"
include(":app")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:ui")
include(":core:navigation")
include(":feature:deck")
include(":feature:card")
include(":core:designsystem")
