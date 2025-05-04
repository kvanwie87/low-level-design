# Logger Case Study
## Problem Statement
Design a logging system that can:
- handle different log levels (e.g., INFO, DEBUG, ERROR) 
- log messages to different outputs (e.g., console, file)
- log messages with different pattern layouts
- filter log events based on different criteria (e.g., log level, message content)
## Thoughts
It might not be immediately apparent how to structure this problem so I would recommend thinking about what happens when you use an existing logging frame such as log4j.
When you log a message you typically call a method an project the message content, log level and potentially other metadata. This log event this has to be matched to a particular log handler. That log handler will have certain appenders assigned to it that determine where the message goes. Those appenders can have different layouts that determine how the message looks when it is output. The log event can also be filtered based on the log level and other criteria at various different levels in this workflow.

You have probably heard the term "root logger" before. This is a common pattern in logging frameworks. The hierarchy of loggers is usually patterned as tree with the default logger at the root of this tree. From there the loggers are split up by package or class name. This allows you to set the log level for a package or class and have all the loggers under that logger inherit that log level.

i.e.
- root
  - com
    - com.example
      - com.example.foo
      - com.example.bar
  - org
    - org.example
      - org.example.foo
      - org.example.bar

Now that we have a basic understanding of how logging frameworks work we can start to think about how to structure our code.

The classes we will need and their responsibilities are:
- LogManager: handles mapping log events to log handlers. Can register log handlers. Effectively just a mediator.
- Logger: produces log events and sends them to the LogManager
- LogHandler: has appenders registered to it. When it receives a log event it will send it to the appenders.
- Appender: handles the actual output of the log event. Can have different layouts registered to it.
- Layout: handles the formatting of the log event. Can be different for different appenders.
- LogEvent: represents a log event. Contains the log level, message, and other metadata.
- Filter: handles filtering of log events. Can be different for different components at various levels of the workflow.
- Depending on how you want to handle configuration you would likely need to have parsers and factories.

Most of the above would likely be basic interfaces and for the purpose of the interview likely only have one or two simple implementations.

The end result would function like this:

- Logger log = LogManager.getLogger("com.example.foo"); // Register the logger with the log manager
- log.info("Hello World!"); // Create a log event with the message "Hello World!" and log level INFO
- the LogManager would receive the log event and find the appropriate log handler for the log event
- the LogHandler would receive the log event and send it registered appends (console appender, file appender, etc.)
- the Appender would receive the log event, format it using the registered layout, and output it to the appropriate destination (console, file, etc.)
- the Layout would format the log event based on the registered pattern
- the Filters would be applied at various levels to determine if the log event should be output or not
- You would likely have some xml, xml, or json configuration file to configure the loggers, log handlers, appenders, layouts, and filters
- The configuration file would be parsed and the appropriate objects would be created and registered with the LogManager
