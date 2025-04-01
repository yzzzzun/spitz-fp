plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.yzzzzun"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.http4k:http4k-core:5.33.0.1")
    implementation("org.http4k:http4k-server-jetty:5.33.0.1")

    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.http4k:http4k-client-jetty:5.33.0.1")
    testImplementation("com.ubertob.pesticide:pesticide-core:1.6.6")
    testImplementation("io.strikt:strikt-core:0.34.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}