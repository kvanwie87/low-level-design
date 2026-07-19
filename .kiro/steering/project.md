# Project Overview

## Purpose

This is a Java sandbox for learning and practicing **Low-Level Design (LLD)** and **Object-Oriented Design (OOD)**. It covers GoF design patterns with focused implementations and realistic case studies that demonstrate how patterns combine to solve real interview-style problems.

## Repository Structure

```
src/main/java/
├── patterns/           # Isolated GoF pattern implementations
│   ├── behavioral/     # Chain, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template, Visitor
│   ├── creational/     # Abstract Factory, Builder, Factory Method, Singleton
│   └── structural/     # Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy
├── casestudy/          # Full system designs combining multiple patterns
│   ├── ecommerce/      # Cart, search, and order management system
│   ├── elevator/       # Elevator system — State + Observer patterns
│   ├── elevator2/      # Elevator v2 — event-driven simulation with control panel
│   ├── inmemorysql/    # In-memory SQL engine with criteria/constraint/statement layers
│   ├── jsonparser/     # JSON parser — Composite pattern with tokenization pipeline
│   ├── library/        # Library management — layered architecture (Controller/Service/Repo)
│   ├── logger/         # Logging framework — Logger, Handler, Appender, Layout, Filter
│   └── stockbroadcast/ # Stock price updates — Observer + Mediator patterns
├── solid/              # SOLID principles examples
├── streams/            # Java Streams API exploration
├── functionalinterfaces/ # Functional interfaces and lambdas
├── parallel/           # Concurrency and parallel execution examples
└── src/test/java/      # JUnit 5 + Mockito tests
```

## Case Studies

Each case study in `casestudy/` has a `README.md` documenting the problem statement and design rationale. The goal is not just a working implementation but a defensible design you can explain in an interview.

| Case Study | Key Patterns | Focus |
|---|---|---|
| `ecommerce` | Strategy, Chain of Responsibility | Cart, search filters, order flow |
| `elevator` | State, Observer | Single elevator state machine |
| `elevator2` | State, Command | Interactive CLI simulation |
| `inmemorysql` | Builder, Strategy, Composite | SQL statement construction and evaluation |
| `jsonparser` | Composite, Template Method | Lexer → tokenizer → parser pipeline |
| `library` | Layered Architecture | CRUD operations over User/Book/Borrow resources |
| `logger` | Chain of Responsibility, Mediator, Decorator | Log routing, appenders, layouts, filters |
| `stockbroadcast` | Observer, Mediator | Decoupled event broadcast across markets |

## Design Philosophy

- **Favor composition over inheritance.** State pattern hierarchies are acceptable for simple problems; for complex scenarios prefer event-driven or compositional approaches.
- **Interfaces are the contract.** Concrete classes implement interfaces; callers depend on the interface, not the implementation.
- **Separate concerns clearly.** Parsing, tokenizing, and deserializing are distinct steps. Controllers, services, and repositories are distinct layers.
- **Acknowledge cross-cutting concerns without over-engineering them.** Authentication, logging, validation, and transactions are noted but not fully implemented from scratch — a real framework handles them.
- **Each pattern package is self-contained.** A `Runner.java` (or `*Runner.java`) provides a `main` method entry point to demonstrate the pattern without a framework.

---

## High-Level Design (HLD) Problems

This section covers how to approach and document **High-Level Design** (system design) problems — the complement to LLD work in this repo.

### How to Approach an HLD Problem

Work through these steps in order. In an interview, narrate each step out loud before diving into detail.

1. **Clarify requirements**
   - Distinguish functional requirements (what the system does) from non-functional requirements (scale, latency, availability, consistency).
   - Ask the interviewer to confirm scope. Not everything in the problem statement needs to be designed; focus on what they care about.

2. **Estimate scale**
   - Rough numbers for reads/writes per second, storage, and bandwidth.
   - These numbers drive decisions about caching, sharding, and replication — state the assumptions explicitly.

3. **Define the API**
   - Identify the key endpoints or operations the system exposes.
   - Keep it RESTful unless there is a clear reason for a different protocol (WebSocket for real-time, gRPC for internal services).

4. **Design the data model**
   - Identify the core entities and their relationships.
   - Choose a storage type (relational, document, key-value, time-series) and justify it based on access patterns, not habit.

5. **Sketch the high-level architecture**
   - Name the major components: clients, load balancers, services, caches, queues, databases, CDN, etc.
   - Show data flow between components.

6. **Deep-dive on critical components**
   - Pick the one or two components the interviewer cares most about and go deeper: internal design, data structures, algorithms.

7. **Address non-functional requirements**
   - **Scalability:** horizontal scaling, partitioning/sharding strategy.
   - **Availability:** replication, failover, health checks.
   - **Consistency:** CAP trade-offs, eventual vs. strong consistency.
   - **Performance:** caching strategy (write-through, write-back, eviction policy), CDN for static assets.
   - **Security:** authentication, authorization, rate limiting, input validation.

8. **Identify bottlenecks and trade-offs**
   - Every design decision has a cost. State it explicitly.
   - Common bottlenecks: single points of failure, hot partitions, N+1 queries, synchronous fan-out.

---

### HLD Markdown Output Format

When asked to produce an HLD writeup for a system, always output a single markdown document using the following structure. The backtick fences below show the template — output it without the outer fence:

# HLD: <System Name>

## Problem Statement
One paragraph describing the system and its purpose.

## Requirements

### Functional Requirements
- Bullet list of what the system must do.

### Non-Functional Requirements
- Scale targets (DAU, RPS, storage)
- Latency targets (p99 read/write)
- Availability target (e.g., 99.99%)
- Consistency model (strong / eventual)

## Capacity Estimation
| Metric | Estimate | Assumption |
|---|---|---|
| Daily active users | X | |
| Reads per second | X | |
| Writes per second | X | |
| Storage per year | X GB/TB | |
| Bandwidth | X MB/s | |

## API Design
| Method | Endpoint | Description |
|---|---|---|
| POST | /resource | Create a resource |
| GET  | /resource/{id} | Fetch a resource |

Include request/response shapes for the most important endpoints.

## Data Model
List the core entities and their key fields. Note primary keys, foreign keys, and indexes.

| Entity | Key Fields | Storage |
|---|---|---|
| User | id, email, createdAt | Relational |

## High-Level Architecture
Describe the major components and their responsibilities.
Include an ASCII diagram showing how data flows through the system.

  Client → Load Balancer → API Gateway → Service Layer → Cache → DB
                                       ↘ Message Queue → Worker → Storage

### Components
- **Component name:** responsibility and technology choice.

## Deep Dive: <Critical Component>
Internal data structures, algorithms, and scaling approach for the most complex component.

## Non-Functional Considerations

### Scalability
Horizontal scaling approach. Sharding/partitioning strategy if applicable.

### Availability & Fault Tolerance
Replication strategy. Behavior when a component fails.

### Caching
What is cached, where (client/CDN/in-process/distributed), eviction policy, invalidation strategy.

### Consistency
CAP trade-off taken and why. Where eventual consistency is acceptable vs. where strong consistency is required.

### Security
Authentication method, authorization model, rate limiting, and input validation approach.

## Trade-offs & Alternatives
| Decision | Choice | Alternative | Why |
|---|---|---|---|
| Database | PostgreSQL | Cassandra | Strong consistency needed for transactions |

## Open Questions
Assumptions that should be validated with the interviewer or product team.
