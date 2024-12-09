plugins {
    kotlin("jvm") version "1.9.10"
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
    implementation(kotlin("stdlib"))
}