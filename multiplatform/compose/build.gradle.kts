plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}
dependencies {
    implementation("androidx.compose.ui:ui:1.3.3")
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":multiplatform:module"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Decompose.extensionsCompose)
                api(Deps.Utils.loadImage)
            }
        }

        named("androidMain") {
            dependencies {
                // Workaround for https://github.com/JetBrains/compose-jb/issues/2340
                implementation("androidx.compose.foundation:foundation:${Deps.JetpackComposeWorkaround.VERSION}")
            }
        }
    }
}
