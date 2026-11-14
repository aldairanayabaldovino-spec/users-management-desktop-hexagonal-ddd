
package com.jcaa.usersmanagement.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoInvalidoExceptionTest {

    @Test
    void debeCrearExcepcionConMensaje() {
        EmpleadoInvalidoException exception =
                new EmpleadoInvalidoException(
                        "El nombre del empleado es obligatorio"
                );

        assertEquals(
                "El nombre del empleado es obligatorio",
                exception.getMessage()
        );
    }

    @Test
    void debeCrearExcepcionConCausa() {
        IllegalArgumentException causa =
                new IllegalArgumentException("Dato incorrecto");

        EmpleadoInvalidoException exception =
                new EmpleadoInvalidoException(
                        "Empleado inválido",
                        causa
                );

        assertEquals("Empleado inválido", exception.getMessage());
        assertSame(causa, exception.getCause());
    }

}
