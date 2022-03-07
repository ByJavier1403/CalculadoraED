/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author JAVIER
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String prueba = "44+(55-76)*3.2";
        
        System.out.println("\n *** -------- ***** \n");
        PilaA a = new PilaA <>();
        a = Funciones.separarOperadoresNumeros(prueba);
        System.out.println(a.toString());
        System.out.println("\n *** -------- ***** \n");
        PilaA b = new PilaA <>();
        b = Funciones.transPostFijaConPila(a);
        System.out.println(b.toString());
        double aux = Funciones.calculoFinal(b);
        System.out.println(aux);
    }
    
}
