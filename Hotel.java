import java.util.Scanner;

public class Hotel {

    static int rooms = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Book Room 2.Available Rooms 3.Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    if(rooms > 0) {
                        rooms--;
                        System.out.println("Room Booked");
                    } else {
                        System.out.println("No Rooms Available");
                    }
                    break;

                case 2:
                    System.out.println("Rooms Left: " + rooms);
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}