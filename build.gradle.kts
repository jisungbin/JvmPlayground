@file:Suppress("VulnerableLibrariesLocal")

import kotlinx.benchmark.gradle.JvmBenchmarkTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.9.22"
  id("org.jetbrains.kotlinx.benchmark") version "0.4.7"
  id("land.sungbin.kotlin.dataclass.nocopy.plugin") version "1.0.3"
  application
}

nocopy {
  verbose.set(true)
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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.22")
  implementation("org.jetbrains.dokka:dokka-base:1.9.10")
  implementation("org.jetbrains.dokka:dokka-core:1.9.10")
  implementation("org.jetbrains.kotlin:kotlin-compiler:1.9.23")
  implementation("org.jetbrains.compose.compiler:compiler-hosted:1.5.8")
  implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.10")

  implementation("io.ktor:ktor-server-core:2.3.6")
  implementation("io.ktor:ktor-server-netty:2.2.1")

  implementation("org.slf4j:slf4j-api:2.0.9")
  implementation("org.slf4j:slf4j-simple:2.0.9")

  implementation("commons-io:commons-io:2.15.1")
  implementation("com.squareup:kotlinpoet:1.15.2")

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
  testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.22")
  testImplementation("io.strikt:strikt-core:0.34.1")
  testImplementation("com.google.truth:truth:1.3.0")
}
