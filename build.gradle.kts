import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  kotlin("jvm") version "2.2.20"
  application
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

kotlin {
  compilerOptions {
    jvmTarget = JvmTarget.JVM_21
    freeCompilerArgs.add("-Xcontext-parameters")
  }
}

dependencies {
//  implementation(project(":second"))
//  implementation(project(":second:third"))

  implementation(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")

  implementation("com.squareup.okio:okio:3.16.0")
  implementation("com.squareup.wire:wire-runtime:5.4.0")
  implementation("com.squareup.wire:wire-compiler:5.4.0")
  implementation("com.squareup.wire:wire-schema:5.4.0")
  implementation("com.squareup.wire:wire-kotlin-generator:5.4.0")
}
