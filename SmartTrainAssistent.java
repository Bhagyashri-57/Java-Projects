
import java.util.ArrayList;
import java.util.Scanner;

enum TrainStatus {
    ON_TIME,
    DELAYED,
    ARRIVED
}

class Train {
    int trainNumber;
    String trainName;
    String source;
    String destination;
    String platform;
    String arrivalTime;
    String departureTime;
    TrainStatus status;

    Train(int trainNumber, String trainName,
        String source, String destination,
        String platform, String arrivalTime,
        String departureTime, TrainStatus status) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.platform = platform;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.status = status;
    }

    void displayDetails() {
        System.out.println("\n--------------------------------");
        System.out.println("       TRAIN INFORMATION");
        System.out.println("--------------------------------");
        System.out.println("Train Number   : " + trainNumber);
        System.out.println("Train Name     : " + trainName);
        System.out.println("From           : " + source);
        System.out.println("Destination    : " + destination);
        System.out.println("Platform       : " + platform);
        System.out.println("Arrival Time   : " + arrivalTime);
        System.out.println("Departure Time : " + departureTime);
        System.out.println("Train Status   : " + status);

        if (status == TrainStatus.ON_TIME) {
            System.out.println("Message: Your train is on time.");
        } 
        else if (status == TrainStatus.DELAYED) {
            System.out.println("Message: Your train is delayed.");
        } 
        else {
            System.out.println("Message: Your train has arrived.");
        }

        System.out.println("Please follow the station announcements.");
        System.out.println("--------------------------------");
    }
}

public class SmartTrainAssistent {

    static ArrayList<Train> trains = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static void addTrains() {

        trains.add(new Train(
            12627, "Karnataka Express",
            "Bengaluru", "New Delhi",
            "Platform 1", "06:30 AM",
            "06:45 AM", TrainStatus.ON_TIME
        ));

        trains.add(new Train(
            12027, "Shatabdi Express",
            "Bengaluru", "Chennai",
            "Platform 3", "08:00 AM",
            "08:15 AM", TrainStatus.DELAYED
        ));

        trains.add(new Train(
            16591, "Hampi Express",
            "Hubli", "Mysuru",
            "Platform 2", "10:30 AM",
            "10:45 AM", TrainStatus.ARRIVED
        ));

        trains.add(new Train(
            22691, "Rajdhani Express",
            "Bengaluru", "New Delhi",
            "Platform 4", "07:00 PM",
            "07:15 PM", TrainStatus.ON_TIME
        ));
    }

    static void searchTrain() {

        System.out.print("\nEnter Train Number: ");
        int number = Integer.parseInt(sc.nextLine());

        boolean found = false;

        for (Train t : trains) {

            if (t.trainNumber == number) {
                t.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nSorry! Train not found.");
            System.out.println("Please check the train number.");
        }
    }

    static void displayAllTrains() {

        System.out.println("\n========== AVAILABLE TRAINS ==========");

        for (Train t : trains) {

            System.out.println(
                "Train No: " + t.trainNumber +
                " | Name: " + t.trainName +
                " | Destination: " + t.destination +
                " | Platform: " + t.platform
            );
        }
    }

    static void searchDestination() {

        System.out.print("\nEnter Destination: ");
        String destination = sc.nextLine();

        boolean found = false;

        for (Train t : trains) {

            if (t.destination.equalsIgnoreCase(destination)) {
                t.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains found for this destination.");
        }
    }

    static void boardingReminder() {

        System.out.println("\n========== BOARDING REMINDER ==========");
        System.out.print("Enter Train Number: ");

        int number = Integer.parseInt(sc.nextLine());

        for (Train t : trains) {

            if (t.trainNumber == number) {

                System.out.println("\nHello Passenger!");
                System.out.println("Your train: " + t.trainName);
                System.out.println("Platform: " + t.platform);
                System.out.println("Departure: " + t.departureTime);

                if (t.status == TrainStatus.DELAYED) {
                    System.out.println(
                        "Warning: Train is delayed. Check announcements."
                    );
                } 
                else if (t.status == TrainStatus.ARRIVED) {
                    System.out.println(
                        "Your train has arrived. Please get ready to board."
                    );
                } 
                else {
                    System.out.println(
                        "Please reach the platform before departure."
                    );
                }

                return;
            }
        }

        System.out.println("Train number not found.");
    }

    public static void main(String[] args) {

        addTrains();

        int choice;

        System.out.println("====================================");
        System.out.println("     SMART TRAIN PLATFORM ASSISTANT");
        System.out.println("====================================");

        do {

            System.out.println("\n1. Search Train");
            System.out.println("2. View All Trains");
            System.out.println("3. Search by Destination");
            System.out.println("4. Boarding Reminder");
            System.out.println("5. Exit");

            System.out.print("\nEnter Your Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        searchTrain();
                        break;

                    case 2:
                        displayAllTrains();
                        break;

                    case 3:
                        searchDestination();
                        break;

                    case 4:
                        boardingReminder();
                        break;

                    case 5:
                        System.out.println(
                            "\nThank you for using Smart Train Assistant!"
                        );
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Please enter a valid number.");
            }

        } while (choice != 5);

        sc.close();
    }
}