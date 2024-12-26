package Opgave5_Chauffør;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RickshawService {
    private String[][] districts;
    private ArrayList<Driver> drivers;

    public RickshawService() {
        this.districts = new String[3][3];
        this.drivers = new ArrayList<>();
        initializeDistricts();
    }

    public void initializeDistricts() {
        //First array is the districts, second array is destination
        districts[0][0] = "Christiania";
        districts[0][1] = "Operaen";
        districts[0][2] = "Havnebad Islands Brygge";

        districts[1][0] = "Tivoli";
        districts[1][1] = "Rådhuspladsen";
        districts[1][2] = "Christiansborg";

        districts[2][0] = "Amalienborg";
        districts[2][1] = "Strøget";
        districts[2][2] = "Nyhavn";
    }

    public void createDriver(String name, int[] destinationCoverage, double rating) {
        //Driver driver is the reference variable. New driver creates the object in the memory.
        //When something references/calls driver, it uses driver to point to the object in the memory.
        Driver driver = new Driver(name, destinationCoverage, rating);
        //System.out.println("Driver has been added: " + driver.hashCode());
        drivers.add(driver);
        //System.out.println(drivers.getFirst());
    }

    public void bookDriver() {
        System.out.println("Please choose a destination (1-9)");
        for (int i = 0; i < districts.length; i++) {
            for (int j = 0; j < districts[i].length; j++) {
                System.out.println((i * 3 + j + 1) + ") " + districts[i][j]); //Printing destinations out by math
            }
        }
        Scanner scanner = new Scanner(System.in);
        try {

            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 9) {
                int districtNumber = ((choice - 1) / 3) + 1; //Finding the districtNumber by math
                String result = findDriver(districtNumber);
                System.out.println(result);
            } else {
                System.out.println("Invalid choice. Please try again.");
                bookDriver();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            bookDriver();
        }




       /* System.out.println("Please choose a destination (1-9)");
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


        */

    }

    private String findDriver(int districtNumber) {
        ArrayList<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            //Checking if a driver with the districtCoverage of the districtNumber exists
            for (int district : driver.districtCoverage) {
                if (district == districtNumber && !driver.isBooked) {
                    availableDrivers.add(driver);
                    break;
                }
            }
        }
        if (availableDrivers.isEmpty()) {
            return "No drivers available for districts " + districtNumber;
        }

        System.out.println("Available drivers: ");
        for (int i = 0; i < availableDrivers.size(); i++) {
            System.out.println((i + 1) + ") " + availableDrivers.get(i).toString());
        }

        System.out.println("Please choose a driver: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= availableDrivers.size()) {
                Driver chooeDriver = availableDrivers.get(choice - 1);
                chooeDriver.isBooked = true;
                return "Driver found and booked: " + chooeDriver.name;
            } else {
                System.out.println("Invalid choice. Please try again.");
                return findDriver(districtNumber);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            return findDriver(districtNumber);
        }
    }
}