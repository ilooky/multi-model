plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter-webflux")
    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot", "spring-boot-devtools")
    implementation("io.github.microutils", "kotlin-logging", "2.0.4")
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}
