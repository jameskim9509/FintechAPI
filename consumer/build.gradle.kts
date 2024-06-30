plugins {
    id("com.bmuschko.docker-remote-api") version "6.7.0"
}

version = "0.0.1"

dependencies {
    //Kafka
    implementation(project(":kafka"))
    implementation("org.springframework.kafka:spring-kafka:2.8.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")

    //domain
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.register<com.bmuschko.gradle.docker.tasks.image.DockerBuildImage>("buildDockerImage") {
    inputDir.set(file("."))
    images.add("consumer:${project.version}")
}