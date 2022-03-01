package proyect;

import java.util.ArrayList;

/**Clase: CalculoOperaciones 
 * Realiza las operaciones necesarias para obtener un resultado
 * @version Numero de version: 1
 */
public class CalculoOperaciones {
    
    /**Nombre del metodo: invierteOrden
     * Descripcion: Invierte el orden de una pila de cualquier tipo
     * @param <T> indica que puede ser de cualquier tipo
     * @param pila de cualquier tipo
     */
    public static <T> void invierteOrden(PilaADT pila){
        ArrayList ar = new ArrayList<PilaADT>();
        
        while(!pila.isEmpty()){
            ar.add(pila.pop());
        }
        for(int i = 0; i < ar.size(); i++){
            pila.push(ar.get(i));
        }
    }
    
    //Determina si hay un punto decimal
    private static boolean trabajaPunto (char carac){
        boolean res = false;
        if (carac == '.')
            res = true;
        return res;
    }
    
    private static int definePrioridad (char signo){
        int res;

        
        if (signo == '(')
            res = 0;
        else
            if(signo == ')')
                res = 1;
            else        
                if (signo == '+' || signo == '-'){
                    res = 2;
                }
                else
                    if (signo == '*' || signo == '/')
                        res = 3;
                    else
                        res = 4;  //Prioridad de la potencia
        
        return res;
    }
private static int determinaElemento (char ele){
        int res;
        
        if (ele == '(')
            res = 1;
        else
            if (ele == ')')
                res = 2;
            else 
                if (confirmaOperador(ele))
                    res = 3;
                else        //Significa que entonces es un número
                    res = 4;
            
        
        return res;
    }

    private static boolean confirmaOperador (char op){
        boolean res = false;
        char suma = '+';
        char resta = '-';
        char multi = '*';
        char div = '/'; 
        if (op == suma || op == multi || op == div || op == resta ){
            res = true;
        }
        return res;
    }
    /**transPostFijaConPilaPunto
     * Arroja una pila con el acomodo jerarquico de las operaciones
     * @param cadena de tipo String
     * @return pila de tipo String
     */
    public static PilaA<String> transPostFijaConPilaPunto (String cadena) {
        PilaA <String> post = new PilaA();
        PilaA <Character> operadores = new PilaA <>();
        char aux;
        int acomoda;
        String cadaux;
        
        int i = 0;
        while (i < cadena.length()){
            aux = cadena.charAt(i);
            acomoda = determinaElemento(aux);
            cadaux = "";
            while ((acomoda == 4 || trabajaPunto(aux)) && i < cadena.length()){
                aux = cadena.charAt(i);
                acomoda = determinaElemento(aux);
                if (!confirmaOperador(aux))
                    cadaux = cadaux + aux;
                i++;
            }
            post.push(cadaux);
            switch (acomoda){
                case 1: //Parentesis '('
                    operadores.push(aux);
                    break;
                case 2: //Parentesis ')'
                    while (operadores.peek() != '('){                                                    
                            post.push(String.valueOf(operadores.pop()));
                    }
                    operadores.pop();                    
                    break;
                case 3: // Operador
                    while (!operadores.isEmpty() && (definePrioridad(aux) <= definePrioridad(operadores.peek()))){                                                      
                            post.push(String.valueOf(operadores.pop()));
                    }
                    operadores.push(aux);
                    break;
            }
            
        }
        
        while (!operadores.isEmpty()){
            post.push(String.valueOf(operadores.pop()));
         }
         
        return post;
    }
    
    /**Numbre: Calculo
     * Descripcion: Realiza las operaciones algebraicas de acuerdo con la cadena postfija
     * @param pila de tipo String
     * @see invierteOrden
     * @return double que es el resutado de las operaciones
     */
    public static double calculo(PilaA<String> pila){
        PilaA<Double> num  = new PilaA();
        double aux, aux2, res, resFin = 0;
        String dat;
        
        invierteOrden(pila);
        while(!pila.isEmpty()){
            dat = pila.pop();
            switch (dat) {
            case "+":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux2 + aux;
                    num.push(res);
                break;
            case "-":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux2 - aux;
                    num.push(res);
                break;
            case "*":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux2 * aux;
                    num.push(res);
                break;
            case "/":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = aux2 / aux;
                    num.push(res);
                break;
            case "^":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = Math.pow(aux2, aux);
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
