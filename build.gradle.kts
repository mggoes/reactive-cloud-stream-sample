import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    kotlin("plugin.spring") version "1.3.41"
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

java.sourceCompatibility = VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

val springCloudVersion = "Greenwich.SR2"
val springCloudFunctionVersion = "2.1.1.RELEASE"
val springCloudStreamVersion = "Germantown.RELEASE"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")
    implementation("org.springframework.cloud:spring-cloud-function-context:$springCloudFunctionVersion")
    implementation("org.springframework.cloud:spring-cloud-function-core:$springCloudFunctionVersion")
    implementation("org.springframework.cloud:spring-cloud-function-kotlin:$springCloudFunctionVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        mavenBom("org.springframework.cloud:spring-cloud-stream-dependencies:$springCloudStreamVersion")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}