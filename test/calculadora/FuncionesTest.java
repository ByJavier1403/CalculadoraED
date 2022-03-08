/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculadora;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marij
 */
public class FuncionesTest {
    
    public FuncionesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of revisadorDeParentesis method, of class Funciones.
     */
    @Test
    public void testRevisadorDeParentesis() {
        System.out.println("revisadorDeParentesis");
        String formula = "";
        boolean expResult = false;
        boolean result = Funciones.revisadorDeParentesis(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of separarOperadoresNumeros method, of class Funciones.
     */
    @Test
    public void testSepararOperadoresNumeros() {
        System.out.println("separarOperadoresNumeros");
        String formula = "";
        PilaA<String> expResult = null;
        PilaA<String> result = Funciones.separarOperadoresNumeros(formula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transPostFijaConPila method, of class Funciones.
     */
    @Test
    public void testTransPostFijaConPila() {
        System.out.println("transPostFijaConPila");
        PilaA<String> operacion = null;
        PilaA<String> expResult = null;
        PilaA<String> result = Funciones.transPostFijaConPila(operacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculoFinal method, of class Funciones.
     */
    @Test
    public void testCalculoFinal() {
        System.out.println("calculoFinal");
        PilaA<String> pila = null;
        double expResult = 0.0;
        double result = Funciones.calculoFinal(pila);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
