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
        double total = 0;

        System.out.println("Clothes");
        for (Product product : basket){
            if (product instanceof Clothes) { // Checks in the basket ArrayList if the product is of type "Clothes" class, if so it will print it out under the "Clothes" sout.
                System.out.println(product);
                total += product.getPrice();
            }
        }
        System.out.println("\nElectronics");
        for (Product product : basket){
            if (product instanceof Electronics){
                System.out.println(product);
                total += product.getPrice();
            }
        }
        System.out.println("\nFood");
        for (Product product : basket){
            if (product instanceof Food){
                System.out.println(product); // When using println, java implicitly checks for toString method and when you override toString it will just use that.
                total += product.getPrice();
            }
        }
        System.out.println("\nTotal: " + total);
    }
}
