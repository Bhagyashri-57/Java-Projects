import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doctor {
    private String doctorName;
    private String specialist;

    public Doctor(String doctorName, String specialist) {
        this.doctorName = doctorName;
        this.specialist = specialist;
    }

    public String getDoctorName() { 
        return doctorName; 
    }
    public String getSpecialist() { 
        return specialist; 
    }

    public void display() {
        System.out.println("Name       : " + doctorName);
        System.out.println("Specialist : " + specialist);
    }
}

class Patient {
    private String patientId;
    private String patientName;
    private int age;

    public Patient(String patientId, String patientName, int age) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
    }

    public String getPatientId()   { 
        return patientId; 
    }
    public String getPatientName() {
         return patientName;
    }
    public int getAge() {
         return age; 
    }

    public void display() {
        System.out.println("ID   : " + patientId);
        System.out.println("Name : " + patientName);
        System.out.println("Age  : " + age);
    }
}


class Appointment {
    private int date;
    private String day;
    private String time;

    public Appointment(int date, String day, String time) {
        this.date = date;
        this.day  = day;
        this.time = time;
    }

    public int    getDate() { 
        return date;
    }
    public String getDay()  { 
        return day; 
    }
    public String getTime() { 
        return time;
    }

    public void display() {
        System.out.println("Date : " + date);
        System.out.println("Day  : " + day);
        System.out.println("Time : " + time);
    }
}

public class HospitalSimulation {

    static Scanner sc = new Scanner(System.in);
    static List<Patient>     patients     = new ArrayList<>(); 
    static List<Doctor>      doctors      = new ArrayList<>();  
    static List<Appointment> appointments = new ArrayList<>();  

    public static void patientSimulation() {                  
        System.out.println("Enter the below Patient details:");
        System.out.print("Enter PatientId: ");
        String patientId = sc.next();
        System.out.print("Enter PatientName: ");
        String patientName = sc.next();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Patient p = new Patient(patientId, patientName, age);
        patients.add(p);                                       
        System.out.println("Patient details added successfully!");
        p.display();
    }

    public static void doctorSimulation() {                    
        System.out.println("Enter the below Doctor details:");
        System.out.print("Enter Doctor Name: ");
        String doctorName = sc.next();
        System.out.print("Enter Specialist: ");
        String specialist = sc.next();

        Doctor d = new Doctor(doctorName, specialist);
        doctors.add(d);                                         
        System.out.println("Doctor details added successfully!");
        d.display();
    }

    public static void appointmentSimulation() {               
        System.out.println("Enter Appointment details:");
        System.out.print("Enter Date (number): ");
        int date = sc.nextInt();
        System.out.print("Enter Day: ");
        String day = sc.next();
        System.out.print("Enter Time: ");
        String time = sc.next();

        Appointment a = new Appointment(date, day, time);
        appointments.add(a);                                    
        System.out.println("Appointment fixed successfully!");
        a.display();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= Welcome To Patil's Hospital =========");
            System.out.println("Select from the below operations:");
            System.out.println("1. ADD PATIENT DETAILS");
            System.out.println("2. ADD DOCTOR DETAILS");
            System.out.println("3. FIX APPOINTMENT");
            System.out.println("4. EXIT");           
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: patientSimulation();     
                break;
                case 2: doctorSimulation();      
                break;
                case 3: appointmentSimulation(); 
                break;
                case 4:
                    System.out.println("Thank you for visiting Patil's Hospital!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option! Please choose 1-4.");
            }
        }
    }
}