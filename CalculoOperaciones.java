package pila_01;

import java.util.ArrayList;

/**Tania Ariadna Dominguez Palma
 *27/02/2022
 * Clase que realiza las operaciones necesarias para obtener un resultado
 */
public class CalculoOperaciones {
    
    public static <T> void invierteOrden(PilaADT pila){
        ArrayList ar = new ArrayList<PilaADT>();
        
        while(!pila.isEmpty()){
            ar.add(pila.pop());
        }
        for(int i = 0; i < ar.size(); i++){
            pila.push(ar.get(i));
        }
    }
    
    public static double calculo(PilaA<String> pila){
        PilaA<Double> num  = new PilaA();
        double aux, aux2, res, conver, resFin = 0;
        String dat;
        
        invierteOrden(pila);
        while(!pila.isEmpty()){
            dat = pila.pop();
            switch (dat) {
            case "+":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux + aux2;
                    num.push(res);
                break;
            case "-":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux - aux2;
                    num.push(res);
                break;
            case "*":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux * aux2;
                    num.push(res);
                break;
            case "/":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux / aux2;
                    num.push(res);
                break;
            case "^":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = Math.pow(aux, aux2);
                    num.push(res);
                break;
            default:
                num.push(Double.parseDouble(dat)); 
                break;
            }
        }
        resFin = num.pop();
        return resFin;
    }
}
