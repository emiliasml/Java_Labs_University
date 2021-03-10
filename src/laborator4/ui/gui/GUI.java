package laborator4.ui.gui;

import laborator4.repository.RepositoryGrades;
import laborator4.repository.RepositoryPupils;
import laborator4.repository.RepositorySubjects;
import laborator4.service.ServiceGrades;
import laborator4.service.ServicePupils;
import laborator4.service.ServiceSubjects;

import java.awt.*;

public class GUI extends Frame {

    public GUI(ServicePupils servicePupils, ServiceSubjects serviceSubjects, ServiceGrades serviceGrades) {
        new ListExample(servicePupils, serviceSubjects, serviceGrades);
    }

    public static void main(String[] args) {
        RepositoryPupils repositoryPupils = new RepositoryPupils();
        RepositorySubjects repositorySubjects = new RepositorySubjects();
        RepositoryGrades repositoryGrades = new RepositoryGrades();
        ServicePupils servicePupils = new ServicePupils(repositoryPupils);
        ServiceSubjects serviceSubjects = new ServiceSubjects(repositorySubjects);
        ServiceGrades serviceGrades = new ServiceGrades(repositoryGrades);

        GUI f = new GUI(servicePupils, serviceSubjects, serviceGrades);
    }
}
