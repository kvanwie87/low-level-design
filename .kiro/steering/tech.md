# Tech Stack

## Language & Runtime

- **Java** — target runtime is Java 17+ (inferred from Spring Web 6.x dependency)
- No explicit `sourceCompatibility` / `targetCompatibility` set in `build.gradle`; if adding one, use `JavaVersion.VERSION_17` or higher

## Build System

- **Gradle** (Kotlin-style Groovy DSL, wrapper at `gradle/wrapper/`)
- Gradle wrapper version: **8.8**
- Run builds via `./gradlew` (Linux/Mac) or `gradlew.bat` (Windows)

Common tasks:

```bash
./gradlew build          # compile + test
./gradlew test           # run all tests
./gradlew compileJava    # compile only
```

## Dependencies

### Production

| Dependency | Version | Purpose |
|---|---|---|
| `org.springframework:spring-web` | 6.1.4 | HTTP utilities (e.g., `@RestController`, request/response types used in case study APIs) |
| `com.fasterxml.jackson.core:jackson-databind` | 2.15.3 | JSON serialization/deserialization |
| `org.apache.commons:commons-collections4` | 4.5.0 | Extended collection types (loaded from local jar at `src/main/resources/jars/`) |
| `org.projectlombok:lombok` | 1.18.38 | Boilerplate reduction (`@Data`, `@Builder`, `@Getter`, etc.) — compile-only with annotation processor |

### Test

| Dependency | Version | Purpose |
|---|---|---|
| `org.junit.jupiter:junit-jupiter` | 5.10.0 | JUnit 5 test framework |
| `org.junit.jupiter:junit-jupiter-engine` | 5.10.0 | JUnit 5 runtime engine |
| `org.mockito:mockito-core` | 5.10.0 | Mocking framework |
| `org.mockito:mockito-junit-jupiter` | 5.10.0 | Mockito integration with JUnit 5 (`@ExtendWith(MockitoExtension.class)`) |

## Test Execution

Tests run in parallel by default. The `build.gradle` configures:

```groovy
useJUnitPlatform()
maxParallelForks = Runtime.getRuntime().availableProcessors()
systemProperty 'junit.jupiter.execution.parallel.enabled', 'true'
systemProperty 'junit.jupiter.execution.parallel.mode.default', 'concurrent'
systemProperty 'junit.jupiter.execution.parallel.mode.classes.default', 'concurrent'
```

Keep tests stateless and thread-safe — shared mutable state across test methods will cause flaky results.

## Lombok Usage

Lombok is on the classpath but used sparingly. Plain Java getters/setters are common in this codebase. When adding new model classes:

- Use Lombok `@Data` or `@Getter`/`@Setter` for simple POJOs to reduce boilerplate
- Use `@Builder` for classes that benefit from a fluent construction API
- Do not mix Lombok-generated and manually written accessors on the same field

## Local Jars

`commons-collections4-4.5.0.jar` is stored at `src/main/resources/jars/` and referenced via a `flatDir` repository. Do not add additional local jars — prefer declaring proper Maven coordinates in `dependencies {}`.
