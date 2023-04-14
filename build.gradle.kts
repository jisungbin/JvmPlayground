@file:Suppress("VulnerableLibrariesLocal")

import kotlinx.benchmark.gradle.JvmBenchmarkTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.kotlinx.benchmark") version ("0.4.7")
    id("land.sungbin.dependency.handler.extensions") version ("1.1.0-alpha")
    application
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

application {
    mainClass.set("MainKt")
}

benchmark {
    configurations {
        named("main") {
            iterationTime = 5
            mode = "avgt" // measures time per benchmark function invocation
        }
    }
    targets {
        register("main") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.21"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

@Suppress("INLINE_FROM_HIGHER_PLATFORM")
dependencies {
    implementations(
        "org.jetbrains.kotlin:kotlin-reflect:1.7.20",
        "org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.6",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4",
        "org.jetbrains.dokka:dokka-base:1.8.10",
        "org.jetbrains.dokka:dokka-core:1.8.10",
        "org.jetbrains.kotlin:kotlin-compiler:1.8.10",
        "org.jetbrains.compose.compiler:compiler-hosted:1.4.2",
        "io.ktor:ktor-server-core:2.2.1",
        "io.ktor:ktor-server-netty:2.2.1",
        "commons-io:commons-io:2.11.0",
        "com.squareup:kotlinpoet:1.12.0",
        "org.slf4j:slf4j-api:2.0.6",
        "org.slf4j:slf4j-simple:2.0.6",
    )
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementations(
        "org.junit.jupiter:junit-jupiter-api:5.9.2",
        "org.jetbrains.kotlin:kotlin-test:1.7.20",
        "io.strikt:strikt-core:0.34.1",
        "com.google.truth:truth:1.1.3",
    )
}
