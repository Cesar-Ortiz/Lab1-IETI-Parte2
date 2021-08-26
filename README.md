# Spring Boot Rest API

## Part 2: Implementing the Tasks Microservice RESTFUL API

Create a new package called dto and inside define your TaskDto object with at least the following fields:

- name.
- description.
- status [TODO, DOING, REVIEW and DONE].
- assignedTo.
- dueDate.
- created.

Create a new package called data and inside define your Task data object with at least the following fields:

- id.
- name.
- description.
- status [TODO, DOING, REVIEW and DONE].
- assignedTo.
- dueDate.
- created.

Create a new package called service an inside create the following interface:

Create an implementation of the TaskService using a HashMap data structure inside.
Make your service implementation TaskServiceHashMap injectable using the @Service annotation.

Implement you TaskController (try to avoid copy paste, use the User Microservice as reference but try doing it consciously).

Test ALL the endpoints of your API using PostMan or any other tool of your preference.
