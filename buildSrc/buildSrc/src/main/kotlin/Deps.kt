// We store Kotlin and Compose versions in gradle.properties to
// be able to override them on CI.
// You probably won't need this, so you can get rid of `project` in this file.
import org.gradle.api.Project

lateinit var properties: Map<String, *>

fun initDeps(project: Project) {
    properties = project.properties
}

object Deps {
    object JetpackComposeWorkaround {
        // Workaround for https://github.com/JetBrains/compose-jb/issues/2340
        val VERSION: String = "1.3.1"
    }

    object JetBrains {
        object Kotlin {
            private val VERSION get() = properties["kotlin.version"]
            private val ktorVersion get() = "2.2.1"
            val gradlePlugin get() = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VERSION"
            val ktorClientCore get() = "io.ktor:ktor-client-core:$ktorVersion"
            val ktorClientContent get() = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
            val ktorSerialization get() = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
            val ktorClientLogging get() = "io.ktor:ktor-client-logging:$ktorVersion"
            val ktorClientCIO get() = "io.ktor:ktor-client-cio:$ktorVersion"
            val ktorClientJS get() = "io.ktor:ktor-client-js:$ktorVersion"
            val kotlinxDateTime get() = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
        }

        object Coroutines {
            private val VERSION get() = "1.6.4"
            val swing get() = "org.jetbrains.kotlinx:kotlinx-coroutines-swing:$VERSION"
        }

        object Compose {
            private val VERSION get() = properties["compose.version"]
            val gradlePlugin get() = "org.jetbrains.compose:compose-gradle-plugin:$VERSION"
        }
    }

    object Android {
        object Tools {
            object Build {
                const val gradlePlugin = "com.android.tools.build:gradle:7.3.1"
            }
        }
    }

    object AndroidX {
        object AppCompat {
            const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.6.1"
        }
    }

    object ArkIvanov {
        object MVIKotlin {
            private const val VERSION = "3.0.0"
            const val rx = "com.arkivanov.mvikotlin:rx:$VERSION"
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:$VERSION"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$VERSION"
            const val mvikotlinLogging = "com.arkivanov.mvikotlin:mvikotlin-logging:$VERSION"
            const val mvikotlinTimeTravel = "com.arkivanov.mvikotlin:mvikotlin-timetravel:$VERSION"
            const val mvikotlinExtensionsReaktive = "com.arkivanov.mvikotlin:mvikotlin-extensions-reaktive:$VERSION"
        }

        object Decompose {
            private const val VERSION = "1.0.0-beta-02"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val extensionsCompose = "com.arkivanov.decompose:extensions-compose-jetbrains:1.0.0-beta-02-native-compose"
        }

        object Essenty {
            private const val VERSION = "0.6.0"
            const val lifecycle = "com.arkivanov.essenty:lifecycle:$VERSION"
        }
    }

    object Utils {
        const val loadImage = "io.github.qdsfdhvh:image-loader:1.2.5"
        const val log = "io.github.aakira:napier:2.6.1"
    }

    object Badoo {
        object Reaktive {
            private const val VERSION = "1.2.1"
            const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
            const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
            const val utils = "com.badoo.reaktive:utils:$VERSION"
            const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
        }
    }
}
