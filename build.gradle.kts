plugins {
    id("java")
    id("maven-publish")
}

group = "me.hobbyshop"
version = "1.1"

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
