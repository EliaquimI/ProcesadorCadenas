package com.utez.pruebas.ejercicios;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorCadenasTest {

    private ProcesadorCadenas procesador;

    @BeforeEach
    void setUp() {
        procesador = new ProcesadorCadenas();
    }



    @Test
    void cV_cadenaNormal_variasVocales() {
        // "Hola Mundo" -> o,a,u,o = 4
        assertEquals(4, procesador.cV("Hola Mundo"));
    }

    @Test
    void cV_cadenaSinVocales() {
        assertEquals(0, procesador.cV("xyz pt"));
    }

    @Test
    void cV_cadenaVacia() {
        assertEquals(0, procesador.cV(""));
    }

    @Test
    void cV_cadenaNula() {
        assertEquals(0, procesador.cV(null));
    }

    @Test
    void cV_conAcentos_validaComportamientoActual() {

        assertEquals(2, procesador.cV("canción"));
    }

    @Test
    void cV_mayusculas_y_minusculas() {
        assertEquals(5, procesador.cV("AEIOU"));
        assertEquals(5, procesador.cV("aeiou"));
        assertEquals(10, procesador.cV("aEiOuAEIOu"));
    }

    @Test
    void esPalindromo_palabraSimple() {
        assertTrue(procesador.esPalindromo("radar"));
    }

    @Test
    void esPalindromo_noPalindromo() {
        assertFalse(procesador.esPalindromo("hola"));
    }

    @Test
    void esPalindromo_conEspaciosYMayusculas() {
        assertTrue(procesador.esPalindromo("Anita lava la tina"));
    }

    @Test
    void esPalindromo_cadenaVacia() {
        assertTrue(procesador.esPalindromo(""));
    }

    @Test
    void esPalindromo_cadenaNula() {
        assertFalse(procesador.esPalindromo(null));
    }

    @Test
    void esPalindromo_conEspaciosExtra() {
        assertTrue(procesador.esPalindromo("  a  n  a  "));
    }

    @Test
    void esPalindromo_noEliminaOtrosCaracteres() {

        assertFalse(procesador.esPalindromo("anita, lava la tina"));
    }
}