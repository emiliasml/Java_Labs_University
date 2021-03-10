package pregatire_examen;

public class Bijuterie {

    private String denumire;
    private String tip;
    private int stocInitial;
    private int vandute;
    private int pretUnit;

    public Bijuterie() {
    }

    public Bijuterie(String denumire, String tip, int stocInitial, int vandute, int pretUnit) {
        this.denumire = denumire;
        this.tip = tip;
        this.stocInitial = stocInitial;
        this.vandute = vandute;
        this.pretUnit = pretUnit;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getStocInitial() {
        return stocInitial;
    }

    public void setStocInitial(int stocInitial) {
        this.stocInitial = stocInitial;
    }

    public int getVandute() {
        return vandute;
    }

    public void setVandute(int vandute) {
        this.vandute = vandute;
    }

    public int getPretUnit() {
        return pretUnit;
    }

    public void setPretUnit(int pretUnit) {
        this.pretUnit = pretUnit;
    }
}
