/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 * Esta clase se encarga de la segunda parte de la verificación, reescritura y evaluación de la expresión.
 * 
 * @author Equipo 1
 */
public class Funciones {
    
    //Arreglo de operaciones con el objetivo de optimizar y clarificar el código
    private static String[] operaciones = new String[] {"(",")","+","-","*","/"};
    private static int[] prioridad =    new int[]  {0, 1,  2, 2, 3, 3};
    private static final int MAXIMO_OP = 6;

    /**
     * Revisa que los paréntesis de una expresión estén bien balanceados.
     * 
     * Usando una pila auxiliar, determina si cada paréntesis izquierdo se corresponde con uno derecho.
     * 
     * @param formula representa la expresión a revisar.
     * @return devuelve un verdadero o un falso.
     */
    public static boolean revisadorDeParentesis(String formula){
        PilaA pila = new PilaA ();
        int i = 0;
        char cha;
        boolean isBalanceado = true;
        while (i < formula.length() && isBalanceado ){
            cha = formula.charAt(i);
            if (cha == '(')
                pila.push('(');
            else if (cha == ')' )
                if (!pila.isEmpty())
                    pila.pop();
                else 
                    isBalanceado = false;
            
            i++;
        }
        return pila.isEmpty() && isBalanceado;
    } 
    
    /**
     * Auxiliar. Convierte a una pila la cadena que introduce el usuario.
     * 
     * Conserva el orden, separando los operadores de los números.
     * 
     * @param formula representa la cadena proporcionada por el usuario.
     * @return regresa una pila con los caractéres separados.
     */ 
public static PilaA <String> separarOperadoresNumeros(String formula){
        int i=0,j=0;
        String cha;
        String auxiliar = "";
        //La pila que mandaré como resultado
        PilaA <String> inf = new PilaA();
        boolean isPrimero = true,isOperador = false;
        while(i<formula.length()){
            cha = String.valueOf(formula.charAt(i));
            while(j<MAXIMO_OP && !isOperador){
                if(cha.equals(operaciones[j])){
                    isOperador = true;
                    if(auxiliar.length()>=1) {
                        //Caso del número
                        //Añadir a la pila
                        inf.push(auxiliar);
                        auxiliar="";
                    }else{
                        if(operaciones[j].equals("-") && isPrimero){
                            isPrimero = false;
                            //Caso 0-n
                            //System.out.println("0");
                            
                            
                            //Añadir a la pila un 0
                            
                            inf.push("0");
                        }
                    }
                    //Operador
                    //System.out.println(operaciones[j]);
                    
                    //Añadir a la pila el operador
                    inf.push(operaciones[j]);
                    
                }
                j++;    
            }
            if(!isOperador){
                auxiliar+=cha;
            }
            isOperador = false;
            i++;
            j=0;
        }
        if(auxiliar.length()>=1){  
            //"Residuo"
            
            //System.out.println(auxiliar);
            
            
            //Añadir a la pila lo que quedaba
            inf.push(auxiliar);
        }
        
        intercambiaElem(inf);
        
        
        //AQUÍ PONER EL RETURN DE MI PILA INF
        return inf;
    }

    private static <T> int buscaSecuencial (T [] arre, int tE, T dato) {
		int i;
		i = 0;
		while ( i <tE && !(arre[i].equals(dato))) 
			i++;
		
		if (i == tE)
			i = -1;
		
		return i;
    }
    
        private static <T> int elementosPila (PilaADT pila){
        PilaA alterna = new PilaA <>();
        int res = 0;
        boolean aux = true;
        
        while (aux){
            try{
                alterna.push(pila.pop());
                res++;
            }catch(Exception e){
                aux = false;
            }
        }
        
        
        for (int i = 0; i < res; i++){
            pila.push(alterna.pop());
        }
        
        return res;
    }
    
    //Invertir
    private static <T> void intercambiaElem (PilaADT pila) {
        int numE;
        ArrayList a = new ArrayList();
        numE = elementosPila(pila);
        for (int i = 0; i < numE; i++){
            a.add(pila.pop());
        }
        for (int j = 0; j < numE; j++){
            pila.push(a.get(j));
        }
    }
    
    /**
     * Reescribe una expresión usando la notación postfija.
     *
     * Usando condicionales tanto simples como múltiples, identifica la prioridad de cada operador y sus correspondientes cifras, para luego acomodarlos en la pila que va a devolver.
     * 
     * @param operacion recibe una pila con los datos en el orden en el que los insertó el usuario.
     * @return devuelve una pila con la operación reorganizada, respetando la jerarquía de operaciones.
     */
    public static PilaA<String> transPostFijaConPila (PilaA<String> operacion) {    
        PilaA <String> post = new PilaA(); //Guardar postfija
        PilaA <String> operadores = new PilaA <>(); //Guardar los operadores +-/*()
        String dato; //Guardar el tope de la pila
        int pos; //Valor que ocupa el elemento en el priority queue
        int p1; //Definir la prioridad del elemento evaluado
        int p2; //Definir la prioridad del elemento en la pila
        int i = 0;
        boolean isPrimero = true; //Ayuda para saber si es la primer operación que agregamos
        
        while (!operacion.isEmpty()){
            dato = operacion.pop();
            pos = buscaSecuencial(operaciones, MAXIMO_OP, dato);
            if (pos == -1) {
                post.push(dato);
            }
            else {
                switch (prioridad[pos]){
                    case 0: //Paréntesis "("                        
                        operadores.push(dato);
                        break;
                    case 1: //Paréntesis ")"
                        while (!operadores.peek().equals("(")){                                                    
                            post.push(String.valueOf(operadores.pop()));
                        }
                        operadores.pop(); 
                        break;
                    default:
                        if(isPrimero){
                            isPrimero = false;
                            operadores.push(dato);
                        }else{
                            p2 = buscaSecuencial (operaciones, MAXIMO_OP, operadores.peek());
                            while (!operadores.isEmpty() && (prioridad[pos] <= prioridad[p2])){                                                      
                                post.push(operadores.pop());
                            }
                            operadores.push(dato);
                        }
                        break;
                }
            } 
        }
        while (!operadores.isEmpty()){
            post.push(operadores.pop());
        }
        return post;
    }
    
    /**
     * Evalúa la operación y encuentra el resultado que se le devuelve al usuario.
     * 
     * Después de invertir la pila que recibe, usa un condicional múltiple dentro de un ciclo tipo while para identificar cada operador y evaluarlo correspondientemente.
     * 
     * @param pila recibe una pila con la expresión escrita en notación postfija.
     * @return arroja un valor con decimales: el resultado final del proceso.
     */
    public static double calculoFinal(PilaA<String> pila){
        PilaA<Double> num  = new PilaA();
        double aux, aux2, res, resFin = 0;
        String dat;
        
        intercambiaElem(pila);
        while(!pila.isEmpty()){
            dat = pila.pop();
            switch (dat) {
            case "+":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = (double) aux2 + aux;
                    num.push(res);
                break;
            case "-":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = (double) aux2 - aux;
                    num.push(res);
                break;
            case "*":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = (double) aux2 * aux;
                    num.push(res);
                break;
            case "/":
                    aux = num.pop();
                    aux2 = num.pop();
                    res = (double) aux2 / aux;
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