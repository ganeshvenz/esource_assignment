plugins {
    id("java")
    id("jacoco")
}

group = "com.esource.assignment"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.8"
}

dependencies {

    /*compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")*/

    //implementation("org.slf4j:slf4j-log4j1:1.7.29")
    //implementation("org.apache.logging.log4j:log4j-api:2.7")
    //implementation("org.apache.logging.log4j:log4j-core:2.7")
    //implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.7")
    //implementation("ch.qos.logback:logback-classic:1.2.6")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.esource.assignment.ESourceAssignment"
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}