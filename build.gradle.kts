import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.arystan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.25.0")
    implementation("com.sikulix:sikulixapi:2.0.5")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.springframework.security:spring-security-core:5.7.3")

    implementation("org.testcontainers:testcontainers:1.11.2")
    implementation("org.testcontainers:postgresql:1.12.3")
    implementation("org.postgresql:postgresql:42.2.7")
    implementation("org.springframework:spring-jdbc:5.1.9.RELEASE")
    implementation("org.json:json:20180813")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    testImplementation("org.testng:testng:7.6.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.10")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

application {
    mainClass.set("com.microsoft.playwright.CLI")
}