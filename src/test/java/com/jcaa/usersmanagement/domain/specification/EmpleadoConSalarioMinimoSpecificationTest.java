
package com.jcaa.usersmanagement.domain.specification;

import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoConSalarioMinimoSpecificationTest {

    private final EmpleadoConSalarioMinimoSpecification specification =
            new EmpleadoConSalarioMinimoSpecification(
                    new BigDecimal("1300000")
            );

    @Test
    void debeAceptarEmpleadoConSalarioSuperiorAlMinimo() {
        EmpleadoModel empleado = crearEmpleado("1500000");

        assertTrue(specification.isSatisfiedBy(empleado));
    }

    @Test
    void debeAceptarEmpleadoConSalarioIgualAlMinimo() {
        EmpleadoModel empleado = crearEmpleado("1300000");

        assertTrue(specification.isSatisfiedBy(empleado));
    }

    @Test
    void debeRechazarEmpleadoConSalarioInferiorAlMinimo() {
        EmpleadoModel empleado = crearEmpleado("1000000");

        assertFalse(specification.isSatisfiedBy(empleado));
    }

    @Test
    void debeRechazarEmpleadoNulo() {
        assertFalse(specification.isSatisfiedBy(null));
    }

    @Test
    void noDebePermitirSalarioMinimoNulo() {
        assertThrows(
                NullPointerException.class,
                () -> new EmpleadoConSalarioMinimoSpecification(null)
        );
    }

    @Test
    void noDebePermitirSalarioMinimoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoConSalarioMinimoSpecification(
                        new BigDecimal("-1000")
                )
        );
    }

    private EmpleadoModel crearEmpleado(String salario) {
        return new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "123456789",
                "Auxiliar",
                new BigDecimal(salario)
        );
    }
}
