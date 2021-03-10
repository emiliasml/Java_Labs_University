package laborator4.service;

import laborator4.domain.Pupil;
import laborator4.repository.RepositoryPupils;

import java.util.ArrayList;

public class Service {
    private RepositoryPupils repository;

    public Service(RepositoryPupils repository) {
        this.repository = repository;
    }

    public ArrayList<Pupil> sortByAverageGrades(RepositoryPupils repository) {
        ArrayList<Pupil> pupils = repository.getPupils();
        for (int i = 0; i < pupils.size() - 1; i++)
            for (int j = i + 1; j < pupils.size(); j++)
                /*if (repository.averageGrade(pupils.get(i)) >
                        repository.averageGrade(pupils.get(j)))*/
                    pupils.get(i).switchPupils(pupils.get(j));
        return pupils;
    }

    public ArrayList<Pupil> sortByAge(RepositoryPupils repository) {
        ArrayList<Pupil> pupils = repository.getPupils();
        for (int i = 0; i < pupils.size() - 1; i++)
            for (int j = i + 1; j < pupils.size(); j++)
                if (repository.pupilAtIndex(i).getBirthDate().compareTo(
                        repository.pupilAtIndex(j).getBirthDate()) > 0)
                    repository.pupilAtIndex(i).switchPupils(repository.pupilAtIndex(j));
        return pupils;
    }


    public RepositoryPupils getRepository() {
        return repository;
    }

    public void setRepository(RepositoryPupils repository) {
        this.repository = repository;
    }
}
