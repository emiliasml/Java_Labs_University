package laborator4.service;

import laborator4.domain.Grade;
import laborator4.repository.RepositoryGrades;

import java.util.ArrayList;

public class ServiceGrades {
    private RepositoryGrades repositoryGrades;

    public ServiceGrades() {
    }

    public ServiceGrades(RepositoryGrades repositoryGrades) {
        this.repositoryGrades = repositoryGrades;
    }

    public RepositoryGrades getRepositoryGrades() {
        return repositoryGrades;
    }

    public void readFromFileService() {
        repositoryGrades.readFromFile();
    }

    public ArrayList<Grade> getAllGrades() {
        return repositoryGrades.getGrades();
    }

    public void addGrade(int id, int idSubject, int idPupil, float value) {
        Grade grade = new Grade(id, idSubject, idPupil, value);
        repositoryGrades.addGrade(grade);
    }

    public float getGeneralGrade(int id) {
        float gen = 0.0f;
        int number = 0;
        for (Grade g : repositoryGrades.getGrades())
            if (g.getIdPupil() == id) {
                gen += g.getValue();
                number++;
            }
        if (number == 0) return 0;
        return gen / number;
    }
}
