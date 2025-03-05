plugins {
    application
    kotlin("jvm") version "1.9.0"
}
repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    google()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    //implementation("org.deeplearning4j:deeplearning4j-core:1.0.0-M2.1")
    //implementation("org.nd4j:nd4j-native-platform:1.0.0-M2.1")
    //implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}


// Tasks do gradle
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    kotlinOptions.allWarningsAsErrors = true
    // Ensure Kotlin uses UTF-8
    kotlinOptions.freeCompilerArgs += "-Xjsr305=strict"
    kotlinOptions.freeCompilerArgs += "-Xjvm-default=all"
    //kotlinOptions.freeCompilerArgs += "-Dfile.encoding=UTF-8"
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
}