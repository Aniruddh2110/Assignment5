import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Class
abstract class University {
    private String name;
    private String city;
    private String state;

    public University(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public abstract void displayDetails();
}

// Derived Class
class Institute extends University {
    public Institute(String name, String city, String state) {
        super(name, city, state);
    }

    @Override
    public void displayDetails() {
        System.out.println("Institute Name: " + getName() + ", City: " + getCity() + ", State: " + getState());
    }
}

// Main Class
public class Indian_Institutions {
    private static List<University> universities = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateData();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display all universities");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by City");
            System.out.println("4. Search by State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayUniversities();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByCity();
                    break;
                case 4:
                    searchByState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    private static void populateData() {
        universities.add(new Institute("Aligarh Muslim University", "Aligarh", "Uttar Pradesh"));
        universities.add(new Institute("Banaras Hindu University", "Varanasi", "Uttar Pradesh"));
        universities.add(new Institute("University of Delhi", "Delhi", "Delhi"));
        universities.add(new Institute("Atal Bihari Vajpayee Indian Institute of Information Technology and Management", "Gwalior", "Madhya Pradesh"));
        universities.add(new Institute("Indian Institute of Information Technology, Allahabad", "Allahabad", "Uttar Pradesh"));
        // Add more universities similarly
    }

    private static void displayUniversities() {
        System.out.println("\nList of Universities:");
        for (University uni : universities) {
            uni.displayDetails();
        }
    }

    private static void searchByName() {
        System.out.print("Enter University Name: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (University uni : universities) {
            if (uni.getName().equalsIgnoreCase(name)) {
                uni.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No university found with that name.");
        }
    }

    private static void searchByCity() {
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        boolean found = false;

        for (University uni : universities) {
            if (uni.getCity().equalsIgnoreCase(city)) {
                uni.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No university found in that city.");
        }
    }

    private static void searchByState() {
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        boolean found = false;

        for (University uni : universities) {
            if (uni.getState().equalsIgnoreCase(state)) {
                uni.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No university found in that state.");
        }
    }
}
