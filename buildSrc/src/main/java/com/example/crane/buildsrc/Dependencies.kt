package com.example.crane.buildsrc

object Versions {
    const val ktLint = "0.45.2"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.2"
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"

    object Accompanist {
        private const val version = "0.26.2-beta"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val placeHolder = "com.google.accompanist:accompanist-placeholder:$version"
    }

    object Kotlin {
        private const val version = "1.7.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
        const val serializationKotlin = "org.jetbrains.kotlin:kotlin-serialization:$version"


        object Coroutines {
            private const val version = "1.6.3"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.6.0"
        }

        const val appcompat = "androidx.appcompat:appcompat:1.4.2"

        object Compose {
            const val compilerVersion = "1.3.1"
            const val snapshot = ""
            const val version = "1.3.0-beta02"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val material = "androidx.compose.material:material:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val iconExtended = "androidx.compose.material:material-icons-extended:$version"
            const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha02"
        }

        object Core {
            private const val version = "1.9.0"
            const val coreKtx = "androidx.core:core-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.5.0"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.5.2"
            const val navigation = "androidx.navigation:navigation-compose:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object ConstraintLayout {
        private const val version = "1.0.1"
        const val constraintLayoutCompose =
            "androidx.constraintlayout:constraintlayout-compose:$version"
    }

    object Hilt {
        private const val hilt = "2.43"
        private const val hiltComposeNavigation = "1.0.0"

        const val composeNavigation =
            "androidx.hilt:hilt-navigation-compose:${hiltComposeNavigation}"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${hilt}"
        const val android = "com.google.dagger:hilt-android:${hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${hilt}"
        const val testing = "com.google.dagger:hilt-android-testing:${hilt}"
    }

    object Room {
        private const val version = "2.4.3"
        const val extensions = "androidx.room:room-ktx:$version"
        const val room  = "androidx.room:room-runtime:$version"
        const val kapt = "androidx.room:room-compiler:$version"

    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object Coil {
        private const val version = "2.2.1"
        const val coilCompose = "io.coil-kt:coil-compose:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val serializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object OkHttps {
        private const val version = "4.10.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
    }
}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo =
        "https://androidx.dev/snapshots/builds/${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}
