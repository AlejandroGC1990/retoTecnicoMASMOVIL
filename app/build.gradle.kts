plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.retotecnicomm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retotecnicomm"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.compose.runtime:runtime:1.0.5")
    implementation ("androidx.compose.foundation:foundation:1.5.3")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.3.1")
//  APIS
//  Obtener imagen galería
    implementation("io.coil-kt:coil-compose:2.4.0")

//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")
//
//// //    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//
//    implementation("com.android.support:support-annotations:28.0.0")
//
//    // Compose
//
//    implementation("androidx.compose.material:material:1.5.3")
//    implementation("androidx.compose.ui:ui:1.5.3")
//    implementation("androidx.compose.ui:ui-graphics:1.5.3")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.5.3")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-alpha02")
//

//
//    // Retrofit (si lo necesitas)
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.google.code.gson:gson:2.10.1")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
}
//    implementation ("com.squareup.retrofit2:retrofit:2.9.8")

//
//
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//
//    //Compose
//    implementation ("androidx.activity:activity-compose:1.7.2")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-alpha02")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-alpha02")
//    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    implementation("androidx.compose.ui:ui:1.5.3")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3:1.1.2")
//    implementation ("androidx.compose.ui:ui:1.6.0-alpha07")
//    implementation ("androidx.compose.ui:ui-tooling:1.6.0-alpha07")
//    implementation ("androidx.compose.material:material:1.6.0-alpha07")
//    implementation ("androidx.activity:activity-compose:1.7.2")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-alpha02")
