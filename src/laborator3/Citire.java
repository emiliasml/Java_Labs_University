package laborator3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Citire {

    /**
     * citeste dintr-un fisier munti
     * fiecare linie contine cate un munte, care are numele si inaltimea despartite prin /
     *
     * @return un obiect de tip Munti
     */
    public static Munti citireDinFisier() {
        Munti munti = new Munti();
        try {
            BufferedReader fisier = new BufferedReader(new FileReader("C:\\Users\\emili\\" +
                    "IdeaProjects\\MapLaboratoare\\src\\laborator3\\FisierMunti"));
            String linie = fisier.readLine();
            while ((linie = fisier.readLine()) != null) {   //citesc linie cu linie
                String[] elemente = linie.split("/");   //despart linia in cuvinte

                String nume = elemente[0];  //primul element este numele
                long inaltime = Long.parseLong(elemente[1]);    //al doilea este inaltimea, care e long

                Munte m = new Munte(nume, inaltime);
                munti.adaugareMunte(m); //pun muntele in vectorul de munti
            }
            fisier.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return munti;
    }

    /**
     * citeste de la tastatura o linie cu mai multi munti
     * se citeste in formatul urmator:
     * numeMunte1,inaltimeMunte1;numeMunte2,inaltimeMunte2;...
     *
     * @return un obiect de tip Munti
     */
    public static Munti citireDeLaTastatura() {
        System.out.println("Dati muntii in formatul nuume1,inaltime1;nume2,inaltime2;...");
        Munti munti = new Munti();
        Scanner scanner = new Scanner(System.in);
        String linie = scanner.nextLine();
        String[] elemente = linie.split(";");
        //despart elementele fiecarui munte si le pun intr-un munte nou, pe care il adaug in vectorul de munti
        for (String el : elemente) {
            String[] numeSiInaltime = el.split(",");
            munti.adaugareMunte(new Munte(numeSiInaltime[0], Long.parseLong(numeSiInaltime[1])));
        }
        return munti;
    }

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
}
