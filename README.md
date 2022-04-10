# Wayfair Java Spring Take Home Assignment

Welcome to the Wayfair take home interview! Feel free to read this document and the user stories, but take your time, and 
really think through what we're asking for, and how you will structure your code and satisfy the user stories.

## Objectives
The objective of this take-home exercise:
- To demonstrate how you write code, and your ability to convert user stories into deliverables.
- To set up a base environment for a live pair-programming exercise.
- To set up context for a discussion about how a real-world checkout microservice should be designed. What would it take to go from this simple "toy" checkout service, to something that a company like ours could use?
 
## How to come across well

The things that we are looking for as interviewers are:
* Code that is readable with consistent formatting.
* Code that conforms to good principles, such as KISS/DRY/SOLID/YAGNI.
* Code that demonstrates a test-oriented design (such as TDD) with good code coverage.
* Well-structured commits which demonstrate your thought process building a feature.
* You will not be judged on whether you use Spring Boot optimally, rather we are looking at the Java code quality and structure.
* There are no bonus points for sending more code or implementing more features, we prefer if you focus on smaller scope and do it well.

## Deliverables

We would like the solution to be written using Spring Boot on JDK11. 

In order to complete this assignment, please follow these steps:
  1. Clone this repository.
  2. Create your own personal branch where you can develop your service.
  3. Work on the selected user stories you chose to implement.
  4. Once you are happy with your work, and you have fulfilled the requirements to the best of your ability, create a pull request from your branch to `main`, and let us know by replying to the person who sent you the task details.
     **Please make sure that exactly _one_ pull request is created, and that nothing is merged to `main` yet.**

## Take Home Assessment

Let's imagine we've decided to write a new checkout microservice for a brand new e-commerce website named Mayfair, not to be confused
with Wayfair, of course. We would like you to read the user stories, select which ones you would like to work on, come up with a working MVP which would have all the features
one would expect to see in production code.

### User Stories

When you feel you have read the above sections and feel comfortable with what we're looking for in this assignment, please follow the links 
below to get the user stories.

**Please pick just one, maximum two of these user stories for the take-home portion of this exercise, and please do not spend more than 2-3 hours of work on this assignment.**

* [User Story 1](docs/user-story-1.md) - Adding products to the basket
* [User Story 2](docs/user-story-2.md) - Removing products from the basket
* [User Story 3](docs/user-story-3.md) - Calculating a total value of a basket
* [User Story 4](docs/user-story-4.md) - Enable checkout by sending the basket id and cost to our Payment service
