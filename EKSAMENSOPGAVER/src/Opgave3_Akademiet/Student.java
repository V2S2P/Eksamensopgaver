package Opgave3_Akademiet;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Integer> grades;
    public Student(String name){
        this.name = name;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    public boolean addCourse(Course course, int grade){
        if (courses.contains(course)){
            System.out.println(name + " is currently studying or has already passed " + course);
            return false;
        }
        if (!isValidGrade(grade)){
            return false;
        }

        courses.add(course);
        grades.add(grade);

        return true;
    }
    public boolean isValidGrade(int grade){
        int[] validGrades = {-3,0,2,4,7,10,12};
        for (int valid : validGrades){
            if(grade==valid){
                return true;
            }
        }
        return false;
    }
    public double calculateGradesAverage(){
        if (grades.isEmpty()){
            return 0.0;
        }
        int total = 0;
        for (int grade : grades){
            total += grade;
        }
        return (double) total / grades.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        String result = name + "\n";

        for (int i = 0; i < courses.size(); i++) {
            result += courses.get(i).getName() + ": " + grades.get(i) + "\n";
        }

        result += "Gennemsnit: " + calculateGradesAverage() + "\n";

        return result;
    }
}
