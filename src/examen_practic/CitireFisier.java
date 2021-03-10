package examen_practic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CitireFisier {
    static ArrayList<Alcool> citireFisier() {
        ArrayList<Alcool> multAlcool = new ArrayList<>();
        try {
            BufferedReader fisier = new BufferedReader(new FileReader("C:\\Users\\emili\\IdeaProjects\\MapLaboratoare\\src\\examen_practic\\Alcool.txt"));
            String linie /*= fisier.readLine()*/;
            while ((linie = fisier.readLine()) != null) {   //citesc linie cu linie
                String[] elemente = linie.split(",");   //despart linia in cuvinte
                //(denumire,tip,stocInitial,pretUnit,vandute)
                String denumire = elemente[0];  //primul element este denumirea
                String tip = elemente[1];
                int stocInitial = Integer.parseInt(elemente[2]);
                int pretUnit = Integer.parseInt(elemente[3]);
                int vandute = Integer.parseInt(elemente[4]);
                multAlcool.add(new Alcool(denumire, tip, stocInitial, pretUnit, vandute));
            }
            fisier.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return multAlcool;
    }
}
