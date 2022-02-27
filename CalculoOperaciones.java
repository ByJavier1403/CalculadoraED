package pila_01;
/**Tania Ariadna Dominguez Palma
 *27/02/2022
 * Clase que realiza las operaciones necesarias para obtener un resultado
 */
public class CalculoOperaciones {
    
    public static double calculo(PilaA<String> pila){
        PilaA<Double> num  = new PilaA();
        double aux, aux2, res, conver, resFin = 0;
        String dat;
        
        /*num.push(2.0);
        num.push(5.0);
        num.push(10.0);*/
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
                num.push(Double.parseDouble(dat)); //Error al ingresar datos
                break;
            }
        }
        resFin = num.pop();
        return resFin;
    }
}
