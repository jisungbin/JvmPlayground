plugins {
  kotlin("jvm") version "2.1.0"
  application
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(project(":second"))
  implementation(project(":second:third"))
  implementation("org.jsoup:jsoup:1.18.1")

  implementation(kotlin("reflect"))
  implementation("com.squareup.okio:okio:3.9.1")
  implementation("com.mayakapps.kache:file-kache:2.1.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
}
