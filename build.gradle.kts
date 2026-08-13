plugins {
    java
    application
    pmd
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "edu.curtin.app.App"
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:all,-serial")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
    systemProperties["java.util.logging.config.file"] = "logging.properties"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("failed")
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

pmd {
    setConsoleOutput(true)
    toolVersion = "7.26.0"
    rulesMinimumPriority = 5
    ruleSets = listOf()
    ruleSetFiles = files("oose-pmd-rules.xml")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // implementation("org.slf4j:slf4j-api:2.0.18")
    // implementation("org.slf4j:slf4j-jdk14:2.0.18")
    // implementation("io.qtjambi:qtjambi:6.11.1")
    // implementation("org.apache.tika:tika:3.3.2")
    // runtimeOnly("org.postgresql:postgresql:42.7.13")
}
