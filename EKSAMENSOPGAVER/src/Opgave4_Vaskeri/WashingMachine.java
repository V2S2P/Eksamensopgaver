package Opgave4_Vaskeri;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WashingMachine implements LaundryMachine{
    private int duration;
    private double price;
    private boolean isRunning;
    private int capacity;
    public WashingMachine(int capacity){
        if (capacity == 5 || capacity == 7){
            this.capacity = capacity;
        }else {
            throw new IllegalArgumentException("Invalid capacity. Must be 5kg or 7kg.");
            //System.out.println("WashingMachine can only be made with a capacity of 5kg or 7kg versions");
        }
        this.price = 0;
        this.duration = 0;
        this.isRunning = false;
    }
    @Override
    public void chooseProgram(){
        ArrayList<String> menu = new ArrayList<>();
        menu.add("1) Uld og silke (30 minutes)");
        menu.add("2) Bomuld 40 (50 minutes)");
        menu.add("3) Bomuld 60 (60 minutes)");

        for (String s : menu) {
            System.out.println(s);
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 3){
            System.out.println("Invalid choice. Please try again.");
            chooseProgram();
        }

        switch (choice) {
            case 1:
                System.out.println("Uld og Silke valgt");
                this.duration = 30;
                this.price = capacity * 1.2;
                addExtra();
                break;
            case 2:
                System.out.println("Bomuld 40 valgt");
                this.duration = 50;
                this.price = capacity * 1.2;
                addExtra();
                break;
            case 3:
                System.out.println("Bomuld 60 valgt");
                this.duration = 60;
                this.price = capacity * 1.2;
                addExtra();
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                return;
        }
        displayPriceAndDuration();
        start();
        addExtra();
    }
    @Override
    public void displayPriceAndDuration(){
        System.out.println("The price is " + this.price + " kr and the duration is " + this.duration + " minutes.");
    }

    @Override
    public void start() {
        System.out.println("The machine is now running..");
        this.isRunning = true;
        System.out.println(this.isRunning);
    }

    @Override
    public void addExtra() {
        System.out.println("Pre-washing costs an extra 5kr. Do you want to pre-wash? Y/N");
        Scanner scanner = new Scanner(System.in);

        if (isRunning) {
            System.out.println("You cannot do pre-wash when the machine is already running.");
            return;
        }
        while (true) {
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Pre-washing now..");
                this.price += 5;
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("No pre-washing chosen.");
                break;
            } else {
                System.out.println("Invalid character entered. Please try again.");
            }
        }
    }
    public int getCapacity(){
        return capacity;
    }
    @Override
    public String toString(){
        return "Washing Machine (" + capacity + ")" + "kg";
    }
}
