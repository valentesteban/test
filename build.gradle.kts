import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version ("7.0.0")
}

val pluginName = "Test"

group = "me.valentesteban.$pluginName"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.io/repository/nms/")
    maven("https://repo.unnamed.team/repository/unnamed-public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.10.9")

    implementation("team.unnamed:inject:1.0.1")
}

tasks {
    processResources {
        filesMatching("**/*.yml") {
            filter<org.apache.tools.ant.filters.ReplaceTokens>(
                    "tokens" to mapOf("version" to project.version)
            )
        }
    }
}

tasks.withType<ShadowJar> {
    archiveFileName.set("$pluginName-$version.jar")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}