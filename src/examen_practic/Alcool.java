package examen_practic;

public class Alcool {
    private String denumire;
    private String tip;
    private int stocInitial;
    private int pretUnit;
    private int vandute;

    public Alcool() {
    }

    public Alcool(String denumire, String tip, int stocInitial, int pretUnit, int vandute) {
        this.denumire = denumire;
        this.tip = tip;
        this.stocInitial = stocInitial;
        this.pretUnit = pretUnit;
        this.vandute = vandute;
    }

    @Override
    public String toString() {
        return "Alcool{" +
                "denumire='" + denumire + '\'' +
                ", tip='" + tip + '\'' +
                ", stocInitial=" + stocInitial +
                ", pretUnit=" + pretUnit +
                ", vandute=" + vandute +
                '}';
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

    public int getPretUnit() {
        return pretUnit;
    }

    public void setPretUnit(int pretUnit) {
        this.pretUnit = pretUnit;
    }

    public int getVandute() {
        return vandute;
    }

    public void setVandute(int vandute) {
        this.vandute = vandute;
    }
}
