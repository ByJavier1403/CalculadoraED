package pila_01;
/**
 *
 * @author tania
 */
public class PruebaCalculoOper {
    
    public static void main(String[] args) {
        PilaA<String> cad = new PilaA();
        PilaA num = new PilaA();
        
        cad.push("5");
        cad.push("10");
        cad.push("15");
        cad.push("-48.25");
        //cad.push("-");
        //cad.push("^");
        
        System.out.println(CalculoOperaciones.calculo(cad));
        //System.out.println(CalculoOperaciones.calculo(cad).toString());
    }
}
