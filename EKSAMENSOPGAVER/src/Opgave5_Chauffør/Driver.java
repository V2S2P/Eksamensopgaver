package Opgave5_Chauffør;

public class Driver {
     String name;
     boolean isBooked;
     int[] districtCoverage;
    public Driver(String name,int[] destinationCoverage){
        this.name = name;
        this.isBooked = false;
        this.districtCoverage = destinationCoverage;
    }
}
