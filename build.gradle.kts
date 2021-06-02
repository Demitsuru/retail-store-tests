plugins {
    java
}

group = "com.test.dmitriy"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:5.21.0")
    testImplementation("org.testng:testng:7.0.0")
    testImplementation("com.tngtech.jgiven:jgiven-testng:1.0.0")
    testImplementation("io.qameta.allure:allure-selenide:2.13.8")
    testImplementation("io.qameta.allure:allure-testng:2.13.8")
    testImplementation("org.slf4j:slf4j-simple:1.7.30")
}

tasks {
    test {
        useTestNG()
    }
}