package Opgave1_IndkøbksKurven;

import java.util.ArrayList;

public class Basket {
    ArrayList<Product> basket;
    public Basket(){
        this.basket = new ArrayList<>();
    }
    public void addProduct(Product product){
        basket.add(product);
    }
    public void printAll(){
        double clothesTotal = 0;
        double electronicTotal = 0;
        double foodTotal = 0;

        System.out.println("Clothes");
        for (Product product : basket){
            if (product instanceof Clothes) { // Checks in the basket ArrayList if the product is of type "Clothes" class, if so it will print it out under the "Clothes" sout.
                System.out.println(product);
                clothesTotal += product.getPrice();
            }
        }
        System.out.println("\nTotal: " + clothesTotal);


        System.out.println("\nElectronics");
        for (Product product : basket){
            if (product instanceof Electronics){
                System.out.println(product);
                electronicTotal += product.getPrice();
            }
        }
        System.out.println("\nTotal: " + electronicTotal);


        System.out.println("\nFood");
        for (Product product : basket){
            if (product instanceof Food){
                System.out.println(product); // When using println, java implicitly checks for toString method and when you override toString it will just use that.
                foodTotal += product.getPrice();
            }
        }
        System.out.println("\nTotal: " + foodTotal);

        System.out.println("\nTotal: " + (clothesTotal + electronicTotal + foodTotal));
    }
}
