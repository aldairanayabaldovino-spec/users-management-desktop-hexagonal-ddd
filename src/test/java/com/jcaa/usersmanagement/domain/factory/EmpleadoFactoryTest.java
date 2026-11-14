
package com.jcaa.usersmanagement.domain.factory;

import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoFactoryTest {

    private final EmpleadoFactory factory = new EmpleadoFactory();

    @Test
    void debeCrearEmpleadoCorrectamente() {
        EmpleadoModel empleado = factory.crear(
                "EMP-001",
                "Aldair Anaya",
                "123456789",
                "Auxiliar",
                new BigDecimal("1500000")
        );

        assertNotNull(empleado);
        assertEquals("EMP-001", empleado.getId());
        assertEquals("Aldair Anaya", empleado.getNombre());
        assertEquals("123456789", empleado.getDocumento());
        assertEquals("Auxiliar", empleado.getCargo());
        assertEquals(
                0,
                empleado.getSalario().compareTo(
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeCrearEmpleadoConDatosInvalidos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factory.crear(
                        "EMP-001",
                        "",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeCrearEmpleadoConSalarioNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factory.crear(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("-1000")
                )
        );
    }
}
