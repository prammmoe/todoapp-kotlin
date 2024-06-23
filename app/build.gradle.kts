plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.todoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    val navVersion = "2.5.3"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val roomVersion = "2.6.1"

//    Navigation Fragment
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

//    Room Database
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-common:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")


    // Handle different screen size
    implementation(libs.sdp.android)

    // Handle different screen and text size
    implementation(libs.ssp.android)

    // Retrofit
    implementation(libs.retrofit)

    // ViewModel Dependencies
    val lifecycleVersion = "2.8.2"

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    // Library untuk Observer ViewModel
    implementation(libs.androidx.lifecycle.extensions)
    annotationProcessor(libs.androidx.lifecycle.compiler)

    // Couroutines
    implementation(libs.kotlinx.coroutines.core)

    // Dependency Injection
    implementation(libs.koin.android)

    // Material Design
    implementation(libs.material.v100)

    // Kodein
    implementation(libs.kodein.di.generic.jvm)
    implementation(libs.kodein.di.framework.android.x)

}