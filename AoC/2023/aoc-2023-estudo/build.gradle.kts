plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "br.aoc.estudos.code"
version = "1.0.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}