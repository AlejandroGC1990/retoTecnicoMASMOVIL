plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.gms.google-services")
}

android {
    namespace = "com.example.retotecnicomm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retotecnicomm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    packagingOptions {
        exclude ("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")
    implementation("androidx.room:room-common:2.5.2")
    implementation("androidx.camera:camera-core:1.2.3")

    //Compose
    implementation("androidx.compose.runtime:runtime:1.5.3")
    implementation("androidx.activity:activity-compose:1.3.0")
    implementation ("androidx.compose.animation:animation:1.5.3")
    implementation("androidx.compose.foundation:foundation:1.5.3")
    implementation("androidx.compose.ui:ui:1.5.3")
    implementation("androidx.compose.material3:material3:1.1.2")
    //Icons extendidos
    implementation("androidx.compose.material:material-icons-extended:1.5.3")
    implementation("androidx.compose.ui:ui:1.5.3")

    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.6.2")

    // Obtener imagen galería
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Navegation
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    //Hilt
    //Navegacion
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.40.1")
    implementation("com.google.dagger:hilt-android-compiler:2.40.1")
    implementation("androidx.hilt:hilt-compiler:1.0.0-alpha03")

    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}