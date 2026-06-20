# Student Management System

## Overview

The Student Management System is a Java console-based application developed to manage student records efficiently. It allows users to perform CRUD (Create, Read, Update, Delete) operations on student data and stores records permanently using file handling.

The application uses an ArrayList for in-memory data storage and a text file for persistent storage, ensuring that student records are retained even after the program is closed.

---

## Features

* Add new student records
* View all student records
* Search for a student by ID
* Update existing student details
* Delete student records
* Store data permanently using file handling
* Automatically load saved records when the program starts

---

## Technologies Used

* Java
* ArrayList Collection Framework
* File Handling (FileWriter, File, Scanner)
* Exception Handling
* Object-Oriented Programming (OOP)

---

## Student Attributes

Each student record contains the following information:

| Attribute     | Description                     |
| ------------- | ------------------------------- |
| Student ID    | Unique identifier for a student |
| Student Name  | Name of the student             |
| Age           | Student's age                   |
| Date of Birth | Student's DOB (DD/MM/YYYY)      |

---

## Project Structure

```text
StudentManagementSystem/
│
├── Student.java
├── students.txt
└── README.md
```

### File Description

#### Student.java

Contains:

* Student class definition
* CRUD operations
* File handling methods
* Main menu-driven program

#### students.txt

Stores student records in the following format:

```text
21,John,20,08/03/2006
22,Joseph,20,02/09/2006
```

---

## Program Flow

### 1. Application Startup

* Program starts.
* Existing records are loaded from `students.txt`.

### 2. Main Menu

```text
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
```

### 3. Add Student

* Enter Student ID.
* Enter Name.
* Enter Age.
* Enter Date of Birth.
* Record is stored in ArrayList.
* Data is saved to file.

### 4. View Students

* Displays all student records.

### 5. Search Student

* User enters Student ID.
* Program searches and displays student details.

### 6. Update Student

* User enters Student ID.
* Existing details are modified.
* Updated records are saved to file.

### 7. Delete Student

* User enters Student ID.
* Student record is removed.
* File is updated automatically.

### 8. Exit

* Program terminates successfully.

---

## File Handling

### saveToFile()

Responsible for:

* Writing all student records into `students.txt`
* Updating the file whenever records are added, updated, or deleted

### loadFromFile()

Responsible for:

* Reading records from `students.txt`
* Loading them into the ArrayList when the application starts

---

## Exception Handling

The application uses try-catch blocks to handle potential runtime errors during:

* File reading
* File writing
* Data parsing

Example:

```java
try {
    // File operations
}
catch(Exception e) {
    System.out.println("Error loading file.");
}
```

---

## How to Run

### Compile

```bash
javac Student.java
```

### Execute

```bash
java Student
```

---

## Sample Output

```text
******** STUDENT MANAGEMENT SYSTEM ********
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
*******************************************

Enter Choice :
```

---

## Learning Concepts Demonstrated

* Classes and Objects
* Constructors
* ArrayList
* Loops
* Conditional Statements
* CRUD Operations
* File Handling
* Exception Handling
* Menu-Driven Programming

---

## Future Enhancements

* Input Validation
* Date Validation using LocalDate
* Custom Exception Handling
* Separate Classes for CRUD Operations
* Separate FileHandler Class
* Sorting Students
* Search by Name
* GUI using Java Swing or JavaFX

---

### Conclusion

The **Student Management System** is a Java-based application that helps manage student records efficiently using CRUD operations. It utilizes **ArrayList**, **file handling**, and **exception handling** to store, retrieve, update, and delete student information. This project demonstrates fundamental Java programming concepts and provides a strong foundation for developing more advanced management systems in the future.


