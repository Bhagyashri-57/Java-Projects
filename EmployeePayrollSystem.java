import java.util.Scanner;

class Employee {

    int empId;
    String empName;
    double basicSalary;
    double hra;
    double da;
    double grossSalary;

    void getDetails() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        empName = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        basicSalary = sc.nextDouble();
    }

    void calculateSalary() {

        hra = basicSalary * 0.20; // 20% HRA
        da = basicSalary * 0.10;  // 10% DA

        grossSalary = basicSalary + hra + da;
    }

    void display() {

        System.out.println("\n===== EMPLOYEE PAYROLL DETAILS =====");

        System.out.println("Employee ID      : " + empId);
        System.out.println("Employee Name    : " + empName);
        System.out.println("Basic Salary     : " + basicSalary);
        System.out.println("HRA (20%)        : " + hra);
        System.out.println("DA (10%)         : " + da);
        System.out.println("Gross Salary     : " + grossSalary);
    }
}

public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.getDetails();

        emp.calculateSalary();
        emp.display();
    }
}