plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.16.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}


application {
    mainClass = "hexlet.code.App"
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}

//compileJava {
//    options.release = 20
//}