package test;

import java.util.ArrayList;

public class Student {
    String Name;
    ArrayList<Grade> grades;

    public Student(String name, ArrayList<Grade> gradess) {
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(4);
        grades.add(5);
        Grade MathGrade = new Grade("Math", grades);
        Grade BELGrade = new Grade("BEL", grades);
        ArrayList<Grade> grade = new ArrayList<>();
        grade.add(MathGrade);
        grade.add(BELGrade);
        Name = name;
        this.grades = gradess;
    }


}
