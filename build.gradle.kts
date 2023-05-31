import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("jvm") version "1.8.20"
    id("org.jetbrains.compose") version "1.4.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    checkstyle
}

group = "io.github.protocol-laboratory"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

configurations {
    all {
        // log4j1
        exclude("org.slf4j", "slf4j-log4j12")
        // logback
        exclude("ch.qos.logback", "logback-core")
        exclude("ch.qos.logback", "logback-classic")
    }
}

val kafkaVersion = "2.4.0"
val log4jVersion = "2.19.0"

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    testImplementation(kotlin("test"))
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            modules("java.management")
            modules("java.naming")
            modules("java.security.jgss")
            packageName = "kafka-simulator"
            packageVersion = "1.0.0"
        }
    }
}

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
    reporters {
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.JSON)
        reporter(ReporterType.HTML)
    }
}
