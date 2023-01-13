plugins {
    id("com.android.library")
    id("kotlin-multiplatform")
    kotlin("native.cocoapods")
}

initDeps(project)

kotlin {
    jvm("desktop")
    android()
    iosX64()
    macosX64()
    iosArm64()
    macosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        framework {
            baseName = "NexleModule"
            export(Deps.ArkIvanov.Decompose.decompose)
            export(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
            export(Deps.ArkIvanov.Essenty.lifecycle)
        }
    }

    js(IR) {
        browser()
    }

    sourceSets {
        create("iosMain") {
            dependsOn(getByName("commonMain"))
        }

        create("macosMain") {
            dependsOn(getByName("iosMain"))
        }

        getByName("iosX64Main") {
            dependsOn(getByName("iosMain"))
        }

        getByName("macosX64Main") {
            dependsOn(getByName("macosMain"))
        }

        getByName("macosArm64Main") {
            dependsOn(getByName("macosMain"))
        }

        getByName("iosSimulatorArm64Main") {
            dependsOn(getByName("iosMain"))
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
