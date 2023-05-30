# RaceCup
### Capstone project EPAM UpSkillMe program
RaceCap is a project developed as part of a curriculum designed to demonstrate Java development skills.

## Main functions

### Race schedule
Create and view future races
Showing the results of past races

### Race results
In the web application, there is a function to set the time result for each participant of the race, based on which the rating will be calculated


### Rating calculation
The application calculates the rating based on the results of past races:
- Personal rating of athletes
- Team rating

### Rating
Distribution by roles has been implemented, which expands the range of available functions for registered users:
- Unauthenticated user
- User
- Athlete
- Organizer
- Admin

## Stack of applied technologies
- Java 11
- Spring framework
- MySQL
- H2 in-memory database for tests
- JUnit
- Mockito
- Thymeleaf
- HTML

### In the next releases
- Logic for processing deleted accounts and races will be added
- Fields for editing information in the personal account for all types of users (now implemented only for the user)
- Custom error handling
- Age validation for racing
