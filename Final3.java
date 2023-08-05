import java.util.InputMismatchException;
import java.util.Scanner;
public class Final3 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int classCapacity = 2;
        String[][] record = new String[classCapacity][3];
        double totalPoints = 0;
        double totalHours = 0;
        double CGPA = 0;
        double GPA = 0;
        int choice;
        try {
            do {
                System.out.println("""
                    ---------------------Welcome to your class management system!---------------------- \s
                    Press 1 for adding the details (name, roll number and attendance) of the student! \s
                    Press 2 for entering the marks of the student! \s
                    Press 3 for CGPA calculation! \s
                    Press 4 to display the result of the class! \s
                    Press 0 to exit! \s
                    """);
                System.out.print("Make your choice: ");
                choice = input.nextInt();
                System.out.println();

                switch (choice) {
                    case 1: {
                        record = detailsOfStudent(classCapacity);
                        break;
                    }

                    case 2: {
                        System.out.print("Enter the total credit hours: "); // getting all the credit hours
                        totalHours = input.nextDouble();
                        input.nextLine(); // using input.nextLine() cz without it, the string value on the second iteration wasn't taking input
                        totalPoints = marksOfStudent();
                        break;
                    }
                    case 3: {
                        GPA = calculateGPA(totalPoints,totalHours);
                        System.out.println("The GPA is: " + GPA);
                        System.out.println();
                        CGPA = cgpa(GPA,totalHours);
                        System.out.println("The CGPA is: " + CGPA);
                        System.out.println();
                        break;
                    }

                    case 4: {
                        char grade = StudentGrade(CGPA);
                        displayResult(record,classCapacity,GPA,CGPA,grade);
                        break;
                    }

                    case 0: {
                        System.out.println("Exiting...");
                        break;
                    }

                    default: {
                        System.out.println("Invalid Input!");
                        break;
                    }
                }

            } while (choice != 0);
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid Input!");
        }

    }
    public static String[][] detailsOfStudent(int classCapacity) {
        String[][] record = new String[classCapacity][3];
        try {
            for (int i = 0; i < record.length; i++) {
                input.nextLine();
                System.out.print("Enter the name of the " + (i + 1) + " student: ");
                record[i][0] = input.nextLine();
                System.out.print("Enter the roll number of the " + (i + 1) + " student: ");
                record[i][1] = String.valueOf(input.nextInt());
                System.out.print("Enter the total attendance of the " + (i + 1) + " student: ");
                record[i][2] = String.valueOf(input.nextDouble());
                input.nextLine();
                System.out.println();
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid Input!");
        }
        return record;
    }
    public static double marksOfStudent() {
        String subjectName;
        double totalPoints = 0;
        double marks;
        double hours;
        char Grade;

        try {
            // asking for the total subjects of the students
            System.out.print("Enter the total subjects: ");
            int subjects = input.nextInt();
            input.nextLine();
            System.out.println();

            for (int i = 0; i < subjects; i++) {
                System.out.print("Enter the name of the subject: ");
                subjectName = input.nextLine();

                System.out.print("Enter the number of credit hours of the subject: ");
                hours = input.nextDouble();
                input.nextLine();

                System.out.print("Enter your marks out of 100: ");
                marks = input.nextDouble();
                System.out.println();

                // the marks will be represented by grades which have different points

                if (marks >= 85) {
                    Grade = 'A';
                } else if (marks >= 75) {
                    Grade = 'B';
                } else if (marks >= 60) {
                    Grade = 'C';
                } else if (marks >= 55) {
                    Grade = 'D';
                } else if (marks >= 50) {
                    Grade = 'E';
                } else {
                    Grade = 'F';
                }
                input.nextLine();
                // call the gradePoints function here, so that the total grade points can be calculated
                double points = gradePoints(Grade);
                totalPoints += hours * points;       // determining all the points of the student
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid Input!");
        }
        return totalPoints;
    }
    public static double gradePoints(char Grade) {
        double gradePoints = 0;

        // the points of the grades are then determined according to the given arrangement

        if (Grade == 'A') {
            gradePoints = 4;
        } else if (Grade == 'B') {
            gradePoints = 3;
        } else if (Grade == 'C') {
            gradePoints = 2;
        } else if (Grade == 'D') {
            gradePoints = 1;
        } else if (Grade == 'F') {
            gradePoints = 0;
        } else {
            System.out.print("Invalid!");
        }
        return gradePoints;
    }
    public static double calculateGPA(double totalPoints,double totalHours) {
        double gpa = totalPoints / totalHours; // dividing the total points with the total credit hours
        return gpa;
    }
    public static double cgpa(double gpa, double totalHours) {
        System.out.print("Enter the GPA for the previous semester (if any): ");
        double prevGPA = input.nextDouble();
        System.out.print("Enter the previous credit hours: ");
        double prevHours = input.nextDouble();
        System.out.println();

        // CGPA is calculated by getting all the previous points and previous credit hours
        // then we multiply them both and add them to the product of current gpa and current credit hours
        // then the total points are divided by the total credit hours

        double totalPoints = (prevGPA * prevHours) + (gpa * totalHours) ;
        double totalCreditHours = prevHours + totalHours;
        double CGPA = totalPoints / totalCreditHours;
        return CGPA;
    }

    public static char StudentGrade(double CGPA) {
        char grade;

        // the grades of the student on the basis of GPA are as follows

        if (CGPA >= 3.5) {
            grade = 'A';
        } else if (CGPA >= 3) {
            grade = 'B';
        } else if (CGPA >= 2.5) {
            grade = 'C';
        } else if (CGPA >= 2) {
            grade = 'D';
        } else if (CGPA >= 1) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        return grade;
    }

    public static void displayResult(String[][] record, int classCapacity, double GPA, double CGPA, char grade) {
        String [][] display = new String[classCapacity][7];
        for (int i = 0; i < display.length; i++) {
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("The name of " + (i + 1) + " student is: " + record[i][0]);
            System.out.println("The roll number of " + (i + 1) + " student is: " + record[i][1]);
            System.out.println("The attendance of " + (i + 1) + " student is: " + record[i][2]);
            System.out.println("The GPA of " + (i + 1) + " student is: " + GPA);
            System.out.println("The CGPA of " + (i + 1) + " student is: " + CGPA);
            System.out.println("The grade of " + (i + 1) + " student is: " + grade);
            System.out.println();
            System.out.println("------------------------------------------------------------");
        }
    }

}
