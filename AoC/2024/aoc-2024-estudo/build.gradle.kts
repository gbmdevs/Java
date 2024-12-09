plugins {
    kotlin("jvm") version "1.9.10" // Certifique-se de usar a versão mais recente
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