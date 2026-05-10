import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Food {
    String food;
    double price;
    int orderNumber;

    public Food(String food, double price, int orderNumber) {
        this.food = food;
        this.price = price;
        this.orderNumber = orderNumber; // FIXED
    }

    public String getfood() {
        return this.food;
    }

    public double getprice() {
        return this.price;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void display() {
        System.out.println("Menu : " + food);
        System.out.println("Cost : " + price);
        System.out.println("Order Number : " + orderNumber);
    }
}

class Category {
    String category;

    public Category(String category) {
        this.category = category;
    }

    public String getcategory() {
        return this.category;
    }

    public void display() {
        System.out.println("Category : " + category);
    }
}

public class RestaurantSimulation {
    static Scanner sc = new Scanner(System.in);
    static List<Food> foodList = new ArrayList<>();     
    static List<Category> categoryList = new ArrayList<>(); 

    public static void foodSimulation() {
        System.out.println("Enter the Food Name: ");
        String name = sc.next();

        System.out.println("Enter the price: ");
        double price = sc.nextDouble();

        System.out.println("Enter Order Number: "); 
        int orderNumber = sc.nextInt();

        Food f = new Food(name, price, orderNumber); 
        foodList.add(f);

        System.out.println("Food Added Successfully!");
        f.display();
    }

    public static void categorySimulation() {
        System.out.println("Select the category (Indian, Continental, Chinese, Italian)");
        String catName = sc.next(); 

        Category c = new Category(catName);
        categoryList.add(c); 

        System.out.println("Category Added Successfully!");
        c.display();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n**** Welcome to Patil's Restaurant ****");
            System.out.println("1. ADD FOOD DETAILS");
            System.out.println("2. SELECT CATEGORY");
            System.out.println("3. EXIT");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    foodSimulation();
                    break;

                case 2:
                    categorySimulation();
                    break;

                case 3:
                    System.out.println("Thank you for visiting Patil's Restaurant!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}