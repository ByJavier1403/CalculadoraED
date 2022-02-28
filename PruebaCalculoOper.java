package pila_01;
/**@authorTania Ariadna Dominguez Palma
 *27/02/2022
 *Clase que prueba la clase CalculoOperaciones
 */
public class PruebaCalculoOper {
    
    public static void main(String[] args) {
        PilaA<String> cad = new PilaA();
        PilaA<String> cad1 = new PilaA();
        PilaA<String> cad2 = new PilaA();
        PilaA<String> cad3 = new PilaA();
        PilaA<String> cad4 = new PilaA();
        PilaA num = new PilaA();
        
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
        cad4.push("7");
        cad4.push("3");
        cad4.push("5");
        cad4.push("*");
        cad4.push("+");
        System.out.println(CalculoOperaciones.calculo(cad));
        System.out.println(CalculoOperaciones.calculo(cad1));
        System.out.println(CalculoOperaciones.calculo(cad2));
        System.out.println(CalculoOperaciones.calculo(cad3));
        System.out.println(CalculoOperaciones.calculo(cad4));
    }
}
