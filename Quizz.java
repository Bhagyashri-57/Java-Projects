import java.util.Scanner;

public class Quizz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int score = 0;

        System.out.println("===== JAVA QUIZ APPLICATION =====");

        // Question 1
        System.out.println("\n1. Which language is platform independent?");
        System.out.println("1. C");
        System.out.println("2. Java");
        System.out.println("3. Python");
        System.out.println("4. HTML");

        int ans1 = sc.nextInt();

        if(ans1 == 2) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
        }

        // Question 2
        System.out.println("\n2. Which keyword is used to create object?");
        System.out.println("1. class");
        System.out.println("2. import");
        System.out.println("3. new");
        System.out.println("4. public");

        int ans2 = sc.nextInt();

        if(ans2 == 3) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
        }

        // Question 3
        System.out.println("\n3. Which method is entry point of Java?");
        System.out.println("1. start()");
        System.out.println("2. run()");
        System.out.println("3. print()");
        System.out.println("4. main()");

        int ans3 = sc.nextInt();

        if(ans3 == 4) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
        }

        // Final Score
        System.out.println("\n===== RESULT =====");
        System.out.println("Your Score: " + score + "/3");

        if(score == 3) {
            System.out.println("Excellent!");
        }
        else if(score == 2) {
            System.out.println("Good Job!");
        }
        else {
            System.out.println("Keep Practicing!");
        }

        sc.close();
    }
}