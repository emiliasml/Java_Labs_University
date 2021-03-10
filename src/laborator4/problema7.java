package laborator4;

import laborator4.repository.RepositoryGrades;
import laborator4.repository.RepositoryPupils;
import laborator4.repository.RepositorySubjects;
import laborator4.service.ServiceGrades;
import laborator4.service.ServicePupils;
import laborator4.service.ServiceSubjects;
import laborator4.ui.Console;

public class problema7 {
    /*    7. Catalog clasă de liceu (parţial doar cu note, fără absenţe)
        Se cunosc informaţiile despre elevii unei clase (nume, data_naşterii, matricol, notele la fiecare materie).
        BD (sau ansamblu de fişiere/tabele în memorie) .

        Se cere soft operaţii CRUD (Create/Read/Update/Delete)şi pentru:
                - clasamentul elevilor după media generală (descrescător după medie);
    - un tabel cu elevii corigenţi pe toamnă şi disciplinele la care nu au promovat;
    - câte un tabel pentru fiecare disciplină în ordinea descrescătoare a mediilor;
    - un tabel cu elevii în ordinea descrescătoare a vârstei.
        Deduceţi de ce clase aveţi nevoie!!!
    */

  public static void main(String[] args) {
    RepositoryPupils repositoryPupils = new RepositoryPupils();
    RepositorySubjects repositorySubjects = new RepositorySubjects();
    RepositoryGrades repositoryGrades = new RepositoryGrades();
    ServicePupils servicePupils = new ServicePupils(repositoryPupils);
    ServiceSubjects serviceSubjects = new ServiceSubjects(repositorySubjects);
    ServiceGrades serviceGrades = new ServiceGrades(repositoryGrades);
    Console.mainUI(servicePupils, serviceSubjects, serviceGrades);
  }
}
