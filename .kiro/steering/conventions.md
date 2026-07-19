# Code Conventions

## Naming

| Element | Convention | Example |
|---|---|---|
| Classes & interfaces | PascalCase | `CartService`, `Filter`, `ElevatorState` |
| Methods & fields | camelCase | `addToCart()`, `cartId`, `onStockEvent()` |
| Constants | UPPER_SNAKE_CASE | `MAX_FLOOR`, `DEFAULT_LOG_LEVEL` |
| Packages | lowercase, no underscores | `casestudy.ecommerce`, `patterns.behavioral.observer` |
| Entry point classes | `Runner` or `*Runner` | `Runner.java`, `ElevatorSimulationRunner.java` |

## Package & File Organization

- One top-level class per file. The file name must match the public class name.
- Each pattern or case study lives in its own package. Do not share classes across packages unless they are genuinely reusable utilities.
- Every pattern package and case study package should have a `Runner.java` (or equivalent `*Runner.java`) with a `main` method that demonstrates the feature end-to-end.
- Every case study package should have a `README.md` documenting the problem statement and design rationale before implementation begins.

## Class Design

- **Prefer interfaces over abstract classes** for defining contracts. Use abstract classes only when sharing concrete behavior across a hierarchy (e.g., a partial state implementation).
- **Depend on abstractions.** Fields and parameters should be typed to the interface, not the concrete implementation.
- **Keep constructors simple.** Inject dependencies through the constructor. Avoid `new` inside business logic methods — instantiation belongs in factories, builders, or `Runner` setup code.
- **Model classes** (data holders like `Product`, `CartEntry`, `LogEvent`) may use public fields or simple getters/setters without extra logic. Prefer Lombok `@Data` or `@Getter`/`@Setter` to reduce boilerplate on these.
- **Service/handler classes** should be small and focused. If a class has more than one clear responsibility, split it.

## Design Patterns — Application Rules

- Every pattern implementation must be placed under `patterns/<category>/<patternname>/`.
- Include at least one interface or abstract type and at least one concrete implementation.
- The `Runner` must show a realistic usage scenario, not just instantiation.
- When a case study uses a pattern, reference the pattern by name in the case study `README.md`.

### Choosing patterns

- Use **State** for objects whose behavior changes based on internal state, but be ready to pivot to an **event-driven/Observer** approach if the state space grows.
- Use **Builder** for objects with many optional fields or multi-step construction (see `SelectStatementBuilder` as the reference implementation).
- Use **Mediator** to decouple subjects from their observers (see `stockbroadcast` and `logger`).
- Use **Composite** when the domain has a natural tree structure (see `jsonparser`).
- Use **Chain of Responsibility** for filter pipelines (see `ecommerce` filters, `logger` filter chain).
- Prefer **composition over inheritance** in all cases. Inheritance hierarchies deeper than two levels are a signal to refactor.

## Layered Architecture (Case Studies)

Case studies that model a full system follow a three-layer structure:

```
Controller / API layer   — handles requests, validates input, returns responses
Service layer            — business logic, orchestrates domain objects
Repository / DAO layer   — data access (in-memory maps, simulated persistence)
```

- Cross-cutting concerns (auth, transactions, logging, validation, exception handling) are **acknowledged but not implemented** from scratch. Note them in the README and move on.
- Request and response objects (`*Request`, `*Response`) are plain data containers — no logic.

## Testing

Follow the pattern in `src/test/java/junit/SampleJUnit.java`:

1. Annotate the test class with `@ExtendWith(MockitoExtension.class)`.
2. Declare dependencies as `@Mock` fields.
3. Construct the class under test in the test method, injecting the mocks via constructor.
4. Use `when(...).thenReturn(...)` to stub dependency behavior.
5. Assert results with `assertEquals` / other JUnit assertions.
6. Use `verify(...)` to assert that collaborator methods were called when the return value alone is not sufficient.

```java
@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartDAO cartDAO;

    @Test
    void shouldReturnCartById() {
        CartService service = new CartService(cartDAO);
        Cart expected = new Cart("cart-1");
        when(cartDAO.getCartById("cart-1")).thenReturn(expected);

        Cart result = service.getCart("cart-1");

        assertEquals(expected, result);
        verify(cartDAO).getCartById("cart-1");
    }
}
```

### Test naming

Use the `should<Behavior>[When<Condition>]` convention:

- `shouldReturnCartById`
- `shouldThrowWhenProductOutOfStock`
- `shouldNotifyAllSubscribersWhenStockPriceChanges`

### Parallel safety

Tests run concurrently across classes and methods. Do not use static mutable state, shared file I/O, or `System.out` assertions in tests.

## Comments & Documentation

- Write `README.md` files for case studies **before** writing code. They are the design document.
- Inline comments should explain *why*, not *what*. The code explains what; the comment explains the intent or a non-obvious trade-off.
- `// TODO` comments are acceptable for scaffolding stubs, but a stub method body must either throw `UnsupportedOperationException` or have a comment explaining what needs to be filled in.
