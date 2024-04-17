plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-android")
    id("kotlin-kapt")
    //id("com.android.application")
}

android {
    namespace = "com.example.room"
    compileSdk = 34

    packaging{
        resources.excludes.add("META-INF/atomicfu.kotlin_module")
    }
    kotlinOptions{
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.example.room"
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
                getDefaultProguardFile("proguard-android-optimize.txt") ,
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
}

dependencies {
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.appcompat)
    dependencies {
        implementation ("androidx.appcompat:appcompat:$rootProject.appCompatVersion")
        implementation ("androidx.activity:activity-ktx:$rootProject.activityVersion")
        implementation ("androidx.room:room-ktx:$rootProject.roomVersion")
        kapt ("androidx.room:room-compiler:$rootProject.roomVersion")
        androidTestImplementation ("androidx.room:room-testing:$rootProject.roomVersion")
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$rootProject.lifecycleVersion")
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$rootProject.lifecycleVersion")
        implementation ("androidx.lifecycle:lifecycle-common-java8:$rootProject.lifecycleVersion")
        api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutines")
        api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutines")
        implementation ("androidx.constraintlayout:constraintlayout:$rootProject.constraintLayoutVersion")
        implementation ("com.google.android.material:material:$rootProject.materialVersion")

    }
}