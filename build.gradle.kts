plugins {
  kotlin("jvm") version "1.9.23"
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

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
  implementation("com.squareup:kotlinpoet:1.16.0")
  implementation("io.github.classgraph:classgraph:4.8.170")
  implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:+")
}
