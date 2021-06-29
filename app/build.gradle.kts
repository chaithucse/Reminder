plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.techchai.reminder"
        minSdk = 26
        targetSdk = 30
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
        kotlinCompilerVersion = "1.4.32"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")


    // Jetpack Compose
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    implementation("androidx.activity:activity-compose:1.3.0-beta02")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha03")
    androidTestImplementation( "androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.runtime:runtime:${rootProject.extra["compose_version"]}")

    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta09")

    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0-beta02")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.0-beta02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")

    //Notifications
    implementation("com.android.support:support-compat:28.0.0")
    implementation("com.google.accompanist:accompanist-pager:0.10.0")

    //gson
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")

    // Import the BoM for the Firebase platform
    implementation( platform("com.google.firebase:firebase-bom:28.1.0"))

    // Declare the dependencies for the Remote Config and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation( "com.google.firebase:firebase-config-ktx")
    implementation( "com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")

    // Lifecycle components
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.extra["lifecycleVersion"]}")
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:${rootProject.extra["lifecycleVersion"]}")
    implementation( "androidx.lifecycle:lifecycle-common-java8:${rootProject.extra["lifecycleVersion"]}")

    implementation("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
    kapt( "androidx.room:room-compiler:${rootProject.extra["room_version"]}")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation( "androidx.room:room-ktx:${rootProject.extra["room_version"]}")

    // optional - Test helpers
    testImplementation( "androidx.room:room-testing:${rootProject.extra["room_version"]}")
}