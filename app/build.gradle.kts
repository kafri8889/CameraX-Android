plugins {
    id("idea")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.anafthdev.camerax"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anafthdev.camerax"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true

            buildConfigField("String", "API_BASE_URL", "\"https://dailycost.my.id/\"")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            kotlinOptions {
                freeCompilerArgs += listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-Xjvm-default=all"
                )
            }
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true

            buildConfigField("String", "API_BASE_URL", "\"https://dailycost.my.id/\"")

            kotlinOptions {
                freeCompilerArgs += listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-Xjvm-default=all"
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    val kotlin_version by extra("1.9.0")
    val compose_version by extra("1.5.0")
    val lifecycle_version by extra("2.6.2")
    val accompanist_version by extra("0.32.0")
    val camerax_version by extra("1.3.0-alpha04")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.6.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.runtime:runtime:1.5.3")
    implementation("androidx.compose.runtime:runtime-livedata:${extra["compose_version"]}")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-beta01")
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Compose Common
    implementation("androidx.compose.ui:ui:${extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation:${extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-util:${extra["compose_version"]}")
    implementation("androidx.compose.animation:animation:${extra["compose_version"]}")

    // Compose Android
    implementation("androidx.compose.ui:ui-android:${extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview-android:${extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation-android:${extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-util-android:${extra["compose_version"]}")
    implementation("androidx.compose.animation:animation-android:${extra["compose_version"]}")

    // Constraint layout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha13")

    // Material Design
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.compose.material:material:1.5.3")
    implementation("androidx.compose.material:material-icons-extended:1.5.3")
    implementation("androidx.compose.material3:material3-android:1.2.0-alpha09")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${extra["lifecycle_version"]}")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    kapt("androidx.lifecycle:lifecycle-common-java8:${extra["lifecycle_version"]}")

    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.48")
    ksp("androidx.hilt:hilt-compiler:1.1.0-beta01")
    ksp("com.google.dagger:hilt-compiler:2.48")
    ksp("com.google.dagger:hilt-android-compiler:2.48")

    // Room
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-adaptive:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-placeholder:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-navigation-material:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-navigation-animation:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-flowlayout:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-permissions:${extra["accompanist_version"]}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${extra["accompanist_version"]}")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.5.0")

    // Other
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("commons-codec:commons-codec:1.16.0")
    implementation("commons-io:commons-io:2.11.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")


    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation("androidx.camera:camera-core:${camerax_version}")
    implementation("androidx.camera:camera-camera2:${camerax_version}")
    // If you want to additionally use the CameraX Lifecycle library
    implementation("androidx.camera:camera-lifecycle:${camerax_version}")
    // If you want to additionally use the CameraX VideoCapture library
    implementation("androidx.camera:camera-video:${camerax_version}")
    // If you want to additionally use the CameraX View class
    implementation("androidx.camera:camera-view:${camerax_version}")
    // If you want to additionally add CameraX ML Kit Vision Integration
    implementation("androidx.camera:camera-mlkit-vision:${camerax_version}")
    // If you want to additionally use the CameraX Extensions library
    implementation("androidx.camera:camera-extensions:${camerax_version}")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}