plugins {
  kotlin("jvm") version "2.2.10"
  application
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

kotlin {
  jvmToolchain(21)
}

dependencies {
//  implementation(project(":second"))
//  implementation(project(":second:third"))

  implementation(kotlin("reflect"))
  implementation("com.squareup.okio:okio:3.9.1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")

  implementation("com.squareup.wire:wire-schema:5.3.10")
}
