package laborator3;

public class Teste {
    public static void testMunte(){
        Munte m = new Munte("zz", 1);
        Munte n = new Munte("am", 10);
        if(!m.maiMareAlfabetic(n)) System.out.println("Nu e ok");
        Munte k = new Munte();
        Munte []munti = {m, n, k};

    }


}
