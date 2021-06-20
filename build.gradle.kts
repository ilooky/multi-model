import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.5.10"
    val springVersion = "2.5.0"
    val springDependencyManagementVersion = "1.0.11.RELEASE"
    idea
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    id("org.springframework.boot") version springVersion apply false
    id("io.spring.dependency-management") version springDependencyManagementVersion
}

allprojects {
    group = "com.eusunpower"
    version = "1.0"
    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            languageVersion = "1.5"
            apiVersion = "1.5"
            jvmTarget = "1.8"
        }
    }
    repositories {
        mavenCentral()
        jcenter()
    }
}
extra["springCloudVersion"] = "2020.0.2"
subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    configure<DependencyManagementExtension> {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")

        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
