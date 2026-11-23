import java.util.Scanner;

public class EmergencyAlert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Emergency System");
        System.out.println("1. Accident");
        System.out.println("2. Fire");
        System.out.println("3. Medical Emergency");
        System.out.println("4. Other");

        System.out.print("Select emergency: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Accident Alert Activated!");
                System.out.println("Contacting emergency services...");
                break;

            case 2:
                System.out.println("Fire Alert Activated!");
                System.out.println("Evacuate the building immediately!");
                break;

            case 3:
                System.out.println("Medical Alert Activated!");
                System.out.println("Requesting medical assistance...");
                break;

            case 4:
                System.out.println("Emergency Alert Activated!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}