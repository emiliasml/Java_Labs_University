package pregatire_examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CitireFisier {
    static ArrayList<Bijuterie> citireFisier() {
        ArrayList<Bijuterie> bijuterii = new ArrayList<Bijuterie>();
        try {
            BufferedReader fisier = new BufferedReader(new FileReader("C:\\Users\\emili\\IdeaProjects\\MapLaboratoare\\src\\pregatire_examen\\Bijuterii.txt"));
            String linie = fisier.readLine();
            while ((linie = fisier.readLine()) != null) {   //citesc linie cu linie
                String[] elemente = linie.split(",");   //despart linia in cuvinte

                String denumire = elemente[0];  //primul element este denumirea
                String tip = elemente[1];
                int stocInitial = Integer.parseInt(elemente[2]);
                int vandute = Integer.parseInt(elemente[3]);
                int pretUnit = Integer.parseInt(elemente[4]);
                bijuterii.add(new Bijuterie(denumire, tip, stocInitial, vandute, pretUnit));
            }
            fisier.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bijuterii;
    }
}
