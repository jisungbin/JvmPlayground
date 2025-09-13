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
  jvmToolchain(21)
  compilerOptions {
    freeCompilerArgs.add("-Xcontext-parameters")
  }
}

dependencies {
//  implementation(project(":second"))
//  implementation(project(":second:third"))

  implementation(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")

//  implementation("com.squareup.okio:okio:3.9.1")
//  implementation("com.squareup.wire:wire-schema:5.3.10")
}
