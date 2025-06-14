// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    kotlin("jvm")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
//    classpath ;"org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0" // Use the latest version
}
repositories {
    google()
    mavenCentral()
}
kotlin {
    jvmToolchain(8)
}