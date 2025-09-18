
public class App {
    public static void main(String[] args) {
        Funcoes f = new Funcoes();
        for(int i=1; i<300; i+=10){
            int r = f.f5(i);
            System.out.println(i+";"+r);
        }
    }       
}
