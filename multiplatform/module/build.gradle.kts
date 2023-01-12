android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.7.21"
}

kotlin {

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.Badoo.Reaktive.reaktive)
                implementation(Deps.Badoo.Reaktive.coroutinesInterop)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.ArkIvanov.MVIKotlin.rx)



                implementation(Deps.JetBrains.Kotlin.ktorClientContent)
                implementation(Deps.JetBrains.Kotlin.ktorClientCore)
                implementation(Deps.JetBrains.Kotlin.ktorClientLogging)
                implementation(Deps.JetBrains.Kotlin.ktorSerialization)
                implementation(Deps.JetBrains.Kotlin.kotlinxDateTime)

                implementation(Deps.Utils.log)
            }
        }
    }

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.ktorClientJS)
            }
        }
    }

    sourceSets {
        named("desktopMain") {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.ktorClientCIO)
            }
        }
    }

    sourceSets {
        named("androidMain") {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.ktorClientCIO)
            }
        }
    }

    sourceSets {
        named("iosMain") {
            dependencies {
                api(Deps.ArkIvanov.Decompose.decompose)
                api(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                api(Deps.ArkIvanov.Essenty.lifecycle)
                implementation(Deps.JetBrains.Kotlin.ktorClientCIO)
            }
        }

        named("macosMain") {
            dependencies {
                api(Deps.ArkIvanov.Decompose.decompose)
                api(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                api(Deps.ArkIvanov.Essenty.lifecycle)
                implementation(Deps.JetBrains.Kotlin.ktorClientCIO)
            }
        }
    }
}
