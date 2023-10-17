buildscript {
   dependencies {
       classpath ("com.google.gms:google-services:4.4.0")
       classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
   }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}
