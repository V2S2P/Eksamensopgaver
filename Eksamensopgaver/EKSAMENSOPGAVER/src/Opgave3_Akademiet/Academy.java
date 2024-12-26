package Opgave3_Akademiet;

import java.util.ArrayList;
import java.util.List;

public class Academy {
    private String name;
    private List<Course> courses;
    private List<Student> students;
    public Academy(String name){
        this.name = name;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student){
       students.add(student);
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void printDiploma(Student student){
        System.out.println(student.toString());
    }
    public String getHighest(int amount){
        ArrayList<Student> highestGradeStudents = new ArrayList<>();

        for (Student student : students){
            double currentAverage = student.calculateGradesAverage();
            if (highestGradeStudents.size() < amount){
                highestGradeStudents.add(student);
            }else {
                int minIndex = 0;
                double minAverage = highestGradeStudents.get(0).calculateGradesAverage();
                for (int i = 0; i < highestGradeStudents.size(); i++) {
                    double average = highestGradeStudents.get(i).calculateGradesAverage();
                    if (average < minAverage){
                        minAverage = average;
                        minIndex = i;
                    }
                }
                if (currentAverage > minAverage){
                    highestGradeStudents.set(minIndex, student);
                }
            }
        }
        String result = "De " + amount + " bedste studerende:\n";
        for (Student student : highestGradeStudents){
            result += student.toString() + "\n";
        }
        return result;
    }
    public String getLowest(int amount){
        ArrayList<Student> lowestGradeStudents = new ArrayList<>();

        for (Student student : students){
            double currentAverage = student.calculateGradesAverage();
            if (lowestGradeStudents.size() < amount){
                lowestGradeStudents.add(student);
            }else {

                int minIndex = 0;
                double minAverage = lowestGradeStudents.get(0).calculateGradesAverage();
                for (int i = 0; i < lowestGradeStudents.size(); i++) {
                    double average = lowestGradeStudents.get(i).calculateGradesAverage();
                    if (average > minAverage){
                        minAverage = average;
                        minIndex = i;
                    }
                }
                if (currentAverage < minAverage){
                    lowestGradeStudents.set(minIndex, student);
                }
            }
        }
        String result = "De " + amount + " værste studerende:\n";
        for (Student student : lowestGradeStudents){
            result += student.toString() + "\n";
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }
}
