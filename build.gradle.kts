import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.5.0"
    val springVersion = "2.4.5"
    val springDependencyManagementVersion = "1.0.11.RELEASE"
    idea
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    id("org.springframework.boot") version springVersion apply false
    id("io.spring.dependency-management") version springDependencyManagementVersion
    // For dependency version upgrades "gradle dependencyUpdates -Drevision=release"
    id("com.github.ben-manes.versions") version "0.36.0"
}

allprojects {
    group = "com.eusunpower.ticket"
    version = "1.0"

    repositories {
        mavenCentral()
        jcenter()
    }
}
extra["springCloudVersion"] = "2020.0.2"
subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            languageVersion = "1.5"
            apiVersion = "1.5"
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

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
