import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.31"
    id("org.shipkit.java") version "2.2.5"
    id("com.github.ben-manes.versions") version "0.21.0"
}

group = "com.skaggsm"

repositories {
    jcenter()
    maven("https://dl.bintray.com/magneticflux/maven")
}

dependencies {
    implementation("com.skaggsm:jvm-shared-memory:0.2.0")
    implementation("net.java.dev.jna:jna:4.4.0")
    implementation("net.java.dev.jna:platform:3.4.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
