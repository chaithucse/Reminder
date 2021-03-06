// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.0-beta09")
    val lifecycleVersion by extra("2.3.1")
    val room_version by extra("2.3.0")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-beta04")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("com.google.gms:google-services:4.3.8")
        // Add the Crashlytics Gradle plugin (be sure to add version
        // 2.0.0 or later if you built your app with Android Studio 4.1).
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}