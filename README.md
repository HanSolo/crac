## Micronaut 3.9.0 Documentation

- [User Guide](https://docs.micronaut.io/3.9.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature crac documentation

- [Micronaut Support for CRaC (Coordinated Restore at Checkpoint) documentation](https://micronaut-projects.github.io/micronaut-crac/latest/guide)

- [https://wiki.openjdk.org/display/CRaC](https://wiki.openjdk.org/display/CRaC)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## CRaC Name service
Start the application with 
```./gradlew run```

Open a browser and type in
```http://localhost:8080/names?gender=female&amount=10```

You should see 10 random female names in JSON format in your browser and also the
time it took to create the response.