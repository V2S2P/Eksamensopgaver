package Opgave4_Vaskeri;

public class Main {
    public static void main(String[] args) {
        LaundryService laundryService = new LaundryService();

        laundryService.addMachine(new WashingMachine(5));
        laundryService.addMachine(new WashingMachine(7));
        laundryService.addMachine(new Dryer());

        LaundryMachine selectedMachine = laundryService.chooseMachine();
        selectedMachine.chooseProgram();

    }
}
