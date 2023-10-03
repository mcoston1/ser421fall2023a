SER 421 Rest Lab

To-Do
1. Create a survey item. xx
2. Create a survey. xx
3. Add a survey item to a survey. xx
4. Get the set of all surveys. xx
5. Get a specific survey and the set of all survey items in that survey xx

6. Create a survey instance of a survey for a user, with the associated set of survey item instances.
7. Accept an answer for a survey item instance on a specific survey instance.
8. Retrieve the set of all survey instances in a given state; if no state is given return all survey instances x - needs testing - 
9. Retrieve a specific survey instance with all of the survey item instances contained with it.

10. Delete a specific survey xx




- finish service implementation for instance methods
-- iterate over survey items with new survey instance to create survey item instances
-- create PUT method for answer acceptance - maybe create survey item answer request class?
--- add state change when answer is given to each survey item instance
-- retrieve survey instance via survey id & username - maybe put in survey controller 
--

- Write up postman collection
- add linkage/navigation
- add better error handling
- write up test cases for postman
- write up api documentation