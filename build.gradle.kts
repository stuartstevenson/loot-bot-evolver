plugins {
    java
    id("org.springframework.boot") version "2.5.5"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.google.guava:guava:18.0")
    testImplementation("org.easytesting:fest-assert-core:2.0M10")
    testImplementation("junit:junit:4.11")
    testImplementation("org.mockito:mockito-core:1.9.5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}