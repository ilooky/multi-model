plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
}

tasks.bootJar{
    enabled = false
}
tasks.jar{
    enabled = true
}