package Pilas;

/**
 *
 * <pre>
 *  Clase que contiene los métodos necesarios para transformar de una notación infija a una prefija
 *  Si se tuviera por ejemplo: a+b, se pasaría a: ab+
 *  Se apoya de algunos métodos auxiliares privados para facilitar el trabajo en los métodos principales
 * </pre>
 * @author diegomartineztinoco
 */

public class OrdenaPostFija { 
    /**
     * Método que determina si cierto caracter es un operador, es decir: +,-,*,/,^
     * @param Recibe una variable tipo char
     * @return Un resultado booleano que indica si el char obtenido es un operador o no
     */
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
    /**
     * <pre>
     * Método que ayuda a determinar qué clase de caracter estamos tratando.
     * Valores: </pre> <ul>
     * <li> 1 si es '('
     * <li> 2 si es ')'
     * <li> 3 si es operador
     * <li> 4 si es un operando
     * </ul>
     * @param Variable tipo char 
     * @return Un entero del 1 al 4
     */
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
    
    /**
     * <pre>
     * Método que indica el valor de los posibles elementos dentro de una operación
     * Valores: </pre> <ul>
     * <li> 0 = '(' --- Menor
     * <li> 1 = ')'
     * <li> 2 = '+' o '-'
     * <li> 3 = '*' o '/'
     * <li> 4 = '^' --- Mayor
     * </ul>
     * @param Recibe una variable tipo char 
     * @return Un entero que indica la jerarquía (del 0 al 4)
     */
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
      
        
    /**
     * Método que transforma de notación. Trabaja con: <ul>
     * <li> Una pila auxiliar para operadores
     * <li> Un String que guarda la nueva notación
     * </ul>
     * 
     * @param Variable tipo String con la notación infija
     * @return Una cadena con la nueva notación postfija
     */
    
     public static String transPostFija (String cadena) {
         StringBuilder res = new StringBuilder();
         
         PilaA <Character> operadores = new PilaA <>();
         char aux;
         int acomoda;
         for (int i = 0; i < cadena.length(); i++){
            aux = cadena.charAt(i);
            acomoda = determinaElemento(aux);
            switch (acomoda){
                case 1: //Parentesis '('
                    operadores.push(aux);
                    break;
                case 2: //Parentesis ')'
                    while (operadores.peek() != '('){                        
                            res.append(operadores.pop());
                    }
                    operadores.pop();                    
                    break;
                case 3: // Operador
                    while (!operadores.isEmpty() && (definePrioridad(aux) <= definePrioridad(operadores.peek()))){                          
                            res.append(operadores.pop());
                    }
                    operadores.push(aux);
                    break;
                case 4:
                    res.append(aux);
                    break;
                
            }
         }
         
         while (!operadores.isEmpty()){
            res.append(operadores.pop());
         }
         
         return res.toString();
     }
    
     /**
      * Método que convierte de infija a postfija, trabaja con 2 pilas:<ul>
      * <li>Para operadores
      * <li>Para guardar la nueva notación
      * </ul>
      * @param Variable tipo String (la cadena a transformar)
      * @return Una pila con la nueva notación postfija
      */
     
     
    //Determina si hay un punto decimal
    private static boolean trabajaPunto (char carac){
        boolean res = false;
        if (carac == '.')
            res = true;
        return res;
    } 
     
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
    
            
        
    
    public static void main(String[] args) {
        String prueba1 = "a+b*c";
        String prueba2 = "-76.77+23.88*12.67";
        String prueba3 = "(a+b)*c";
        String prueba4 = "a+(b+c^d)*f";
        
        
        System.out.println("\n1:\n");
        System.out.println(transPostFija(prueba1));
        System.out.println("\n2:\n");
        System.out.println(transPostFija(prueba2));
        System.out.println("\n3:\n");
        System.out.println(transPostFija(prueba3));
        System.out.println("\n4:\n");
        System.out.println(transPostFija(prueba4));
        
        PilaA a = new PilaA <>();
        a = transPostFijaConPilaPunto(prueba2);
        System.out.println(a.toString());
        
      
        
        
    }
    
}
