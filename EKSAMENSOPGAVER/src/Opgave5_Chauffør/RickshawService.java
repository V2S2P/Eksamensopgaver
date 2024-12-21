package Opgave5_Chauffør;

import java.util.ArrayList;
import java.util.Scanner;

public class RickshawService {
    private String[][] districts;
    private ArrayList<Driver> drivers;
    public RickshawService(){
        this.districts = new String[3][3];
        this.drivers = new ArrayList<>();
    }
    public void createDriver(String name,int[] destinationCoverage){
        Driver driver = new Driver(name,destinationCoverage);
        System.out.println("Driver has been added: " + driver.hashCode());
        drivers.add(driver);
        System.out.println(drivers.getFirst());
    }
    public void bookDriver(){
        System.out.println("Please choose a destination (1-9)");
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("1) Christiania");
        destinations.add("2) Operaen");
        destinations.add("3) Havnebad Islands Brygge");
        destinations.add("4) Tivoli");
        destinations.add("5) Rådhuspladsen");
        destinations.add("6) Christiansborg");
        destinations.add("7) Amalienborg");
        destinations.add("8) Strøget");
        destinations.add("9) Nyhavn");

        for (String destination : destinations) {
            System.out.println(destination);
        }

        int choice = scanner.nextInt();
        switch (choice){
            case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
                String result = findDriver(choice);
                System.out.println(result);
                break;
            default:
                System.out.println("Invalid choice. Please choose between 1-9");
        }
    }
    private String findDriver(int districtNumber){
        for (Driver driver : drivers){
            for (int district : driver.districtCoverage){
                if (district == districtNumber && !driver.isBooked){
                    driver.isBooked = true;
                    return "Driver found: " + driver.name + " (is now booked)";
                }
            }
        }
        return "No driver available for district " + districtNumber;
    }
}
