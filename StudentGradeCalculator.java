import java.util.Scanner;

public class StudentGradeCalculator{

    public static String calculateGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();


            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter a value between 0 and 100.");
                i--;
                continue;
            }

            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;


        String grade = calculateGrade(averagePercentage);


        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}