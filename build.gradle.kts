import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "land.sungbin.playground"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        setUrl("https://jitpack.io")
    }
}

application {
    mainClass.set("MainKt")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}

@Suppress("VulnerableLibrariesLocal")
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("io.ktor:ktor-server-core:2.2.1")
    implementation("io.ktor:ktor-server-netty:2.2.1")
    implementation("commons-io:commons-io:2.11.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
    testImplementation("io.strikt:strikt-core:0.34.1")
    testImplementation("com.google.truth:truth:1.1.3")
    // implementation("org.jetbrains.compose.compiler:compiler-hosted:1.2.0")
}

