[![Main branch build status](https://github.com/grace-guides/gs-spring-boot-test/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-spring-boot-test/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://twitter.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-3.0.22-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-3.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2022.2.8-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2022.2.8)
[![Spring Boot Version](https://img.shields.io/badge/Spring_Boot-2.7.18-blue?style=flat&color=6db33f)](https://github.com/spring-projects/spring-boot/releases)

# Use `@SpringBootTest` with Grace apps

This guide walks you through the process of creating a Grace application and then testing it with JUnit.

### Creating a new Grace app

```bash
$ sdk use grace 2022.2.8

$ grace create-app grace.guides.gs-spring-boot-test
```

### Add test dpendency

Add dependency `spring-boot-starter-test` to `build.grade`,

```gradle
dependencies {
    testImplementation "org.springframework.boot:spring-boot-starter-test"
    testRuntimeOnly "org.junit.platform:junit-platform-launcher"
}
```

Creating `ApplicationTests` in `src/test/groovy/grace/guides`

```groovy
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
    @LocalServerPort
    private int port

    @Autowired
    private TestRestTemplate restTemplate

    @Test
    void homePage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Welcome to Grace")
    }

}
```

### Running test

```bash
$ ./gradlew test
```


## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Grace Dynamic Modules Plugin](https://github.com/grace-plugins/grace-dynamic-modules)
