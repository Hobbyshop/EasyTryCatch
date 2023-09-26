plugins {
    id("java")
    id("maven-publish")
}

group = "me.hobbyshop"
version = "1.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
