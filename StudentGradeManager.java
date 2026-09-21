import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayLists to store student names and marks
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentMarks = new ArrayList<>();

        System.out.println("======================================");
        System.out.println("       STUDENT GRADE MANAGER");
        System.out.println("======================================");

        // Get number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); // Consume newline

            studentNames.add(name);
            studentMarks.add(marks);
        }

        // Calculate total, highest and lowest
        double total = 0;
        double highest = studentMarks.get(0);
        double lowest = studentMarks.get(0);

        for (double marks : studentMarks) {

            total = total + marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        // Calculate average
        double average = total / n;

        // Display summary report
        System.out.println("\n\n======================================");
        System.out.println("          STUDENT GRADE REPORT");
        System.out.println("======================================");

        System.out.printf("%-20s %-10s%n", "Student Name", "Marks");
        System.out.println("--------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %-10.2f%n",
                    studentNames.get(i),
                    studentMarks.get(i));
        }

        System.out.println("--------------------------------------");
        System.out.printf("Average Score : %.2f%n", average);
        System.out.printf("Highest Score : %.2f%n", highest);
        System.out.printf("Lowest Score  : %.2f%n", lowest);
        System.out.println("======================================");

        sc.close();
    }
}