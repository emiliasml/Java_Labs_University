package laborator4.ui;

import laborator4.domain.Grade;
import laborator4.domain.Pupil;
import laborator4.domain.Subject;
import laborator4.repository.RepositoryGrades;
import laborator4.repository.RepositoryPupils;
import laborator4.repository.RepositorySubjects;
import laborator4.service.Service;
import laborator4.service.ServiceGrades;
import laborator4.service.ServicePupils;
import laborator4.service.ServiceSubjects;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Console {

    /**
     * citeste un numar intreg si il returneaza
     **/
    public static int citireIntreg(String sir) {
        try {
            System.out.print(sir);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception E) {
            System.out.println("Numar gresit!");
            return citireIntreg(sir);
        }
    }

    public static int showMenu() {
        System.out.println("--Meniu--");
        System.out.println("- Elevi");
        System.out.println("    11. Citire elevi din fisier");
        System.out.println("    12. Citire elevi de la tastatura");
        System.out.println("    13. Afisare elevi");
        System.out.println("    14. Stergere elev");
        //TODO: stergere elev, materie,
        System.out.println("- Materii");
        System.out.println("    21. Citire materii din fisier");
        System.out.println("    22. Citire materii de la tastatura");
        System.out.println("    23. Afisare materii");
        System.out.println("- Note");
        System.out.println("    31. Citire note din fisier");
        System.out.println("    32. Citire note de la tastatura");
        System.out.println("    33. Afisare note");
        System.out.println("4. Clasamentul elevilor dupa media generala");
        System.out.println("5. Elevii corigenti");
        System.out.println("6. Elevi in ordine descrescatoare a varstei");
        System.out.println("0. Iesire");
        return citireIntreg("Alege o optiune:");
    }


    public static void readFromFilePupils(ServicePupils servicePupils) {
        servicePupils.readFromFileService();
        for (Pupil p : servicePupils.getAllPupils())
            System.out.println(p);
    }

    public static void readFromFileSubjects(ServiceSubjects serviceSubjects) {
        serviceSubjects.readFromFileService();
        for (Subject s : serviceSubjects.getAllSubjects())
            System.out.println(s);
    }

    public static void readFromFileGrades(ServiceGrades serviceGrades) {
        serviceGrades.readFromFileService();
        for (Grade g : serviceGrades.getAllGrades())
            System.out.println(g);
    }

    public static void readPupilFromKeyboard(ServicePupils servicePupils) {
        System.out.print("Dati id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.print("Dati prenumele:");
        String firstName = scanner.nextLine();
        firstName = scanner.nextLine();
        System.out.print("Dati numele:");
        String lastName = scanner.nextLine();
        System.out.print("Dati data nasterii(dd/mm/yyyy):");
        try {
            Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            servicePupils.addPupil(id, firstName, lastName, birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void readSubjectFromKeyboard(ServiceSubjects serviceSubjects) {
        System.out.print("Dati id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.print("Dati numele materiei:");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        serviceSubjects.addSubject(id, name);
    }

    public static void readGradeFromKeyboard(ServiceGrades serviceGrades) {
        System.out.print("Dati id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.print("Dati id-ul materiei:");
        int idSubject = scanner.nextInt();
        System.out.print("Dati id-ul elevului:");
        int idPupil = scanner.nextInt();
        System.out.print("Dati valoarea notei:");
        float value = scanner.nextFloat();
        //TODO verifica daca exista idurile si daca nota e valabila
        serviceGrades.addGrade(id, idSubject, idPupil, value);
    }

    public static void deletePupil(ServicePupils servicePupils){
        System.out.println("Dati id-ul elevului pe care vreti sa il stergeti:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(servicePupils.deletePupil(id))
            System.out.println("Stergere cu succes!");
        else
            System.out.println("Id-ul nu a fost gasit!");
    }

    //sorteaza si returneaza o lista de elevi in ordine desc a mediei generale
    public static ArrayList<Pupil> sortPupilsByGrades(ServiceGrades serviceGrades, ServicePupils servicePupils) {
        ArrayList<Pupil> pupils = servicePupils.getAllPupils();
        for (int i = 0; i < pupils.size() - 1; i++)
            for (int j = i + 1; j < pupils.size(); j++) {
                if (serviceGrades.getGeneralGrade(pupils.get(i).getId()) <
                        serviceGrades.getGeneralGrade(pupils.get(j).getId()))
                    pupils.get(i).switchPupils(pupils.get(j));
            }
        return pupils;
    }

    //afiseaza o lista de elevi cu id, numele si media lor generala sub forma de tabel
    public static void printPupils(ArrayList<Pupil> pupils, ServiceGrades serviceGrades) {
        CapTabel.capTabel2();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (Pupil p : pupils)
            System.out.format("|%10d|%10s|%14s|\n",
                    p.getId(),
                    p.getLastName(),
                    df.format(serviceGrades.getGeneralGrade(p.getId())));
    }

    //tabel cu elevii corigenti si materiile la care nu au promovat
    public static void failures(ServicePupils servicePupils, ServiceSubjects serviceSubjects, ServiceGrades serviceGrades) {
        CapTabel.capTabel3();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (Pupil pupil : servicePupils.getAllPupils()) {
            for (Subject subject : serviceSubjects.getAllSubjects()) {
                float gen = 0.0f;
                int number = 0;
                for (Grade grade : serviceGrades.getAllGrades()) {
                    if (grade.getIdPupil() == pupil.getId()
                            && grade.getIdSubject() == subject.getId()) {
                        gen += grade.getValue();
                        number++;
                    }
                }
                if (number != 0)
                    if (gen / number < 5)
                        System.out.format("|%10d|%10s|%10s|%7s|\n",
                                pupil.getId(),
                                pupil.getLastName(),
                                subject.getName(),
                                df.format(gen / number));
            }
        }
    }

    public static ArrayList<Pupil> sortAge(ServicePupils servicePupils){
        ArrayList<Pupil> pupils = servicePupils.getAllPupils();
        for (int i = 0; i < pupils.size() - 1; i++) {
            for (int j = i + 1; j < pupils.size(); j++) {
                if (pupils.get(i).getBirthDate().compareTo(
                        pupils.get(j).getBirthDate()) > 0)
                    pupils.get(i).switchPupils(
                            pupils.get(j));
            }
        }
        return pupils;
    }

    public static void sortByAge(ServicePupils servicePupils) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Pupil> pupils = sortAge(servicePupils);
        CapTabel.capTabel4();
        for (Pupil p : pupils) {
            String theDay = new SimpleDateFormat("dd/MM/yyyy").format(p.getBirthDate());
            System.out.format("|%10d|%10s|%14s|\n",
                    p.getId(),
                    p.getLastName(),
                    theDay);
        }
    }

    public static void showTablePupils(ServicePupils servicePupils){
        CapTabel.capTabelElevi();
        for (Pupil p : servicePupils.getAllPupils()) {
            String theDay = new SimpleDateFormat("dd/MM/yyyy").format(p.getBirthDate());
            System.out.format("|%10d|%10s|%10s|%15s|\n",
                    p.getId(),
                    p.getLastName(),
                    p.getFirstName(),
                    theDay);
        }
    }

    public static void showTableSubjects(ServiceSubjects serviceSubjects){
        CapTabel.capTabelMaterii();
        for(Subject s: serviceSubjects.getAllSubjects())
            System.out.format("|%10d|%20s|\n",
                    s.getId(),
                    s.getName());
    }

    public static void showTableGrades(ServiceGrades serviceGrades){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        CapTabel.capTabelNote();
        for(Grade g: serviceGrades.getAllGrades())
            System.out.format("|%7d|%10d|%10d|%10s|\n",
                    g.getId(),
                    g.getIdPupil(),
                    g.getIdSubject(),
                    df.format(g.getValue()));
    }

    public static void mainUI(ServicePupils servicePupils, ServiceSubjects serviceSubjects, ServiceGrades serviceGrades) {
        int opt = showMenu();
        while (opt != 0) {
            switch (opt) {
                case 11:
                    readFromFilePupils(servicePupils);
                    break;
                case 12:
                    readPupilFromKeyboard(servicePupils);
                    break;
                case 13:
                    showTablePupils(servicePupils);
                    break;
                case 14:
                    deletePupil(servicePupils);
                    break;
                case 21:
                    readFromFileSubjects(serviceSubjects);
                    break;
                case 22:
                    readSubjectFromKeyboard(serviceSubjects);
                    break;
                case 23:
                    showTableSubjects(serviceSubjects);
                    break;
                case 31:
                    readFromFileGrades(serviceGrades);
                    break;
                case 32:
                    readGradeFromKeyboard(serviceGrades);
                    break;
                case 33:
                    showTableGrades(serviceGrades);
                    break;
                case 4:
                    printPupils(sortPupilsByGrades(serviceGrades, servicePupils), serviceGrades);
                    break;
                case 5:
                    failures(servicePupils, serviceSubjects, serviceGrades);
                    break;
                case 6:
                    sortByAge(servicePupils);
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
            opt = showMenu();
        }
    }
}
