plugins {
  kotlin("jvm") version "2.0.0"
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
  implementation(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
  implementation("com.squareup.okio:okio:3.9.0")
}
