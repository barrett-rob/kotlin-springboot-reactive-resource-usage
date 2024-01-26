import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.springframework.boot") version "3.2.2" apply false
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

afterEvaluate {
    subprojects {
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")

        java {
            toolchain {
                languageVersion = JavaLanguageVersion.of(21)
            }
        }

        kotlin {
            jvmToolchain {
                languageVersion = JavaLanguageVersion.of(21)
            }
        }

        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "21"
            }
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}