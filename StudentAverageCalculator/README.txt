# Student Average Calculator (Java + Swing + MySQL)

## Features:
- Add student details (Roll No, Name, Class, Marks for 3 subjects)
- Calculate percentage and grade
- Store data in MySQL
- View all students in a specific class

## Requirements:
- Java JDK 8+
- MySQL Server
- mysql-connector-java.jar (place in `lib/` folder and add to classpath)

## Database Setup:
1. Open MySQL and run the following:

CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100),
    class VARCHAR(20),
    mark1 FLOAT,
    mark2 FLOAT,
    mark3 FLOAT,
    percentage FLOAT,
    grade VARCHAR(2)
);

2. Update your MySQL `username` and `password` in the Java file.
3. Compile and run the project.
