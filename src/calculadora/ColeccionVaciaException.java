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
public class ColeccionVaciaException extends RuntimeException{

    public ColeccionVaciaException() {
        super();
    }
    
     public ColeccionVaciaException(String mensaje) {
        super(mensaje);
    }
    
}
