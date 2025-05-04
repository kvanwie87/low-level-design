# Elevator Case Study
## Problem Statement
- Design an elevator system that can handle a single elevator with multiple floors. 
- The system should be able to handle requests from users on different floors and move the elevator accordingly. 
- The elevator should also have an open and close door mechanism.
## Thoughts
It is pretty easy to reason about the elevator as a state machine. The elevator could have states for stopped, moving up, moving down, opening door, closing door, etc. You could model your code using these states with the state pattern. Given the relatively simple problem statement it would work fine. The issue with the state pattern though is as the problem gets more complicated and you start adding more conditions and more states it doesn't scale. 

Generally we should favor composition over inheritance and the state pattern is a form of inheritance. As you add more states and more conditions the class hierarchy of the state pattern becomes a mess. It becomes hard for the states to really even fit under the same class hierarchy at all.

So while the state pattern may work for the given problem statement if the interviewer asks "What if?..." you should be ready to pivot to a more compositional approach.

I would be inclined to model the elevator as an event driven system (observer pattern). You could have events for call buttons, floor selection, the elevator moving up, moving down, opening door, closing door, etc. Then you could have event listeners handle events and interact with the appropriate components of the elevator. I feel this is a more flexible approach and would be easier to extend in the future. As adding new events and listeners doesn't alter the existing code.