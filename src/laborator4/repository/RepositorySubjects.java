package laborator4.repository;

import laborator4.domain.Subject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RepositorySubjects {
    ArrayList<Subject> subjects;

    public RepositorySubjects() {
        this.subjects = new ArrayList<Subject>();
    }

    public RepositorySubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public boolean findSubject(Subject subject) {
        for (Subject s : this.subjects)
            if (s.equals(subject))
                return true;
        return false;
    }

    public void readFromFile() {
        try {
            BufferedReader file =
                    new BufferedReader(
                            new FileReader(
                                    "C:\\Users\\emili\\IdeaProjects" +
                                            "\\MapLaboratoare\\src\\laborator4\\files\\subjects"));
            String line;
            while ((line = file.readLine()) != null) {
                String[] arguments = line.split(",");
                int id = Integer.parseInt(arguments[0]);
                String name = arguments[1];
                Subject subject = new Subject(id, name);
                if (!findSubject(subject))
                    addSubject(subject);
            }
        } catch (IOException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
