
package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.valueobject.CargoEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.DocumentoEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.NombreEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.Salario;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoModelTest {

    @Test
    void debeCrearEmpleadoCorrectamente() {
        EmpleadoModel empleado = new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "123456789",
                "Auxiliar",
                new BigDecimal("1500000")
        );

        assertEquals("EMP-001", empleado.getId());
        assertEquals("Aldair Anaya", empleado.getNombre());
        assertEquals("123456789", empleado.getDocumento());
        assertEquals("Auxiliar", empleado.getCargo());
        assertEquals(
                new BigDecimal("1500000"),
                empleado.getSalario()
        );
    }

    @Test
    void debeCrearLosObjetosDeValorCorrectamente() {
        EmpleadoModel empleado = new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "123456789",
                "Auxiliar",
                new BigDecimal("1500000")
        );

        assertNotNull(empleado.getNombreValueObject());
        assertNotNull(empleado.getDocumentoValueObject());
        assertNotNull(empleado.getCargoValueObject());
        assertNotNull(empleado.getSalarioValueObject());

        assertInstanceOf(
                NombreEmpleado.class,
                empleado.getNombreValueObject()
        );
        assertInstanceOf(
                DocumentoEmpleado.class,
                empleado.getDocumentoValueObject()
        );
        assertInstanceOf(
                CargoEmpleado.class,
                empleado.getCargoValueObject()
        );
        assertInstanceOf(
                Salario.class,
                empleado.getSalarioValueObject()
        );
    }

    @Test
    void noDebeAceptarIdNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoModel(
                        null,
                        "Aldair Anaya",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeAceptarIdVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoModel(
                        "",
                        "Aldair Anaya",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeAceptarIdConEspacios() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoModel(
                        "   ",
                        "Aldair Anaya",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeAceptarNombreVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoModel(
                        "EMP-001",
                        "",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("1500000")
                )
        );
    }

    @Test
    void noDebeAceptarSalarioNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoModel(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789",
                        "Auxiliar",
                        new BigDecimal("-100")
                )
        );
    }
}
