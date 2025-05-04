# Stock Broadcast Case Study
## Problem Statement
We want to be able to subscriber to stock price updates and receive notifications when the price changes from various different stock markets.
- The system should be able to handle multiple subscribers
- The system should be able to handle multiple stock markets (NYSE, NASDAQ, etc.)
- The system should be able to handle multiple stocks (AAPL, GOOGL, etc.)
## Thoughts
This problem is contrived example of the observer pattern. The stock market is the subject and the subscribers are the observers. The stock market notifies the subscribers when the stock price changes. 

The observer pattern is a behavioral pattern not a structural pattern so there is flexibility in how you structure its implementation.
In order to decouple the stock markets from their subscribers I would recommend using a mediator to handle the relationship between the two. The mediator would be responsible for registering the subscribers and notifying them when the stock price changes. This allows you to easily add or remove subscribers without having to modify the stock market code.

The classes we would need and their responsibilities are:
- StockMarket: has a collection of stocks and produces stock price updates.
- Stock: represents a stock and has a price.
- StockEvent: represents a stock price update and contains the stock and the new price.
- StockEventMediator: handles the relationship between the stock markets and the subscribers. It is responsible for registering the subscribers and notifying them when the stock price changes.
- StockEventListener: represents a subscriber and has a method to receive stock price updates

How this would work is:
- When the price of a stock changes the StockMarket would create a StockEvent and send it to the StockEventMediator.
- When the StockEventMediator receives the StockEvent it would notify all the registered subscribers.
- When the subscriber(StockEventListener) receives the StockEvent it would do whatever it needs to do with the stock price update (send an email, update a database, etc.)
- These classes would be simple interfaces and for the purpose of the interview likely only have one or two simple implementations.