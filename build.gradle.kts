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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
  implementation("com.squareup.okio:okio:3.9.0")
  implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
  implementation("com.squareup.okhttp3:okhttp-coroutines:5.0.0-alpha.14")
  implementation("com.squareup.moshi:moshi:1.15.1")
}
