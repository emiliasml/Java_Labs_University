package laborator3;

public class Munti {
    private Munte[] munti = null;      //vectorul de munti
    private int numarElemente;  //numarul curent de elemente din vector
    private int capacitate;     //numarul maxim de elemente care pot incapea in vector

    /**
     * constructor cu parametri
     **/
    Munti() {
        this.munti = new Munte[1];
        this.numarElemente = 0;
        this.capacitate = 1;
    }

    /**adaug un singur munte in vectorul de munti**/
    public void adaugareMunte(Munte m) {
        if (this.numarElemente == this.capacitate)
            maresteCapacitate(1);
        munti[numarElemente] = m;
        numarElemente++;
    }

    /**adaug elementele unui vector de munti in vectorul curent de munti
     * @param ms vectorul de munti care se adauga
     */
    public void adaugareMunti(Munti ms) {
        for (Munte m : ms.getMunti())
            adaugareMunte(m);
    }

    /**
     * maresc capacitatea vectorului de munti
     * @param nr :valoarea cu care il maresc
     */
    public void maresteCapacitate(int nr) {
        Munte[] ms = new Munte[this.capacitate + nr];
        for (int i = 0; i < this.capacitate; i++)
            ms[i] = this.munti[i];
        this.munti = ms;
        this.capacitate++;
    }

    /**
     * returnez un element de pe pozitia i
     */
    public Munte munteDePePozitia(int i) {
        if (i > numarElemente) return new Munte();
            return this.munti[i];
    }

    public Munte[] getMunti() {
        return this.munti;
    }

    public int getNumarElemente() {
        return numarElemente;
    }

    /**
     * calculeaza si returneaza inaltimea maxima din lista de munti
     */
    public long inaltimeMaxima() {
        long imax = this.munti[0].getInaltime();
        for (Munte m : munti)
            if (m.getInaltime() > imax)
                imax = m.getInaltime();
        return imax;
    }
}