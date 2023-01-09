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

//junit5
tasks.withType<Test> {
    useJUnitPlatform()
}
dependencies {
    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // (Optional) If you need "Parameterized Tests"
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")

    // (Optional) If you also have JUnit 4-based tests
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.8.2")
}
//truth
dependencies {
    testImplementation("com.google.truth:truth:1.1.3")
}
@Suppress("VulnerableLibrariesLocal")
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    implementation("io.ktor:ktor-server-core:2.2.1")
    implementation("io.ktor:ktor-server-netty:2.2.1")
    implementation("commons-io:commons-io:2.11.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
    testImplementation("io.strikt:strikt-core:0.34.1")
    // implementation("org.jetbrains.compose.compiler:compiler-hosted:1.2.0")
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
