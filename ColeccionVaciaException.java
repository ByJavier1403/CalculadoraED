package pila;

public class ColeccionVaciaException extends RuntimeException{

    public ColeccionVaciaException() {
        super();
    }
    
     public ColeccionVaciaException(String mensaje) {
        super(mensaje);
    }
    
}
