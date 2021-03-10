package laborator4.service;

import laborator4.domain.Subject;
import laborator4.repository.RepositorySubjects;

import java.util.ArrayList;

public class ServiceSubjects {
    private RepositorySubjects repositorySubjects;

    public ServiceSubjects() {
    }

    public ServiceSubjects(RepositorySubjects repositorySubjects) {
        this.repositorySubjects = repositorySubjects;
    }

    public RepositorySubjects getRepositorySubjects() {
        return repositorySubjects;
    }

    public void readFromFileService() {
        repositorySubjects.readFromFile();
    }
    public ArrayList<Subject> getAllSubjects(){
        return repositorySubjects.getSubjects();
    }
    public void addSubject(int id, String name){
        Subject subject = new Subject(id,name);
        repositorySubjects.addSubject(subject);
    }
}
