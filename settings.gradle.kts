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
include(
    ":app",

    ":core:data",
    ":core:domain",
    ":core:model",
    ":core:ui",
    ":core:navigation",
    ":core:designsystem",

    ":feature:deck",
    ":feature:card"
)
