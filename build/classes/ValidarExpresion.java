/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author marij
 */
public class ValidarExpresion {
    
     public static boolean revisaParentesis (String cadena) {
        boolean resp = true;
        int largo = cadena.length(), i = 0;
        PilaArre<Character> pila = new PilaArre();
        while (i < largo && resp){
            if (cadena.charAt(i) == '(')
                pila.push('(');
            else 
                if (cadena.charAt(i) == ')')
                    if (!pila.isEmpty())
                        pila.pop();
                    else 
                        resp = false;
           i++;
        }
        return pila.isEmpty() && resp;
    }
     
     /*Esto no funciona Erick, tal vez quieras borrarlo todo y empezar de cero
     public static boolean revisaSignos (String cadena){
        boolean resp = true;
        int largo = cadena.length(), i = 0;
        PilaArre<Integer> pila = new PilaArre();
        char aux1, aux2;
        while (i < largo && resp){
            aux1 = cadena.charAt(i);
            if (aux1 == '+' || aux1 == '*' || aux1 == '/' || aux1 == '-' || aux1 =='(')
               if (i - pila.peek() == 1)
                   resp = false;
                else
                 pila.push(i);
            
            i++;
        }
        return resp;
     }
    */
     
     
     public static void main(String[] args) {
        //Revisa par[entesis     
        System.out.println("\n--- Revisa par[entesis ---");
        System.out.println("CP1: " + AHerramientasDePilas.revisaParentesis("(Hola)")); //True
        System.out.println("CP2: " + AHerramientasDePilas.revisaParentesis(")Hola)(")); //False
        System.out.println("CP3: " + AHerramientasDePilas.revisaParentesis("(Hola(")); //False
        System.out.println("CP4: " + AHerramientasDePilas.revisaParentesis(")Hola)")); //False
        System.out.println("CP5: " + AHerramientasDePilas.revisaParentesis("Hola")); //True
        System.out.println("CP6: " + AHerramientasDePilas.revisaParentesis("")); //True
        
        //Revisa signos    
        System.out.println("\n--- Revisa signos ---");
        System.out.println("CP1: " + AHerramientasDePilas.revisaParentesis("a+b-c*d/e")); //True
        System.out.println("CP2: " + AHerramientasDePilas.revisaParentesis("*a+b")); //False
        System.out.println("CP3: " + AHerramientasDePilas.revisaParentesis("a+b/")); //False
        System.out.println("CP4: " + AHerramientasDePilas.revisaParentesis("-a/b")); //True
        System.out.println("CP5: " + AHerramientasDePilas.revisaParentesis("a/b-")); //False
        System.out.println("CP6: " + AHerramientasDePilas.revisaParentesis("a*-b")); //True
        System.out.println("CP7: " + AHerramientasDePilas.revisaParentesis("a*-/b")); //False
        System.out.println("CP8: " + AHerramientasDePilas.revisaParentesis("a*+b")); //False
        System.out.println("CP9: " + AHerramientasDePilas.revisaParentesis("abcd")); //True
        System.out.println("CP10: " + AHerramientasDePilas.revisaParentesis(""));//True
        
        
    }
}
