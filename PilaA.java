package pila;

public class PilaA <T> implements PilaADT<T> {
    private T[] pila;
    private int tope;
    private final int MAX = 20;

    public PilaA() {
        pila = (T[]) new Object[MAX];  
        tope = -1;
    }
    
    private void expand(){
        T[] nuevo = (T[]) new Object[pila.length * 2];
        for (int  i = 0; i <= tope; i++)
            nuevo[i] = pila[i];
        pila = nuevo;
    }
    
    @Override
    public T peek (){
        if (this.isEmpty())
            throw new ColeccionVaciaException("Pila vacía");
        return pila[tope];            
    }
    
    @Override
    public boolean isEmpty (){
        return tope == -1;
    }
    
    @Override //Delete
    public T pop (){
        if (this.isEmpty())
           throw new ColeccionVaciaException("Pila vacía");
        T resultado = pila[tope];
        pila[tope] = null;
        tope--;
        return resultado;
    }
    
    @Override //Add
    public void push (T dato) {
        if (tope == pila.length - 1)
            expand();
        tope++;
        pila[tope] = dato;
    }
    
    @Override
    public void multiPop (int n) {
        if (tope + 1 >= n)
            for (int i = 0; i < n; i++){
                pila[tope] = null;
                tope--;
            }
    }
    
    @Override
    public String toString (){
        StringBuilder sB = new StringBuilder();
        for (int i = tope; i >= 0; i--)
            sB.append(pila[i]).append("\n");
        return sB.toString();
    }
    
}
