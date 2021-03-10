package laborator4.repository;

import laborator4.domain.Grade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RepositoryGrades {
    private ArrayList<Grade> grades;

    public RepositoryGrades() {
        this.grades = new ArrayList<Grade>();
    }

    public RepositoryGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public boolean findGrade(Grade grade) {
        for (Grade g : this.grades)
            if (g.equals(grade))
                return true;
        return false;
    }

    public void readFromFile() {
        try {
            BufferedReader file = new BufferedReader(
                    new FileReader(
                            "C:\\Users\\emili\\IdeaProjects" +
                                    "\\MapLaboratoare\\src\\laborator4\\files\\grades"
                    )
            );
            String line;
            while ((line = file.readLine()) != null) {
                String[] args = line.split(",");
                int id = Integer.parseInt(args[0]);
                int idSubject = Integer.parseInt(args[1]);
                int idPupil = Integer.parseInt(args[2]);
                float value = Float.parseFloat(args[3]);
                Grade grade = new Grade(id, idSubject, idPupil, value);
                if (!findGrade(grade))
                    addGrade(grade);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
