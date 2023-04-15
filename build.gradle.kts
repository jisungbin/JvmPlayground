@file:Suppress("VulnerableLibrariesLocal")

import kotlinx.benchmark.gradle.JvmBenchmarkTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.kotlinx.benchmark") version ("0.4.7")
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
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("org.jetbrains.dokka:dokka-base:1.8.10")
    implementation("org.jetbrains.dokka:dokka-core:1.8.10")
    implementation("org.jetbrains.kotlin:kotlin-compiler:1.8.10")
    implementation("org.jetbrains.compose.compiler:compiler-hosted:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.6")

    implementation("io.ktor:ktor-server-core:2.2.1")
    implementation("io.ktor:ktor-server-netty:2.2.1")

    implementation("org.slf4j:slf4j-api:2.0.6")
    implementation("org.slf4j:slf4j-simple:2.0.6")

    implementation("commons-io:commons-io:2.11.0")
    implementation("com.squareup:kotlinpoet:1.12.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
    testImplementation("io.strikt:strikt-core:0.34.1")
    testImplementation("com.google.truth:truth:1.1.3")
}
