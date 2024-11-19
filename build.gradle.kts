plugins {
  kotlin("jvm") version "2.1.0-Beta2"
  kotlin("plugin.serialization") version "2.1.0-Beta2"
  application
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-okio:1.7.3")
  implementation("com.squareup.okio:okio:3.9.1")
}
