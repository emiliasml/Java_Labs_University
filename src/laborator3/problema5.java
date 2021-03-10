package laborator3;

/*Rezolvaţi problema B folosind un TAD (Tip Abstract de Date)
        menţionat de A (în JAVA) . Se rezolvă problema folosind un meniu
        consolă !!!! Se cer obligatoriu comentarii. Datele se vor citi de la
        tastatură sau din fişier (ambele opţiuni obligatorii). Una (doar una !!!)
        din cele două sortări se va face cu comparator (de la cursul de
        Structuri de date şi algoritmi)*/

import java.text.DecimalFormat;

public class problema5 {
    public static int afisareMeniu() {
        System.out.println("--Meniu--");
        System.out.println("1. Citire din fisier");
        System.out.println("2. Citire de la tastatura");
        System.out.println("3. Afisare completa");
        System.out.println("4. Sortare alfabetica dupa nume");
        System.out.println("5. Sortare descrescatoare dupa inaltime");
        System.out.println("0. Iesire");
        return Citire.citireIntreg("Alege o optiune:");
    }

    /**
     * afisare elemente din obiectul munti fara sa fie modificate
     * sub forma de tabel
     */
    public static void afisareTabel(Munti munti) {
        Tabel.capTabel1();
        for (Munte m : munti.getMunti())
            System.out.format("|%-17s|%10d|\n", m.getNume(), m.getInaltime());    //afisare formatata
    }

    /**
     * afisare munti dupa ce au fost sortati alfabetic in functie de nume
     */
    public static void afisareTabel1(Munti munti) {
        Tabel.capTabel1();
        Sortari.sortareNumeAlfabetic(munti);
        for (Munte m : munti.getMunti())
            System.out.format("|%-17s|%10d|\n", m.getNume(), m.getInaltime());    //afisare formatata
    }

    /**
     * afisare munti dupa ce au fost sortati descrescator in functie de inaltime
     * la care se adauga coloana "procent din inaltime maxima"
     */
    public static void afisareTabel2(Munti munti) {
        Tabel.capTabel2();
        Sortari.sortareInaltimicrescator(munti);
        long maxim = munti.inaltimeMaxima();
        for (Munte m : munti.getMunti()) {
            //DecimalFormat df = new DecimalFormat("#.##");    //vreau doar 2 zecimale la procent
            float procent = (float) m.getInaltime() * 100 / maxim;
            //String format = df.format(procent);
            System.out.format("|%-14s|%8d|%20.2f\n", m.getNume(), m.getInaltime(), procent);
        }
    }

    public static void main(String[] args) {
        Munti munti = new Munti();
        int optiune = afisareMeniu();
        while (optiune != 0) {
            switch (optiune) {
                case 1:
                    munti.adaugareMunti(Citire.citireDinFisier());
                    break;
                case 2:
                    munti.adaugareMunti(Citire.citireDeLaTastatura());
                    break;
                case 3:
                    if (munti.getNumarElemente() == 0)
                        System.out.println("Nu sunt munti de afisat!");
                    else afisareTabel(munti);
                    break;
                case 4:
                    if (munti.getNumarElemente() == 0)
                        System.out.println("Nu sunt munti de afisat!");
                    else afisareTabel1(munti);
                    break;
                case 5:
                    if (munti.getNumarElemente() == 0)
                        System.out.println("Nu sunt munti de afisat!");
                    else afisareTabel2(munti);
                    break;
                default:
                    System.out.println("Optiune invalida!");

            }
            optiune = afisareMeniu();
        }
    }
}
