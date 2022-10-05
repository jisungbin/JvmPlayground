import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("land.sungbin.github.upload") version "0.1.2-preview"
    application
}

group = "land.sungbin.playground"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        // we need a dev repository to keep the Compose Compiler always up-to-date.
        url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencies {
    add(
        org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME,
        "land.sungbin:composable.reference.suppressor.plugin:1.0.0"
    )
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}

application {
    mainClass.set("MainKt")
}
