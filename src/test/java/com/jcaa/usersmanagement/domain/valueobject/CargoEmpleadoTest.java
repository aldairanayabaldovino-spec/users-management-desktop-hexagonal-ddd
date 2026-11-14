
package com.jcaa.usersmanagement.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoEmpleadoTest {

    @Test
    void debeCrearCargoValido() {
        CargoEmpleado cargo = new CargoEmpleado("Auxiliar");

        assertEquals("Auxiliar", cargo.value());
    }

    @Test
    void debeEliminarEspaciosAlCrearCargo() {
        CargoEmpleado cargo = new CargoEmpleado("  Auxiliar  ");

        assertEquals("Auxiliar", cargo.value());
    }

    @Test
    void noDebeAceptarCargoNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CargoEmpleado(null)
        );
    }

    @Test
    void noDebeAceptarCargoVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CargoEmpleado("")
        );
    }

    @Test
    void noDebeAceptarCargoConEspacios() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CargoEmpleado("   ")
        );
    }

    @Test
    void debeReconocerObjetosIguales() {
        CargoEmpleado cargo1 = new CargoEmpleado("Auxiliar");
        CargoEmpleado cargo2 = new CargoEmpleado("Auxiliar");

        assertEquals(cargo1, cargo2);
        assertEquals(cargo1.hashCode(), cargo2.hashCode());
    }

    @Test
    void noDebeConsiderarIgualesCargosDiferentes() {
        CargoEmpleado cargo1 = new CargoEmpleado("Auxiliar");
        CargoEmpleado cargo2 = new CargoEmpleado("Contador");

        assertNotEquals(cargo1, cargo2);
    }

    @Test
    void noDebeConsiderarIgualUnObjetoDeOtraClase() {
        CargoEmpleado cargo = new CargoEmpleado("Auxiliar");

        assertNotEquals(cargo, "Auxiliar");
    }

    @Test
    void debeReconocerElMismoObjeto() {
        CargoEmpleado cargo = new CargoEmpleado("Auxiliar");

        assertEquals(cargo, cargo);
    }

    @Test
    void debeMostrarElCargoComoTexto() {
        CargoEmpleado cargo = new CargoEmpleado("Auxiliar");

        assertEquals("Auxiliar", cargo.toString());
    }
}
