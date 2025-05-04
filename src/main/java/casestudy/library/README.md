# Library Management System Case Study
## Problem Statement
Design a library management system that can handle the following
- handle different types of users (e.g., members, librarians, admins)
- register and manage users
- search for books by different criteria (e.g., title, author, genre)
- check out and return books
- add and remove books from the library. Individual books or all copies of a certain book
## Thoughts
First thing of note here is that the scope of this problem is far beyond what you would be able to do in a single interview. So don't let that overwhelm you. Focus on communicating with the interviewer to determine what scope they actually care about.
This particular problem could be a LLD problem, MLD problem, or even a HLD problem depending on the scope of the interview. They may just be interested in how you design APIs or Model data. So be sure to clarify with the interviewer what they are looking for.

At a high level this system would be a collection of APIs that interact with a database. The APIs would be responsible for handling the requests from the users and the database would be responsible for storing the data. The APIs would be responsible for validating the requests and returning the appropriate responses.

Most of this problem is just CRUD operations. So I would focus on modeling the resources to fit the problem statement.
The resources we would need would be:
- User: represents a user of the library. Has metadata about the user and their role in the library.
- Book: represents a book in the library. Has metadata about the book
- BookCopy: represents a copy of a book in the library. Has metadata about the copy and its availability.
- Borrow: represents a borrow transaction. Has metadata about the transaction and the user who borrowed the book. (Might be a better word than borrow)

CRUD operations on the above resources would cover all the use cases in the problem statement.
I would structure this as basic layered architecture with a controller layer, service layer, and repository layer. The controller layer would handle the requests from the users and the service layer would handle the business logic. The repository layer would handle the database interactions.
I would acknowledge but not implement cross cutting concerns such as authentication, authorization, logging, deserialization, validation, transaction handling, exception handling, etc. These would be handled by a framework and to actually implement them from scratch would be a entire LLD problem on their own (We have logging as an entire seperate problem for example).
