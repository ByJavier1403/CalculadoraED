package pila;

public interface PilaADT <T> {
    public void push (T dato);
    public T pop ();
    public boolean isEmpty ();
    public T peek ();
    public void multiPop (int n);
    
}
