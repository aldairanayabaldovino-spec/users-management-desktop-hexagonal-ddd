package com.jcaa.usersmanagement.domain.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmpleadoModelTest {

    @Test
    void debeCrearEmpleadoCorrectamente() {
        EmpleadoModel empleado = new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "1234567890",
                "Auxiliar",
                new BigDecimal("1500000")
        );

        assertEquals("EMP-001", empleado.getId());
        assertEquals("Aldair Anaya", empleado.getNombre());
        assertEquals("1234567890", empleado.getDocumento());
        assertEquals("Auxiliar", empleado.getCargo());
        assertEquals(new BigDecimal("1500000"), empleado.getSalario());
    }

    @Test
    void noDebePermitirIdVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("", "Aldair", "1234567890",
                        "Auxiliar", new BigDecimal("1500000")));
    }

    @Test
    void noDebePermitirNombreVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("EMP-001", "", "1234567890",
                        "Auxiliar", new BigDecimal("1500000")));
    }

    @Test
    void noDebePermitirDocumentoVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("EMP-001", "Aldair", "",
                        "Auxiliar", new BigDecimal("1500000")));
    }

    @Test
    void noDebePermitirCargoVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("EMP-001", "Aldair", "1234567890",
                        "", new BigDecimal("1500000")));
    }

    @Test
    void noDebePermitirSalarioNulo() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("EMP-001", "Aldair", "1234567890",
                        "Auxiliar", null));
    }

    @Test
    void noDebePermitirSalarioNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoModel("EMP-001", "Aldair", "1234567890",
                        "Auxiliar", new BigDecimal("-1000")));
    }
}