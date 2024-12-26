package Opgave3_Akademiet;

public class Main {
    public static void main(String[] args) {
        Academy academy = new Academy("Hogwarts");

        Course DATDA = new Course("D.A.T.D.A");
        Course PotionMaking = new Course("PotionMaking");
        Course Charms = new Course("Charms");

        academy.addCourse(DATDA);
        academy.addCourse(PotionMaking);
        academy.addCourse(Charms);

        Student Harry = new Student("Harry");
        Student Ron = new Student("Ron");
        Student Hermione = new Student("Hermione");
        Student Hagrid = new Student("Hagrid");

        Harry.addCourse(DATDA, 12);
        Harry.addCourse(PotionMaking, 12);
        Harry.addCourse(DATDA, 12);

        Ron.addCourse(Charms, 4);
        Ron.addCourse(DATDA, 7);

        Hermione.addCourse(DATDA, 10);
        Hermione.addCourse(PotionMaking, 12);
        Hermione.addCourse(Charms, 12);

        Hagrid.addCourse(DATDA,3);
        Hagrid.addCourse(PotionMaking,2);
        Hagrid.addCourse(Charms,12);

        academy.printDiploma(Harry);
        academy.printDiploma(Hermione);
        academy.printDiploma(Ron);
        academy.printDiploma(Hagrid);

        academy.addStudent(Harry);
        academy.addStudent(Hermione);
        academy.addStudent(Ron);
        academy.addStudent(Hagrid);


        //System.out.println(academy.getHighest(2));
        System.out.println(academy.getLowest(2));
    }
}
