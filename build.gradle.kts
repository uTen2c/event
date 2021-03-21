plugins {
    java
    kotlin("jvm") version "1.4.31"
    `maven-publish`
}

base {
    archivesBaseName = "event"
    group = "dev.uten2c"
    version = "1.0.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
}

val sourcesJar = tasks.create<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.base.archivesBaseName
            version = project.version.toString()

            from(components["java"])
            artifact(sourcesJar)
        }
    }
    repositories {
        maven {
            url = uri("${System.getProperty("user.home")}/maven-repo")
            println(uri("${System.getProperty("user.home")}/maven-repo"))
        }
    }
}