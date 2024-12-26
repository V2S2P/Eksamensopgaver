package Opgave4_Vaskeri;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dryer implements LaundryMachine{
    private int duration;
    private double price;
    public Dryer(){
        this.duration = 0;
        this.price = 0;
    }
    @Override
    public void chooseProgram() {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("1) Lav varme");
        menu.add("2) Høj varme");

        for (String s : menu) {
            System.out.println(s);
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lav varme valgt");
                    this.duration = 30;
                    this.price = this.duration * 0.5;
                    addExtra();
                    break;
                case 2:
                    System.out.println("Høj varme valgt");
                    this.duration = 30;
                    this.price = this.duration * 0.5;
                    addExtra();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    return;
            }
            //displayPriceAndDuration();
            start();
        }catch (InputMismatchException e){
            System.out.println("Invalid input.");
            chooseProgram();
        }
    }

    @Override
    public void displayPriceAndDuration() {
        System.out.println("The price is " + this.price + " kr and the duration is " + this.duration + " minutes.");
    }

    @Override
    public void start() {
        System.out.println("The machine is now running..");
        addExtra();
    }

    @Override
    public void addExtra() {
        System.out.println("Do you want to add an extra 10 minutes for same minute price? Y/N");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")){
            int durationAdded = this.duration += 10;
            System.out.println("You have added an extra 10 minutes to your time: " + durationAdded + " minutes.");
            this.price = durationAdded * 0.5;
            addExtra();
        } else if (choice.equalsIgnoreCase("N")) {
            int durationTotal = this.duration;
            //System.out.println("Machine is starting, current minute total is: " + durationTotal + " minutes.");
            System.out.println("The price is " + this.price + " kr and the duration is " + this.duration + " minutes.");
            this.price = durationTotal * 0.5;
            //this.duration -= 10;
        }else {
            System.out.println("Invalid character entered. Please try again.");
        }
    }
    @Override
    public String toString(){
        return "Dryer";
    }
}
