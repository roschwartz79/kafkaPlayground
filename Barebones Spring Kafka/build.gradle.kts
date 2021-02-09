plugins {
    java
    kotlin("jvm") version "1.4.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    implementation("org.springframework.kafka:spring-kafka:2.6.5")

    testImplementation("org.springframework.kafka:spring-kafka-test:2.6.5")
}

application {
    mainClassName = "Main"
}
