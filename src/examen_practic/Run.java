package examen_practic;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

    private static void afisareBruta(ArrayList<Alcool> a) {
        for (Alcool al : a)
            System.out.println(al);
    }

    private static void sortare(ArrayList<Alcool> alcools) {
        for (int i = 0; i < alcools.size() - 1; i++) {
            for (int j = i + 1; j < alcools.size(); j++) {
                int disponibileI = alcools.get(i).getStocInitial() - alcools.get(i).getVandute();
                int disponibileJ = alcools.get(j).getStocInitial() - alcools.get(j).getVandute();
                if (disponibileI * alcools.get(i).getPretUnit() < disponibileJ * alcools.get(j).getPretUnit()) {
                    Alcool a = new Alcool(alcools.get(i).getDenumire(),
                            alcools.get(i).getTip(),
                            alcools.get(i).getStocInitial(),
                            alcools.get(i).getPretUnit(),
                            alcools.get(i).getVandute());
                    Alcool b = new Alcool(alcools.get(j).getDenumire(),
                            alcools.get(j).getTip(),
                            alcools.get(j).getStocInitial(),
                            alcools.get(j).getPretUnit(),
                            alcools.get(j).getVandute());
                    alcools.remove(i);
                    alcools.add(i, b);
                    alcools.remove(j);
                    alcools.add(j, a);
                }
            }
        }
    }

    private static void tabel1(ArrayList<Alcool> alcools) {
        if (alcools.size() == 0)
            System.out.println("Nu sunt elemente de afisat!");
        else {
            sortare(alcools);
            int total = 0;
            Tabel.capTabel1();
            for (Alcool a : alcools) {
                int disponibile = a.getStocInitial() - a.getVandute();
                total += disponibile * a.getPretUnit();
                if (disponibile * a.getPretUnit() != 0)
                    System.out.format("|%-15s|%-10s|%13d|%9d|%10d\n",
                            a.getDenumire(),
                            a.getTip(),
                            disponibile,
                            a.getPretUnit(),
                            disponibile * a.getPretUnit());
            }
            System.out.println("TOTAL = " + total);
        }
    }

    public static void afisareTipuri(String tip1, String tip2, ArrayList<Alcool> alcools) {
        int stocInit1 = 0;
        int vandute1 = 0;
        int valoareVandute1 = 0;
        for (Alcool a : alcools) {
            if (a.getTip().compareTo(tip1) == 0) {
                stocInit1 += a.getStocInitial();
                vandute1 += a.getVandute();
                valoareVandute1 += a.getVandute() * a.getPretUnit();
            }
        }
        int stocInit2 = 0;
        int vandute2 = 0;
        int valoareVandute2 = 0;
        for (Alcool a : alcools) {
            if (a.getTip().compareTo(tip2) == 0) {
                stocInit2 += a.getStocInitial();
                vandute2 += a.getVandute();
                valoareVandute2 += a.getVandute() * a.getPretUnit();
            }
        }
        if (valoareVandute1 > valoareVandute2) {
            System.out.format("|%-10s|%10d|%10d|%10d\n",
                    tip2,
                    stocInit2,
                    vandute2,
                    valoareVandute2);
            System.out.format("|%-10s|%10d|%10d|%10d\n",
                    tip1,
                    stocInit1,
                    vandute1,
                    valoareVandute1);

        } else {
            System.out.format("|%-10s|%10d|%10d|%10d\n",
                    tip1,
                    stocInit1,
                    vandute1,
                    valoareVandute1);
            System.out.format("|%-10s|%10d|%10d|%10d\n",
                    tip2,
                    stocInit2,
                    vandute2,
                    valoareVandute2);
        }
        int total = valoareVandute1 + valoareVandute2;
        System.out.println("TOTAL = "+ total);
    }
    public static void tabel2(ArrayList<Alcool> alcools) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati primul tip:");
        String tip1 = scanner.nextLine();
        System.out.println("Dati al doilea tip:");
        String tip2 = scanner.nextLine();
        Tabel.capTabel2();
        afisareTipuri(tip1,tip2, alcools);
    }

    public static int citIntreg(String sir) {
        try {
            System.out.print(sir);
            Scanner s = new Scanner(System.in);
            return s.nextInt();
        } catch (Exception e) {
            System.out.println("Ai gresit, mai incearca!!");
            return citIntreg(sir);
        }
    }

    public static int meniu() {
        System.out.println();
        System.out.println("1. Citire date din fisier si afisare bruta");
        System.out.println("2. Tabel 1");
        System.out.println("3. Tabel 2");
        return citIntreg("da optiunea ta:");
    }


    public static void main(String[] args) {
        ArrayList<Alcool> multAlcool = new ArrayList<>();
        int opt = meniu();
        while (opt != 0) {
            switch (opt) {
                case 1:
                    multAlcool = CitireFisier.citireFisier();
                    afisareBruta(multAlcool);
                    break;
                case 2:
                    tabel1(multAlcool);
                    break;
                case 3:
                    tabel2(multAlcool);
                    break;
                default:
                    System.out.println("Optiune gresita, mai incearca!!");
            }
            opt = meniu();
        }
        System.out.println("La revedere");
    }
}
