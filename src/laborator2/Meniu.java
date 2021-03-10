package laborator2;

import java.util.Scanner;

public class Meniu {
    private static void afisareMeniu() {
        System.out.println("--Meniu--");
        System.out.println("1. Citire colectii");
        System.out.println("2. Afisare colectii citite");
        System.out.println("3. Reuniune");
        System.out.println("4. Intersectie");
        System.out.println("5. Afisare colectia cea mai lunga ");
        System.out.println("6. Afisare nr colectii citite");
        System.out.println("0. Iesire");
    }

    public static int citireOptiune() {
        System.out.print("\n--Alegeti o optiune:");
        try {
            Scanner scn = new Scanner(System.in);
            return scn.nextInt();
        } catch (Exception exp) {
            System.out.println("Ai gresit! Da numar intreg!");
            return citireOptiune();                //apel recursiv pana se citeste un nr bun
        }
    }

    private static void afisareElemente(Colectie c) {
        if (c.dimensiune() == 0) System.out.print("\n Nu sunt elemente de afisat!");
        else {
            System.out.println();
            for (int el : c.elementeColectie()) //afisez fiecare element din colectie daca exista
                System.out.print(el + " ");
        }
    }

    //citeste un sir de numere intregi si returneaza un vector care contine pe prima pozitie numarul colectiilor
    //colectiile sunt separate prin -1
    private static int[] citire() {
        int[] vector = new int[200];       //declar un vector pentru toate numerele care urmeaza a fi citite
        int lungime = 1;                   //setez lungimea lui cu 1 pt ca pe prima pozitie retin numarul colectiilor
        int nr = -1;                       //numarul colectiilor ->pe el il pun pe pozitia 0
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dati un element sau -1 ca sa opriti citirea:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        vector[lungime] = a;
        lungime++;
        while (b != -1 || a != -1) {    //citirea se opreste cand intalnesc doi de -1
            vector[lungime] = b;
            lungime++;
            a = b;
            b = scanner.nextInt();
            if (b == -1) nr++;      //o colectie se termina cu -1
        }
        vector[0] = nr;     //pun pe prima pozitie numarul colectiilor citite
        int[] cop = new int[lungime];
        for (int i = 0; i < lungime; i++)       //creez un vector doar cu elementele colectiilor, despartite de -1
            cop[i] = vector[i];
        return cop;
    }


    //transforma un vector intr-un vector de Colectii
    private static Colectie[] transformareInColectii(int[] vector) {
        int lung = vector[0];
        Colectie[] colectii = new Colectie[lung];   // am declarat de la inceput numarul exact de colectii citite
        colectii[0] = new Colectie();
        int index = 0;
        for (int i = 1; i < vector.length - 1; i++) {   //adaug elementele in colectii
            if (vector[i] != -1) colectii[index].adaugareElement(vector[i]);    //daca elementul nu e -1,
            if (vector[i] == -1) {                                              //il adaug in colectie
                index++;        //daca elementul e -1, trec la colectie noua
                colectii[index] = new Colectie();
            }
        }
        return colectii;
    }

    //returneaza cea mai lunga colectie dintr-un vector de colectii
    private static Colectie ceaMaiLungaColectie(Colectie[] colectii) {
        int max = colectii[0].dimensiune();
        int pozitie = 0;
        for (int i = 0; i < colectii.length; i++)
            if (colectii[i].dimensiune() > max) {
                max = colectii[i].dimensiune();
                pozitie = i;
            }
        return colectii[pozitie];
    }

    //returneaza reuniunea mai multor colectii date
    private static Colectie reuniune(Colectie[] colectii) {
        Colectie reun = new Colectie();
        for (Colectie c : colectii)
            for (int el : c.elementeColectie()) {
                reun.adaugareElement(el);
            }
        return reun;
    }

    //returneaza intersectia a 2 colectii date
    private static Colectie intersectie2Colectii(Colectie c1, Colectie c2) {
        Colectie inters = new Colectie();
        for (int elem : c1.elementeColectie()) {
            int nrAparitiiC1 = c1.numarAparitiiElement(elem);
            int nrAparitiiC2 = c2.numarAparitiiElement(elem);
            int nrAparitiiIntersectie = inters.numarAparitiiElement(elem);
            while (nrAparitiiC1 > nrAparitiiIntersectie &&
                    nrAparitiiC2 > nrAparitiiIntersectie) {
                inters.adaugareElement(elem);
                nrAparitiiIntersectie++;
            }
        }
        return inters;
    }

    //returneaza intersectia mai multor colectii date
    private static Colectie intersectie(Colectie[] colectii) {
        Colectie inters = colectii[0];
        for (int i = 0; i < colectii.length; i++)
            inters = intersectie2Colectii(inters, colectii[i]);    //colectiile le iau 2 cate 2
        return inters;
    }

    //citire pe aceeasi linie
    private static String citirePeAceeasiLinie() {
        String linie = "";
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        while (a != -1 || b != -1) {
            linie += a;
            linie += " ";
            a = b;
            b = scanner.nextInt();
        }
        return linie;
    }

    private static int[] transformareInVector(String linie) {
        String[] str = linie.split(" ");
        int[] vector = new int[str.length + 2];
        int nr = 1;
        for (int i = 1; i <= str.length; i++) {
            vector[i] = Integer.parseInt(str[i - 1]);
            if (vector[i] == -1) nr++;
        }
        vector[0] = nr;
        vector[str.length + 1] = -1;
        return vector;
    }

    //problema 5
    public static void main(String[] args) {

        afisareMeniu();
        int op = citireOptiune();
        Colectie[] colectii = transformareInColectii(transformareInVector(citirePeAceeasiLinie()));
        while (op != 0) {
            switch (op) {
                case 2://afisare colectii
                    System.out.print("Colectiile citite sunt:");
                    for (Colectie col : colectii)
                        afisareElemente(col);
                    break;
                case 3://reuniunea colectiilor
                    System.out.print("Reuniunea colectiilor:");
                    afisareElemente(reuniune(colectii));
                    break;
                case 4:// intersectia colectiilor
                    System.out.print("Intersectia colectiilor:");
                    afisareElemente(intersectie(colectii));
                    break;
                case 5://afisare colectia cea mai lunga
                    System.out.print("Colectia cea mai lunga este:");
                    afisareElemente(ceaMaiLungaColectie(colectii));
                    break;
                case 6:// afisare nr colectii citite
                    System.out.print("Nr colectii citite=" + colectii.length);
                    break;
                case 10:
                    afisareMeniu();
                default:
                    System.out.println("\nApasa 10 pentru informatii");
            }
            op = citireOptiune();
        }
    }
}