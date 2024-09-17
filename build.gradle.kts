plugins {
  kotlin("jvm") version "2.0.20"
  application
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(kotlin("reflect"))
//  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
//  implementation("com.caoccao.javet:javet-macos:3.1.4")
}
