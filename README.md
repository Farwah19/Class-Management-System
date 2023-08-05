# Class Management System (JAVA Program)

## Introduction
This is a simple Class Management System implemented in Java. It allows you to manage student records, calculate their GPA and CGPA, and display the results for the class.

## Program Description
The program includes the following functionalities:

1. Adding student details (name, roll number, and attendance).
2. Entering subject marks for each student and calculating their GPA.
3. Calculating the CGPA based on the previous semester's GPA (if any) and credit hours.
4. Determining the grade based on the CGPA.
5. Displaying the result for each student in the class.

## How to Run
1. Compile the Java source file `Final3.java`.
2. Run the compiled class file `Final3.class`.
3. The program will present a menu with different options. Follow the on-screen instructions to perform desired operations.

## Program Structure
The Java program is structured as follows:

1. Class `Final3`: The main class that contains the entry point of the program.
2. `detailsOfStudent(int classCapacity)`: Method to input details (name, roll number, and attendance) of students.
3. `marksOfStudent()`: Method to input subject marks for each student and calculate total points.
4. `gradePoints(char Grade)`: Method to determine grade points based on the grade.
5. `calculateGPA(double totalPoints, double totalHours)`: Method to calculate GPA.
6. `cgpa(double gpa, double totalHours)`: Method to calculate CGPA based on previous GPA and credit hours.
7. `StudentGrade(double CGPA)`: Method to determine the grade based on CGPA.
8. `displayResult(String[][] record, int classCapacity, double GPA, double CGPA, char grade)`: Method to display the result for each student in the class.
9. The `main` method: Handles the overall program flow and menu.

## Notes
- The program uses a 2D array (`record`) to store student details and subject marks.
- The program catches `InputMismatchException` to handle invalid user inputs.
- Make sure to compile and run the program using a Java compiler or IDE.

## License

This project is licensed under the ownership of Farwah Hamid.

## Contact

For further queries contact farwah.hamid21@gmail.com
