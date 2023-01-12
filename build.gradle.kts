//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("7.3.1").apply(false)
//    id("com.android.library").version("7.3.1").apply(false)
//    kotlin("android").version("1.7.10").apply(false)
//    kotlin("multiplatform").version("1.7.10").apply(false)
//    id("com.android.application") version "7.3.1" apply false
//    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
//}
//
plugins {
    `kotlin-dsl`
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    afterEvaluate {
        // Workaround for https://youtrack.jetbrains.com/issue/KT-52776
        rootProject.extensions.findByType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>()?.apply {
            versions.webpackCli.version = "4.10.0"
        }
    }
}
