```java
import java.util.Scanner;

/**
 * Represents a student with their ID, name, department, and grade.
 * This class follows the principle of encapsulation by making attributes private
 * and providing public getter and setter methods.
 */
class Student {
    private int id;
    private String name;
    private String department;
    private double grade;

    /**
     * Constructs a new Student object.
     *
     * @param id         The unique identifier for the student.
     * @param name       The name of the student.
     * @param department The department the student belongs to.
     * @param grade      The student's grade.
     */
    public Student(int id, String name, String department, double grade) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    // --- Getters ---

    /**
     * Gets the student's ID.
     *
     * @return The student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student's department.
     *
     * @return The student's department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets the student's grade.
     *
     * @return The student's grade.
     */
    public double getGrade() {
        return grade;
    }

    // --- Setters ---

    /**
     * Sets the student's ID.
     *
     * @param id The new ID for the student.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the student's name.
     *
     * @param name The new name for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the student's department.
     *
     * @param department The new department for the student.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Sets the student's grade.
     *
     * @param grade The new grade for the student.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Displays the details of the student to the console.
     */
    public void displayStudentDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Grade: " + grade);
    }
}

/**
 * A singly linked list implementation to store Student objects.
 * It provides methods to add students to the list.
 */
class StudentLinkedList {

    /**
     * Represents a node in the linked list. Each node holds a Student object
     * and a reference to the next node in the list.
     */
    private class Node {
        Student student;
        Node next;

        /**
         * Constructs a new Node with the given Student object.
         *
         * @param student The Student object to be stored in this node.
         */
        public Node(Student student) {
            this.student = student;
            this.next = null; // Initially, the next node is null
        }
    }

    private Node head; // The first node in the linked list. Initially null for an empty list.

    /**
     * Adds a new student to the end of the linked list.
     * If the list is empty, the new student becomes the head.
     *
     * @param student The Student object to add to the list.
     */
    public void addStudent(Student student) {
        Node newNode = new Node(student); // Create a new node for the student

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to find the last node
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            // Append the new node to the end of the list
            currentNode.next = newNode;
        }
    }

    // Note: For a complete Student Information System, you would typically add
    // methods for:
    // - Searching for a student by ID or name
    // - Deleting a student
    // - Displaying all students
    // - Updating student information
    // - Handling user input and menu-driven interface (likely in a separate Main class)
}

// Example of how to use the Student and StudentLinkedList classes (optional, for demonstration)
// class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         StudentLinkedList studentList = new StudentLinkedList();
//
//         // Example: Adding a few students
//         Student student1 = new Student(101, "Alice Smith", "Computer Science", 85.5);
//         Student student2 = new Student(102, "Bob Johnson", "Electrical Engineering", 78.0);
//
//         studentList.addStudent(student1);
//         studentList.addStudent(student2);
//
//         // To display students, you would need a displayAllStudents method in StudentLinkedList
//         // For now, we can access them if we had a way to iterate or get them.
//         // For demonstration, let's assume we can access the head and traverse.
//         System.out.println("Students added:");
//         StudentLinkedList.Node current = studentList.head; // Accessing head (requires making head accessible or adding a getter)
//         while (current != null) {
//             current.student.displayStudentDetails();
//             current = current.next;
//         }
//
//         scanner.close();
//     }
// }
```
```java
/**
 * Represents a node in a singly linked list, storing a Student object.
 */
class Node {
    Student student;
    Node next;

    /**
     * Constructs a new Node with the given Student.
     *
     * @param student The Student object to store in this node.
     */
    public Node(Student student) {
        this.student = student;
        this.next = null;
    }
}

/**
 * Manages a collection of students using a singly linked list.
 * Provides functionalities to add, display, and search for students.
 */
class StudentLinkedList {
    private Node head; // The first node in the linked list.

    /**
     * Constructs an empty StudentLinkedList.
     */
    public StudentLinkedList() {
        this.head = null;
    }

    /**
     * Adds a student to the end of the linked list.
     *
     * @param student The Student object to add.
     */
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Displays the details of all students in the linked list.
     * If the list is empty, it prints a message indicating so.
     */
    public void displayAllStudents() {
        Node currentNode = head;
        if (currentNode == null) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("--- All Students ---");
        while (currentNode != null) {
            currentNode.student.displayStudentDetails();
            currentNode = currentNode.next; // Move to the next node
        }
        System.out.println("--------------------");
    }

    /**
     * Searches for a student by their ID using a linear search.
     *
     * @param id The ID of the student to search for.
     * @return The Student object if found, otherwise null.
     */
    public Student searchStudentById(int id) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.student.getId() == id) {
                return currentNode.student; // Return student if ID matches
            }
            currentNode = currentNode.next;
        }
        return null; // Return null if student is not found
    }
}

/**
 * Represents a node in a Binary Search Tree, storing a Student object.
 */
class TreeNode {
    Student student;
    TreeNode left, right;

    /**
     * Constructs a new TreeNode with the given Student.
     *
     * @param student The Student object to store in this node.
     */
    public TreeNode(Student student) {
        this.student = student;
        this.left = this.right = null;
    }
}

/**
 * Manages a collection of students using a Binary Search Tree (BST) for efficient searching by ID.
 */
class StudentBST {
    private TreeNode root; // The root node of the BST.

    /**
     * Constructs an empty StudentBST.
     */
    public StudentBST() {
        this.root = null;
    }

    /**
     * Inserts a student into the binary search tree.
     * The BST is ordered by student ID.
     *
     * @param student The Student object to insert.
     */
    public void insertStudent(Student student) {
        root = insertRecursive(root, student);
    }

    /**
     * Recursive helper method to insert a student into the BST.
     *
     * @param currentNode The current node being considered.
     * @param student     The student to insert.
     * @return The updated root of the subtree.
     */
    private TreeNode insertRecursive(TreeNode currentNode, Student student) {
        // If the tree (or subtree) is empty, return a new node
        if (currentNode == null) {
            return new TreeNode(student);
        }

        // Otherwise, recur down the tree
        if (student.getId() < currentNode.student.getId()) {
            currentNode.left = insertRecursive(currentNode.left, student);
        } else if (student.getId() > currentNode.student.getId()) {
            currentNode.right = insertRecursive(currentNode.right, student);
        }
        // If student ID is equal, we don't insert duplicates (or handle as per requirements)
        // For this implementation, we assume unique IDs or ignore duplicates.

        return currentNode; // Return the (unchanged) node pointer
    }

    /**
     * Searches for a student by their ID using the Binary Search Tree.
     *
     * @param id The ID of the student to search for.
     * @return The Student object if found, otherwise null.
     */
    public Student searchStudentById(int id) {
        return searchRecursive(root, id);
    }

    /**
     * Recursive helper method to search for a student in the BST.
     *
     * @param currentNode The current node being considered.
     * @param id          The ID of the student to search for.
     * @return The Student object if found, otherwise null.
     */
    private Student searchRecursive(TreeNode currentNode, int id) {
        // Base case: root is null or key is present at root
        if (currentNode == null) {
            return null;
        }

        // If id is same as current node's student ID, then return
        if (id == currentNode.student.getId()) {
            return currentNode.student;
        }

        // If id is smaller than root's student ID, then it lies in left
        if (id < currentNode.student.getId()) {
            return searchRecursive(currentNode.left, id);
        }

        // Else the id can only be present in right subtree
        return searchRecursive(currentNode.right, id);
    }
}

/**
 * Represents a student with basic information like ID, name, and marks.
 * This is a placeholder class, assuming it exists and has necessary methods.
 */
class Student {
    private int id;
    private String name;
    private double marks;

    /**
     * Constructs a new Student.
     *
     * @param id    The unique identifier for the student.
     * @param name  The name of the student.
     * @param marks The marks obtained by the student.
     */
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the student.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the marks of the student.
     *
     * @return The student's marks.
     */
    public double getMarks() {
        return marks;
    }

    /**
     * Displays the details of the student to the console.
     */
    public void displayStudentDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

/**
 * The main class for the Student Information System.
 * It manages user interaction, displays menus, and orchestrates operations
 * using StudentLinkedList and StudentBST.
 */
public class StudentInformationSystem {

    // Using a linked list for initial storage and display
    private StudentLinkedList studentList;
    // Using a BST for efficient searching by ID
    private StudentBST studentBST;

    /**
     * Constructs a new StudentInformationSystem.
     * Initializes the data structures for storing student information.
     */
    public StudentInformationSystem() {
        this.studentList = new StudentLinkedList();
        this.studentBST = new StudentBST();
    }

    /**
     * Adds a new student to the system.
     * This method would typically involve user input to get student details.
     * For demonstration, we'll add a few sample students.
     */
    public void addSampleStudents() {
        Student s1 = new Student(101, "Alice", 85.5);
        Student s2 = new Student(103, "Bob", 92.0);
        Student s3 = new Student(102, "Charlie", 78.0);
        Student s4 = new Student(105, "David", 88.5);
        Student s5 = new Student(104, "Eve", 95.0);

        // Add to both structures to maintain consistency for demonstration
        addStudent(s1);
        addStudent(s2);
        addStudent(s3);
        addStudent(s4);
        addStudent(s5);
    }

    /**
     * Adds a student to both the linked list and the BST.
     *
     * @param student The Student object to add.
     */
    private void addStudent(Student student) {
        studentList.addStudent(student);
        studentBST.insertStudent(student);
    }

    /**
     * Displays all students currently in the system.
     * It uses the StudentLinkedList for this operation.
     */
    public void displayAllStudents() {
        studentList.displayAllStudents();
    }

    /**
     * Searches for a student by their ID.
     * It uses the StudentBST for efficient searching.
     *
     * @param id The ID of the student to search for.
     * @return The Student object if found, otherwise null.
     */
    public Student searchStudentById(int id) {
        return studentBST.searchStudentById(id);
    }

    /**
     * The main method to run the Student Information System.
     * It sets up the system, adds sample data, and demonstrates its functionalities.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();

        System.out.println("--- Adding Sample Students ---");
        sis.addSampleStudents();
        System.out.println("Sample students added.\n");

        // Display all students
        sis.displayAllStudents();
        System.out.println();

        // Search for students
        int searchId1 = 102;
        Student foundStudent1 = sis.searchStudentById(searchId1);
        if (foundStudent1 != null) {
            System.out.println("Searching for student with ID " + searchId1 + ":");
            foundStudent1.displayStudentDetails();
        } else {
            System.out.println("Student with ID " + searchId1 + " not found.");
        }
        System.out.println();

        int searchId2 = 106;
        Student foundStudent2 = sis.searchStudentById(searchId2);
        if (foundStudent2 != null) {
            System.out.println("Searching for student with ID " + searchId2 + ":");
            foundStudent2.displayStudentDetails();
        } else {
            System.out.println("Student with ID " + searchId2 + " not found.");
        }
        System.out.println();

        // Example of searching using the linked list (less efficient for large lists)
        System.out.println("--- Demonstrating search using LinkedList (for comparison) ---");
        int searchId3 = 104;
        Student foundStudent3 = sis.studentList.searchStudentById(searchId3);
        if (foundStudent3 != null) {
            System.out.println("Searching for student with ID " + searchId3 + " using LinkedList:");
            foundStudent3.displayStudentDetails();
        } else {
            System.out.println("Student with ID " + searchId3 + " not found in LinkedList.");
        }
        System.out.println("--------------------------------------------------------------");
    }
}
```
```java
import java.util.Scanner;

/**
 * Main class for the Student Information System.
 * This class provides a command-line interface for managing student data
 * using both a LinkedList and a Binary Search Tree (BST).
 */
public class StudentInfoSystem {

    // Scanner for reading user input
    private static final Scanner scanner = new Scanner(System.in);
    // LinkedList to store student data
    private static final StudentLinkedList studentList = new StudentLinkedList();
    // BST to store student data for efficient searching
    private static final StudentBST studentBST = new StudentBST();

    /**
     * The main entry point of the Student Information System.
     * It displays a menu and handles user interactions.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            running = processUserChoice(choice);
        }
        scanner.close(); // Close the scanner when the application exits
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Student Information System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID (LinkedList)");
        System.out.println("4. Search Student by ID (BST)");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Reads and returns the user's menu choice.
     *
     * @return The integer representing the user's choice.
     */
    private static int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        return choice;
    }

    /**
     * Processes the user's chosen option and performs the corresponding action.
     *
     * @param choice The integer representing the user's choice.
     * @return true if the system should continue running, false if it should exit.
     */
    private static boolean processUserChoice(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                return true;
            case 2:
                viewAllStudents();
                return true;
            case 3:
                searchStudentByIdLinkedList();
                return true;
            case 4:
                searchStudentByIdBST();
                return true;
            case 5:
                System.out.println("Exiting Student Information System. Goodbye!");
                return false; // Signal to exit the loop
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                return true;
        }
    }

    /**
     * Handles the logic for adding a new student.
     * Prompts the user for student details and adds them to both data structures.
     */
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Major: ");
        String major = scanner.nextLine();

        Student newStudent = new Student(id, name, major);
        studentList.add(newStudent);
        studentBST.insert(newStudent);
        System.out.println("Student added successfully!");
    }

    /**
     * Handles the logic for viewing all students.
     * Displays students from the LinkedList.
     */
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        if (studentList.isEmpty()) {
            System.out.println("No students in the system yet.");
        } else {
            studentList.display();
        }
    }

    /**
     * Handles the logic for searching a student by ID using the LinkedList.
     */
    private static void searchStudentByIdLinkedList() {
        System.out.println("\n--- Search Student by ID (LinkedList) ---");
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student foundStudent = studentList.searchById(id);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student with ID " + id + " not found in the LinkedList.");
        }
    }

    /**
     * Handles the logic for searching a student by ID using the BST.
     */
    private static void searchStudentByIdBST() {
        System.out.println("\n--- Search Student by ID (BST) ---");
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student foundStudent = studentBST.search(id);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student with ID " + id + " not found in the BST.");
        }
    }

    // Placeholder for StudentLinkedList class (assuming it exists elsewhere)
    static class StudentLinkedList {
        // Dummy implementation for compilation
        public void add(Student student) {}
        public void display() {}
        public Student searchById(int id) { return null; }
        public boolean isEmpty() { return true; }
    }

    // Placeholder for StudentBST class (assuming it exists elsewhere)
    static class StudentBST {
        // Dummy implementation for compilation
        public void insert(Student student) {}
        public Student search(int id) { return null; }
    }

    // Placeholder for Student class (assuming it exists elsewhere)
    static class Student {
        private int id;
        private String name;
        private String major;

        public Student(int id, String name, String major) {
            this.id = id;
            this.name = name;
            this.major = major;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Major: " + major;
        }
    }
}
```
```java
import java.util.Scanner;

/**
 * This class represents the main application for managing student data.
 * It provides a menu-driven interface to add, view, and search for students
 * using both a LinkedList and a Binary Search Tree.
 */
public class StudentManagementApp {

    private StudentList studentList; // Manages students using a LinkedList
    private StudentBST studentBST;   // Manages students using a Binary Search Tree
    private Scanner scanner;         // For user input

    /**
     * Constructor for the StudentManagementApp.
     * Initializes the data structures and the scanner.
     */
    public StudentManagementApp() {
        this.studentList = new StudentList();
        this.studentBST = new StudentBST();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user and handles user input.
     */
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            processChoice(choice);
        } while (choice != 5); // Continue until the user chooses to exit
    }

    /**
     * Displays the available options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID (LinkedList)");
        System.out.println("4. Search Student by ID (BST)");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads and returns the user's menu choice.
     *
     * @return The integer representing the user's choice.
     */
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }

    /**
     * Processes the user's menu choice by calling the appropriate method.
     *
     * @param choice The integer representing the user's choice.
     */
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                viewAllStudents();
                break;
            case 3:
                searchStudentByIdLinkedList();
                break;
            case 4:
                searchStudentByIdBST();
                break;
            case 5:
                exitProgram();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Handles the logic for adding a new student.
     * Prompts the user for student details and adds the student to both data structures.
     */
    private void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character left by nextDouble()

        Student newStudent = new Student(id, name, department, grade);
        studentList.addStudent(newStudent);
        studentBST.insertStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    /**
     * Handles the logic for viewing all students.
     * Displays all students using the StudentList's display method.
     */
    private void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        studentList.displayAllStudents();
    }

    /**
     * Handles the logic for searching a student by ID using the LinkedList.
     * Prompts for an ID, searches, and displays details if found.
     */
    private void searchStudentByIdLinkedList() {
        System.out.println("\n--- Search Student by ID (LinkedList) ---");
        System.out.print("Enter Student ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student foundStudent = studentList.searchStudentById(searchId);
        if (foundStudent != null) {
            foundStudent.displayStudentDetails();
        } else {
            System.out.println("Student with ID " + searchId + " not found!");
        }
    }

    /**
     * Handles the logic for searching a student by ID using the Binary Search Tree.
     * Prompts for an ID, searches, and displays details if found.
     */
    private void searchStudentByIdBST() {
        System.out.println("\n--- Search Student by ID (BST) ---");
        System.out.print("Enter Student ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student foundStudent = studentBST.searchStudentById(searchId);
        if (foundStudent != null) {
            foundStudent.displayStudentDetails();
        } else {
            System.out.println("Student with ID " + searchId + " not found!");
        }
    }

    /**
     * Handles the program exit.
     * Closes the scanner and terminates the application.
     */
    private void exitProgram() {
        System.out.println("Exiting Student Management System. Goodbye!");
        scanner.close(); // Close the scanner to release resources
        System.exit(0);  // Terminate the program
    }

    // --- Placeholder classes for compilation ---
    // In a real application, these would be in separate files.

    /**
     * Represents a student with ID, name, department, and grade.
     */
    static class Student {
        private int id;
        private String name;
        private String department;
        private double grade;

        public Student(int id, String name, String department, double grade) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.grade = grade;
        }

        public int getId() {
            return id;
        }

        public void displayStudentDetails() {
            System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Grade: " + grade);
        }

        @Override
        public String toString() {
            return "Student{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", department='" + department + '\'' +
                   ", grade=" + grade +
                   '}';
        }
    }

    /**
     * Manages a list of students using a LinkedList-like structure.
     * (This is a simplified placeholder for demonstration purposes.)
     */
    static class StudentList {
        // In a real implementation, this would use java.util.LinkedList or a custom implementation.
        private java.util.LinkedList<Student> students = new java.util.LinkedList<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public void displayAllStudents() {
            if (students.isEmpty()) {
                System.out.println("No students in the list.");
                return;
            }
            for (Student student : students) {
                student.displayStudentDetails();
            }
        }

        public Student searchStudentById(int id) {
            for (Student student : students) {
                if (student.getId() == id) {
                    return student;
                }
            }
            return null;
        }
    }

    /**
     * Manages students using a Binary Search Tree based on student ID.
     * (This is a simplified placeholder for demonstration purposes.)
     */
    static class StudentBST {
        private Node root;

        private class Node {
            Student student;
            Node left, right;

            Node(Student student) {
                this.student = student;
                this.left = this.right = null;
            }
        }

        public void insertStudent(Student student) {
            root = insertRec(root, student);
        }

        private Node insertRec(Node root, Student student) {
            if (root == null) {
                root = new Node(student);
                return root;
            }

            if (student.getId() < root.student.getId()) {
                root.left = insertRec(root.left, student);
            } else if (student.getId() > root.student.getId()) {
                root.right = insertRec(root.right, student);
            }
            return root;
        }

        public Student searchStudentById(int id) {
            return searchRec(root, id);
        }

        private Student searchRec(Node root, int id) {
            if (root == null) {
                return null;
            }

            if (id == root.student.getId()) {
                return root.student;
            }

            if (id < root.student.getId()) {
                return searchRec(root.left, id);
            } else {
                return searchRec(root.right, id);
            }
        }
    }

    /**
     * Main method to start the Student Management Application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }
}
```
default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
