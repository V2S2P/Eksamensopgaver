package Opgave5_Chauffør;

public class Driver {
    //Information hiding would be making these instance variables private and only allowing access through getters and setters.
     String name;
     double rating;
     boolean isBooked;
     int[] districtCoverage;
    public Driver(String name,int[] destinationCoverage, double rating){
        this.name = name;
        this.isBooked = false;
        this.districtCoverage = destinationCoverage;
        this.rating = rating;
    }
    @Override
    public String toString(){
        return "\nName: " + name + "\nRating: " + rating;
    }
}
