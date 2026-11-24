
import java.util.ArrayList;
import java.util.Scanner;

class ParkingSlot {
    int slotNumber;
    boolean occupied;
    String vehicleNumber;
    String vehicleType;

    ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.occupied = false;
        this.vehicleNumber = "";
        this.vehicleType = "";
    }
}

public class SmartParking {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<ParkingSlot> slots = new ArrayList<>();

    static final int TOTAL_SLOTS = 10;
    static final double RATE_PER_HOUR = 30.0;

    static void initializeParking() {
        for (int i = 1; i <= TOTAL_SLOTS; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    static void displaySlots() {

        System.out.println("\n========== PARKING SLOT STATUS ==========");

        for (ParkingSlot slot : slots) {

            System.out.print("Slot " + slot.slotNumber + " : ");

            if (slot.occupied) {
                System.out.println("OCCUPIED - " + slot.vehicleNumber);
            } else {
                System.out.println("AVAILABLE");
            }
        }
    }

    static void parkVehicle() {

        System.out.print("\nEnter Vehicle Number: ");
        String number = sc.nextLine().trim().toUpperCase();

        if (number.isEmpty()) {
            System.out.println("Vehicle number cannot be empty.");
            return;
        }

        for (ParkingSlot slot : slots) {
            if (slot.occupied &&
                slot.vehicleNumber.equalsIgnoreCase(number)) {
                System.out.println("This vehicle is already parked!");
                return;
            }
        }

        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Two Wheeler");
        System.out.println("2. Four Wheeler");

        int type = readInt("Enter choice: ");

        if (type != 1 && type != 2) {
            System.out.println("Invalid vehicle type!");
            return;
        }

        for (ParkingSlot slot : slots) {

            if (!slot.occupied) {

                slot.occupied = true;
                slot.vehicleNumber = number;

                slot.vehicleType =
                    (type == 1) ? "Two Wheeler" : "Four Wheeler";

                System.out.println("\nVehicle Parked Successfully!");
                System.out.println("Vehicle Number: " + number);
                System.out.println("Vehicle Type: " + slot.vehicleType);
                System.out.println("Allocated Slot: " + slot.slotNumber);

                return;
            }
        }

        System.out.println("\nSorry! Parking is Full.");
    }

    static void removeVehicle() {

        System.out.print("\nEnter Vehicle Number: ");
        String number = sc.nextLine().trim().toUpperCase();

        for (ParkingSlot slot : slots) {

            if (slot.occupied &&
                slot.vehicleNumber.equalsIgnoreCase(number)) {

                System.out.print("Enter Parking Duration (hours): ");
                double hours = readDouble();

                if (!Double.isFinite(hours) ||
                    hours <= 0 || hours > 10000) {
                    System.out.println("Invalid parking duration!");
                    return;
                }

                double amount = hours * RATE_PER_HOUR;

                System.out.println("\n========== PARKING BILL ==========");
                System.out.println("Vehicle Number : " + number);
                System.out.println("Vehicle Type   : " + slot.vehicleType);
                System.out.println("Slot Number    : " + slot.slotNumber);
                System.out.println("Duration       : " + hours + " hours");
                System.out.println("Rate           : Rs. " + RATE_PER_HOUR);
                System.out.println("Total Amount   : Rs. " + amount);

                slot.occupied = false;
                slot.vehicleNumber = "";
                slot.vehicleType = "";

                System.out.println("\nPayment Completed!");
                System.out.println("Parking Slot Released Successfully!");

                return;
            }
        }

        System.out.println("Vehicle Not Found!");
    }

    static void searchVehicle() {

        System.out.print("\nEnter Vehicle Number: ");
        String number = sc.nextLine().trim().toUpperCase();

        for (ParkingSlot slot : slots) {

            if (slot.occupied &&
                slot.vehicleNumber.equalsIgnoreCase(number)) {

                System.out.println("\nVehicle Found!");
                System.out.println("Vehicle Number: " + slot.vehicleNumber);
                System.out.println("Vehicle Type: " + slot.vehicleType);
                System.out.println("Parking Slot: " + slot.slotNumber);

                return;
            }
        }

        System.out.println("Vehicle Not Found!");
    }

    static void displayStatistics() {

        int occupied = 0;

        for (ParkingSlot slot : slots) {
            if (slot.occupied) {
                occupied++;
            }
        }

        int available = TOTAL_SLOTS - occupied;

        System.out.println("\n========== PARKING STATISTICS ==========");
        System.out.println("Total Slots     : " + TOTAL_SLOTS);
        System.out.println("Occupied Slots  : " + occupied);
        System.out.println("Available Slots : " + available);

        System.out.println("Parking Usage   : "
                + (occupied * 100 / TOTAL_SLOTS) + "%");
    }

    static int readInt(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static double readDouble() {
        try {
            return Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {

        initializeParking();

        int choice;

        System.out.println("======================================");
        System.out.println("     SMART PARKING MANAGEMENT SYSTEM");
        System.out.println("======================================");

        do {

            System.out.println("\n1. View Parking Slots");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Parking Statistics");
            System.out.println("6. Exit");

            choice = readInt("\nEnter Your Choice: ");

            switch (choice) {

                case 1:
                    displaySlots();
                    break;

                case 2:
                    parkVehicle();
                    break;

                case 3:
                    removeVehicle();
                    break;

                case 4:
                    searchVehicle();
                    break;

                case 5:
                    displayStatistics();
                    break;

                case 6:
                    System.out.println("\nThank You for Using Smart Parking!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
