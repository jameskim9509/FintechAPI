plugins {}

version = "0.0.1"

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.springfox:springfox-boot-starter:3.0.0")

    implementation(project(":domain"))
    implementation(project(":kafka"))

    // test
    testImplementation("io.mockk:mockk:1.12.0")
    runtimeOnly("com.h2database:h2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")

    // AOP
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

    // Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
}