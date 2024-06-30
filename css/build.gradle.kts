plugins {
    id("com.bmuschko.docker-remote-api") version "6.7.0"
}

version = "0.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.register<com.bmuschko.gradle.docker.tasks.image.DockerBuildImage>("buildDockerImage") {
    inputDir.set(file("."))
    images.add("css:${project.version}")
}