import java.util.Scanner;

public class SmartTraffic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int vehicles = sc.nextInt();

        if (vehicles > 50) {
            System.out.println("Heavy Traffic");
            System.out.println("Green signal duration: 60 seconds");
        } else if (vehicles > 20) {
            System.out.println("Moderate Traffic");
            System.out.println("Green signal duration: 40 seconds");
        } else {
            System.out.println("Low Traffic");
            System.out.println("Green signal duration: 20 seconds");
        }

        sc.close();
    }
}