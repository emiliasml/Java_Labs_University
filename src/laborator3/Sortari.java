package laborator3;

public class Sortari {

    /**sorteaza o lista de munti dupa
     * numele muntilor in ordine alfabetica*/
    public static void sortareNumeAlfabetic(Munti munti) {
        int n = munti.getNumarElemente();   // n este lungimea listei de munti
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1 ; j++)
                if (munti.munteDePePozitia(j).maiMareAlfabetic(munti.munteDePePozitia(j+1))) {
                    //daca muntele de pe pozitia j e mai mare alfabetic
                    //decat cel de pe pozitia j+1, ii inversez
                   munti.munteDePePozitia(j).swapMunti(munti.munteDePePozitia(j+1));
                }
    }

    /**sorteaza o lista de munti crescator
     *  dupa inaltimea muntilor */
    public static void sortareInaltimicrescator(Munti munti){
        for(int i = 0;i<munti.getNumarElemente();i++)
            for(int j = i+1;j<munti.getNumarElemente();j++)
                if(munti.munteDePePozitia(i).maiMicInaltime(munti.munteDePePozitia(j)))
                    munti.munteDePePozitia(i).swapMunti(munti.munteDePePozitia(j));
                //inversez muntii daca sunt in ordine crescatoare
    }


}
