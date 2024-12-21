package Opgave5_Chauffør;

public class Main {
    public static void main(String[] args) {
        RickshawService rickshawService = new RickshawService();
        int[] districts = new int[]{1,3};
        rickshawService.createDriver("Valdemar", districts);
        rickshawService.bookDriver();
    }
}
