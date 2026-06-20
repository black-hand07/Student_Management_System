import java.util.*;
import java.io.*;

// Student class represents a student record
class Student
{
    int studentId;
    String studentName;
    int age;
    String dob;

    // Constructor to initialize student details
    Student(int studentId, String studentName, int age, String dob)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.dob = dob;
    }

    // ArrayList acts as in-memory storage for students
    static ArrayList<Student> students = new ArrayList<>();

    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    // Method to add a new student
    static void addStudent()
    {
        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check if Student ID already exists
        for(Student s : students)
        {
            if(s.studentId == id)
            {
                System.out.println("Student ID already exists.");
                return;
            }
        }
        // Get Student details from user
        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date of Birth (DD/MM/YYYY) : ");
        String dob = sc.nextLine();

        // Add student to ArrayList
        students.add(new Student(id, name, age, dob));

        // Save records to file
        saveToFile();

        System.out.println("Student added successfully.");
    }
    // Method to view all students
    static void viewStudents()
    {
        if(students.isEmpty())
        {
            System.out.println("No students available.");
            return;
        }
        // Traverse ArrayList and display Student details
        for(Student s : students)
        {
            System.out.println(s.studentId + " | " +s.studentName + " | " +s.age + " | " +s.dob);
        }
    }

    // Method to search student by ID
    static void searchStudent()
    {
        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        // Search Student in ArrayList
        for(Student s : students)
        {
            if(s.studentId == id)
            {
                System.out.println("Student Found");
                System.out.println("ID   : " + s.studentId);
                System.out.println("Name : " + s.studentName);
                System.out.println("Age  : " + s.age);
                System.out.println("DOB  : " + s.dob);
                return;
            }
        }
        // If no matching Student found
        System.out.println("Student not found.");
    }

    // Method to update student details
    static void updateStudent()
    {
         // Search Student by ID
        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        // Update Student information
        for(Student s : students)
        {
            if(s.studentId == id)
            {
                System.out.print("Enter New Student Name : ");
                s.studentName = sc.nextLine();

                System.out.print("Enter New Age : ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New DOB (DD/MM/YYYY) : ");
                s.dob = sc.nextLine();
                // Save updated records to file
                saveToFile();

                System.out.println("Student updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Method to delete student
    static void deleteStudent()
    {
        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        for(Student s : students)
        {
            if(s.studentId == id)
            {
                 // Remove Student from ArrayList
                students.remove(s);
                 // Save updated records after deletion
                saveToFile();

                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // FILE HANDLING: Save all students records into students.txt
    static void saveToFile()
    {
        try
        {
             // Create students.txt if it does not exist and open it for writing
            FileWriter fw = new FileWriter("students.txt");
            // Write each student record into file
            for(Student s : students)
            {
                fw.write(s.studentId + "," +s.studentName + "," +s.age + "," +
                         s.dob + "\n");
            }
            // Close file after writing
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("Error saving file.");
        }
    }

    // Load student records from students.txt
    static void loadFromFile()
    {
        try
        {
            File file = new File("students.txt");
            // Check if file exists
            if(!file.exists())
                return;

            Scanner fileScanner = new Scanner(file);
            // Read records line by line
            while(fileScanner.hasNextLine())
            {

                String line = fileScanner.nextLine();
                // Split data using comma delimiter
                String[] data = line.split(",");
                // Create Student object and add to ArrayList
                students.add(new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]
                ));
            }
            // Close file after reading
            fileScanner.close();
        }
        catch(Exception e)
        {
            System.out.println("Error loading file.");
        }
    }

    // Main Method
    public static void main(String[] args)
    {
        // Load existing records
        loadFromFile();
        // Infinite loop to repeatedly display menu
        while(true)
        {
            System.out.println("\n******** STUDENT MANAGEMENT SYSTEM ********");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("*******************************************");
            // Perform operation based on user choice
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            System.out.println("*******************************************");

            switch(choice)
            {
                case 1:
                    addStudent();  //Adds Student
                    break;

                case 2:
                    viewStudents();  //View Student Details
                    break;

                case 3:
                    searchStudent();  //Search Student using ID
                    break;

                case 4:
                    updateStudent();  //Update Student Details
                    break;

                case 5:
                    deleteStudent();  // Delete Student Details
                    break;

                case 6:
                    System.exit(0);    //Exit the Program

                default:
                    System.out.println("Invalid Choice"); // Handle invalid menu choice
            }
        }
    }
}