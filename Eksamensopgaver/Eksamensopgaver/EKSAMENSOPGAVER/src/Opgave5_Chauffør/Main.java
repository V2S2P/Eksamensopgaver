package Opgave5_Chauffør;

public class Main {
    public static void main(String[] args) {

        RickshawService rickshawService = new RickshawService();
        int[] districts = new int[]{1,3};
        int[] districts1 = new int[]{1,2};
        int[] districts2 = new int[]{3};
        rickshawService.createDriver("Valdemar", districts, 2.7);
        rickshawService.createDriver("Oliver",districts1,5.0);
        rickshawService.createDriver("Big Hank",districts2,5.0);
        rickshawService.bookDriver();



    }
}
