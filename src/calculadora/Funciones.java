/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author JAV
 */
public class Funciones {    
        private static boolean revisadorDeParentesis(String formula){
        PilaA pila = new PilaA ();
        int i = 0;
        Character cha;
        boolean resp = true;
        
        while (i < formula.length() && resp ){
            cha = formula.charAt(i);
            if (cha == '(')
                pila.push('(');
            else if (cha == ')' )
                if (!pila.isEmpty())
                    pila.pop();
                else 
                    resp = false;
            
            i++;
        }
        return pila.isEmpty() && resp;         
    }  
}
