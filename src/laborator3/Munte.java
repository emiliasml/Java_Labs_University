package laborator3;

/*A. TAD Munte.
        - date membru:
            - nume: string;
            - inaltime: long;*/

public class Munte {
    private String nume;
    private long inaltime;

    /**constructor implicit*/
    Munte() {
        this.nume = null;
        this.inaltime = 0;
    }

    /**
     * constructor cu parametri
     * @param nume numele unui munte; de tip string
     * @param inaltime inaltimea unui munte; de tip long si pozitiva
     */
    Munte(String nume, long inaltime) {
        this.nume = nume;
        if(inaltime>0)
            this.inaltime = inaltime;
        else this.inaltime=0;
    }

    public long getInaltime() {
        return this.inaltime;
    }

    public String getNume() {
        return nume;
    }

    public void setInaltime(long inaltime) {
        this.inaltime = inaltime;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    /** returneaza true daca muntele este mai mare din punct de vedere
    alfabetic decat muntele m si 0 in caz contrar */
    public boolean maiMareAlfabetic(Munte m) {
        return this.nume.compareTo(m.getNume()) > 0;
    }

    /** returneaza true daca muntele este mai mare din punct de vedere
     * al inaltimii decat muntele dat ca parametru si false in caz contrar */
    public boolean maiMicInaltime(Munte m){
        return this.inaltime < m.getInaltime();
    }

    /** schimb parametrii muntelui actual cu muntele m */
    public void swapMunti(Munte m) {
        Munte auxiliar = new Munte(m.getNume(),m.getInaltime()); //pentru swap am nevoie de un munte auxiliar
        m.setInaltime(this.inaltime);
        m.setNume(this.nume);
        this.nume = auxiliar.getNume();
        this.inaltime = auxiliar.getInaltime();
    }
}
