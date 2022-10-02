# FilmQueryProject

## Description

This Project allows you to input a specific film ID or a specific key word found in the films description
or title, the film is then printed out for the user to see. The film ID is a primary key, it is unique. 
The keyword search will output all films containing that keyword (not case sensitive). 
The films are pulled from a database and then sorted 
through queries using Java to ensure the user gets the correct output back.

## Technologies Used

JDBC, SQL, Java, Eclipse, and Git

## Lessons Learned

I learned how to query databases using Java.
I implemented SQL statements in strings to query the database.
Using prepared statements within the SQL, I can prevent SQL injection attacks on my program.

One issue with my current program, is the inefficient database querying. 
The database consist of actors and films whom are related through a many to many
relationship. When pulling a film, I also need to pull all of its actors using a 
separate query. I can foresee a join statement to be useful here to minimize the 
database transactions.

I learned how useful classes can be as they relate to database objects, making my code
more readable and DRY. Class objects that relate to database objects solidified 
the concept of objects more clearly, and how data is stored and accessed in 
web applications.
