package Opgave4_Vaskeri;

import java.util.ArrayList;
import java.util.Scanner;

public class LaundryService {
    private ArrayList<LaundryMachine> machines;
    public LaundryService(){
        this.machines = new ArrayList<>();
    }
    public void addMachine(LaundryMachine laundryMachine){
        machines.add(laundryMachine);
    }
    public LaundryMachine chooseMachine(){
        if (machines.isEmpty()){
            System.out.println("No machines available.");
            return null;
        }
        System.out.println("Available machines:");
        for (int i = 0; i < machines.size(); i++) {
            System.out.println((i + 1) + ": " + machines.get(i).toString());
        }

        System.out.println("Please choose a machine to use: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice < 1 || choice > machines.size()){
            System.out.println("Invalid choice. Please choose again.");
            return chooseMachine();
        }

        LaundryMachine selectedMachine = machines.get(choice - 1);
        System.out.println("Selected machine " + selectedMachine.toString());
        return selectedMachine;
    }
}
