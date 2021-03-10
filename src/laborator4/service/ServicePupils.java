package laborator4.service;

import laborator4.domain.Pupil;
import laborator4.repository.RepositoryPupils;

import java.util.ArrayList;
import java.util.Date;

public class ServicePupils {
    private RepositoryPupils repositoryPupils;

    public ServicePupils() {
    }

    public ServicePupils(RepositoryPupils repositoryPupils) {
        this.repositoryPupils = repositoryPupils;
    }

    public RepositoryPupils getRepositoryPupils() {
        return repositoryPupils;
    }

    public void readFromFileService() {
        repositoryPupils.readFromFile();
    }

    public ArrayList<Pupil> getAllPupils() {
        return repositoryPupils.getPupils();
    }

    public void addPupil(int id, String firstName, String lastName, Date birthDate){
        Pupil pupil = new Pupil(id, firstName, lastName, birthDate);
        repositoryPupils.addPupil(pupil);
    }

    public boolean deletePupil(int id){
        return repositoryPupils.delete(id);
    }
}
