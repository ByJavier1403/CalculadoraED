package calculadora;
/**Clase: PruebaCalculoOper 
 * Prueba distintos casos para los metodos de la clase CalculoOperaciones
 * @version Numero de version: 1
 */
public class PruebaCalculoOper {
    /**Metodo Main
     * @param args que permite hacer pruebas
     */
    public static void main(String[] args) {
        PilaA<String> cad = new PilaA();
        PilaA<String> cad1 = new PilaA();
        PilaA<String> cad2 = new PilaA();
        PilaA<String> cad3 = new PilaA();
        PilaA<String> cad4 = new PilaA();
        PilaA<String> cad5 = new PilaA();
        String num = "76.77+23.88*12.67";
        String num2 = "-76.77+23.88*12.67";
        PilaA<String> pil = new PilaA();
        
        PilaA<String> a = new PilaA();
        a = CalculoOperaciones.transPostFijaConPilaPunto(num2);
        System.out.println(a.toString());
        
        /*
        cad.push("3");
        cad.push("4");
        cad.push("-");
        //cad.push("-48.25");
        //cad.push("5");
        //cad.push("*");
        cad1.push("-25");
        cad1.push("-2.3");
        cad1.push("*");
        cad2.push("5");
        cad2.push("4");
        cad2.push("-");
        cad3.push("2");
        cad3.push("3");
        cad3.push("5");
        cad3.push("2");
        cad3.push("^");
        cad3.push("+");
        cad3.push("3");
        cad3.push("*");
        cad3.push("+");
        cad4.push("76.77");
        cad4.push("23.88");
        cad4.push("12.67");
        cad4.push("*");
        cad4.push("+");
        pil = CalculoOperaciones.transPostFijaConPilaPunto(num);
        System.out.println(CalculoOperaciones.calculo(cad));
        System.out.println(CalculoOperaciones.calculo(cad1));
        System.out.println(CalculoOperaciones.calculo(cad2));
        System.out.println(CalculoOperaciones.calculo(cad3));
        System.out.println(CalculoOperaciones.calculo(cad4));
        System.out.println(CalculoOperaciones.calculo(pil));
*/
    }
}
