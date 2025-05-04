# JSON Parser Case Study
## Problem Statement
- Design a JSON parser that can parse a JSON string and convert it into a Java object. 
- The parser should be able to handle different data types such as strings, numbers, booleans, arrays, and objects. 
- The parser should also be able to handle nested JSON objects and arrays.
## Thoughts
JSON naturally has a tree structure with leaves being the primitive types and branches being the objects and arrays.
So your code can be structured using the composite pattern. The JSON objects should not be responsible for building themselves.
The responsibility of the JSON objects should be to store data and provide access to it.
The JSON parsing process can be split into multiple steps with different classes responsible for each step in order to make changing the different steps easier.
The steps for JSON Parsing are:
1. Deserialization: Convert the input into a standardized format. (The problem statement only mentions parsing a JSON string, this handles "What if the input is not a string?")
2. Tokenization: Convert the standardized input into tokens.
3. Parsing: Convert the tokens into a JSON object.

Deserialization doesn't require any specific pattern just an interface and a simple sample implementation for string is enough.
Tokenization doesn't require any specific pattern either.

Parsing is where the composite pattern comes into play. Each JSON data type could have its own subclass of the parser interface. 
The composite parsers (parsers for objects and arrays) would be responsible for invoking the leaf parsers (parsers for strings, numbers, booleans, etc.) and delegating the parsing to them.