
import java.util.Scanner;

public class StudentPerformancePredictor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   STUDENT PERFORMANCE PREDICTOR");
        System.out.println("====================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter USN: ");
        String usn = sc.nextLine();

        String[] subjects = {
            "Java", "Python", "Mathematics",
            "Computer Networks", "AI & ML"
        };

        int[] marks = new int[5];
        int total = 0;
        int lowest = 100;
        int highest = 0;
        String weakSubject = "";
        String bestSubject = "";

        System.out.println("\nEnter marks out of 100:");

        for (int i = 0; i < subjects.length; i++) {

            System.out.print(subjects[i] + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter between 0 and 100.");
                i--;
                continue;
            }

            total += marks[i];

            if (marks[i] < lowest) {
                lowest = marks[i];
                weakSubject = subjects[i];
            }

            if (marks[i] > highest) {
                highest = marks[i];
                bestSubject = subjects[i];
            }
        }

        double percentage = total / 5.0;

        String grade;
        String prediction;
        String suggestion;

        if (percentage >= 90) {
            grade = "A+";
            prediction = "Excellent Performance";
            suggestion = "Maintain your excellent performance!";
        }
        else if (percentage >= 80) {
            grade = "A";
            prediction = "Very Good Performance";
            suggestion = "Practice advanced concepts.";
        }
        else if (percentage >= 70) {
            grade = "B";
            prediction = "Good Performance";
            suggestion = "Focus on improving difficult topics.";
        }
        else if (percentage >= 60) {
            grade = "C";
            prediction = "Average Performance";
            suggestion = "Increase daily study time.";
        }
        else if (percentage >= 40) {
            grade = "D";
            prediction = "Needs Improvement";
            suggestion = "Practice regularly and revise subjects.";
        }
        else {
            grade = "F";
            prediction = "At Risk";
            suggestion = "Seek guidance and prepare a study plan.";
        }

        System.out.println("\n====================================");
        System.out.println("       STUDENT REPORT");
        System.out.println("====================================");

        System.out.println("Student Name : " + name);
        System.out.println("USN          : " + usn);

        System.out.println("\nSubject-wise Marks:");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + " : " + marks[i]);
        }

        System.out.println("\nTotal Marks  : " + total + "/500");
        System.out.printf("Percentage   : %.2f%%\n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("Prediction   : " + prediction);

        System.out.println("\nBest Subject : " + bestSubject);
        System.out.println("Weak Subject : " + weakSubject);

        System.out.println("\nSuggestion   : " + suggestion);

        System.out.println("====================================");

        sc.close();
    }
}