
import java.util.*;

public class EmergencyAlertSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> alertHistory = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   SMART EMERGENCY ALERT SYSTEM");
        System.out.println("==================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = sc.nextLine();

        int choice;

        do {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1. Medical Emergency");
            System.out.println("2. Accident Alert");
            System.out.println("3. Fire Emergency");
            System.out.println("4. Personal Safety Alert");
            System.out.println("5. View Alert History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    sendAlert(name, phone, "Medical Emergency");
                    break;

                case 2:
                    sendAlert(name, phone, "Accident Alert");
                    break;

                case 3:
                    sendAlert(name, phone, "Fire Emergency");
                    break;

                case 4:
                    sendAlert(name, phone, "Personal Safety Alert");
                    break;

                case 5:
                    System.out.println("\n--- ALERT HISTORY ---");

                    if (alertHistory.isEmpty()) {
                        System.out.println("No alerts found.");
                    } else {
                        for (String alert : alertHistory) {
                            System.out.println(alert);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void sendAlert(String name, String phone,
                        String emergencyType) {

        System.out.print("Enter your current location: ");
        String location = sc.nextLine();

        String alert = "Emergency: " + emergencyType
                + " | Name: " + name
                + " | Phone: " + phone
                + " | Location: " + location;

        alertHistory.add(alert);

        System.out.println("\n================================");
        System.out.println("       EMERGENCY ALERT");
        System.out.println("================================");

        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Emergency: " + emergencyType);
        System.out.println("Location: " + location);

        System.out.println("\nALERT GENERATED SUCCESSFULLY!");
        System.out.println("Please contact the appropriate");
        System.out.println("emergency services immediately.");

        System.out.println("================================");
    }
}