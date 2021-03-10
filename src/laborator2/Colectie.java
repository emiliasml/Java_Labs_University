package laborator2;
/*A. TAD COLECTIE de numere întregi. Colecţia e structura de date asemănătoare mulţimii, cu
  singura diferenţă că elementele colecţiei nu trebuie să fie distincte între ele.
  B. Să se determine reuniunea şi intersecţia unor colecţii de numere întregi. O colecţie se dă
  întotdeauna începând pe un rând nou, iar sfârşitul elementelor sale este marcat prin numărul -1.
  Citirea se termină la întâlnirea colecţiei vide. Să se reţină colecţia cu cele mai multe elemente şi
  numărul de colecţii citite.
*/

import java.util.Arrays;

public class Colectie {
    private int[] elemente;
    private int lungime;

    Colectie() {
        this.elemente = null;
        lungime = 0;
    }

    Colectie(int[] vect, int lungime) {
        this.elemente = new int[lungime];
        if (lungime > 0) System.arraycopy(vect, 0, this.elemente, 0, lungime);
        Arrays.sort(this.elemente);
        this.lungime = lungime;
    }

    public void stergereColectie() {
        this.elemente = null;
        lungime = 0;
    }

    public int[] elementeColectie() {
        return this.elemente;
    }

    public int dimensiune() {
        return this.lungime;
    }

    //returneaza numarul de aparitii ale unui element
    public int numarAparitiiElement(int el) {
        if (dimensiune() == 0) return 0;
        int nr = 0;
        for (int element : this.elemente)
            if (element == el) nr++;
        return nr;
    }

    public void adaugareElement(int a) {
        if (this.elemente == null) {    //daca lista de elemente este goala, o ii fac lungimea 1 si
            this.elemente = new int[1];                     // pun a pe prima pozitie
            this.elemente[0] = a;
            this.lungime = 1;
        } else {                                //daca mai sunt elemente in colectie, maresc vectorul cu 1
            int[] vect = new int[lungime + 1];              //si adaug a
            for (int i = 0; i < this.lungime; i++)
                vect[i] = this.elemente[i];
            vect[lungime] = a;
            this.lungime++;
            this.elemente = new int[this.lungime];
            for (int i = 0; i < lungime; i++)
                this.elemente[i] = vect[i];
        }
    }

    //  0 1 2 3 4 5
    //  6 7 8 9 0 1
    public void stergereElement(int elem) {
        for (int i = 0, k = 1; i < elemente.length && k == 1; i++) {
            if (elem == elemente[i]) {
                int[] cop = new int[elemente.length - 1];
                for (int j = 0; j < i; j++)
                    cop[j] = elemente[j];
                for (int j = i; j < elemente.length - 1; j++)
                    cop[j] = elemente[j + 1];
                this.elemente = cop;
                k = 0;
            }
        }
    }

    //returneaza pozitia unui element din Colectie
    public int pozitiaUnuiElement(int elem) {
        for (int i = 0; i < elemente.length; i++) {
            if (elemente[i] == elem)
                return i;
        }
        return -1;
    }

    public int accesareElementDePePozitia(int i) {
        if (i >= elemente.length) return -1;
        else return elemente[i];
    }

    //modifica un element de pe o pozitie data cu altul
    public void modificareElementDePePozitia(int i, int element) {
        if (i < elemente.length) elemente[i] = element;
    }

    public void modificareElementDat(int elementulModificat, int elementNou) {
        int poz = pozitiaUnuiElement(elementulModificat);
        while (poz != -1) {
            modificareElementDePePozitia(poz, elementNou);
            poz = pozitiaUnuiElement(elementulModificat);
        }
    }
}
