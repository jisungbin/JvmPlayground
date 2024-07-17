plugins {
  kotlin("jvm") version "2.0.0"
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(kotlin("reflect"))
  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
  implementation("com.squareup.okio:okio:3.9.0")
  implementation("org.jsoup:jsoup:1.18.1")
}
