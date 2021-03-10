package pregatire_examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    private static void afisareTabel1(ArrayList<Bijuterie> bijuterii) {
        Tabel.capTabel1();
        for(Bijuterie b: bijuterii)
        System.out.format("|%-17s|%-10s|%10d|%10d|%10d\n",
                b.getDenumire(),
                b.getTip(),
                b.getStocInitial()-b.getVandute(),
                b.getPretUnit(),
                (b.getStocInitial()-b.getVandute())*b.getPretUnit());
    }

    private static void afisareTabel2(ArrayList<Bijuterie> bijuterii) {
        Tabel.capTabel2();

    }

    public static int citIntreg(String sir) {
        try {
            System.out.print(sir);
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();
            return i;
        } catch (Exception e) {
            System.out.println("Ai gresit, mai incearca!!");
            return citIntreg(sir);
        }
    }

    public static int meniu() {
        System.out.println();
        System.out.println("1. Citire date din fisier");
        System.out.println("2. Tabel 1");
        System.out.println("3. Tabel 2");
        return citIntreg("da optiunea ta:");
    }

    public static void main(String[] args) {
        ArrayList<Bijuterie> bijuterii = new ArrayList<Bijuterie>();
        int opt = meniu();
        while (opt != 0) {
            switch (opt) {
                case 1:
                    bijuterii = CitireFisier.citireFisier();
                    break;
                case 2:
                    afisareTabel1(bijuterii);
                    break;
                case 3:
                    afisareTabel2(bijuterii);
                    break;

                default:
                    System.out.println("Optiune gresita, mai incearca!!");
            }
            opt = meniu();
        }
        System.out.println("La revedere ba");
    }
}