
package com.jcaa.usersmanagement.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreEmpleadoTest {

    @Test
    void debeCrearNombreValido() {
        NombreEmpleado nombre = new NombreEmpleado("Aldair Anaya");

        assertEquals("Aldair Anaya", nombre.value());
    }

    @Test
    void debeEliminarEspaciosAlCrearNombre() {
        NombreEmpleado nombre = new NombreEmpleado("  Aldair Anaya  ");

        assertEquals("Aldair Anaya", nombre.value());
    }

    @Test
    void noDebeAceptarNombreNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new NombreEmpleado(null)
        );
    }

    @Test
    void noDebeAceptarNombreVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new NombreEmpleado("")
        );
    }

    @Test
    void noDebeAceptarNombreConEspacios() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new NombreEmpleado("   ")
        );
    }

    @Test
    void debeReconocerObjetosIguales() {
        NombreEmpleado nombre1 = new NombreEmpleado("Aldair Anaya");
        NombreEmpleado nombre2 = new NombreEmpleado("Aldair Anaya");

        assertEquals(nombre1, nombre2);
        assertEquals(nombre1.hashCode(), nombre2.hashCode());
    }

    @Test
    void noDebeConsiderarIgualesNombresDiferentes() {
        NombreEmpleado nombre1 = new NombreEmpleado("Aldair Anaya");
        NombreEmpleado nombre2 = new NombreEmpleado("Carlos Pérez");

        assertNotEquals(nombre1, nombre2);
    }

    @Test
    void noDebeConsiderarIgualUnObjetoDeOtraClase() {
        NombreEmpleado nombre = new NombreEmpleado("Aldair Anaya");

        assertNotEquals(nombre, "Aldair Anaya");
    }

    @Test
    void debeReconocerElMismoObjeto() {
        NombreEmpleado nombre = new NombreEmpleado("Aldair Anaya");

        assertEquals(nombre, nombre);
    }

    @Test
    void debeMostrarElNombreComoTexto() {
        NombreEmpleado nombre = new NombreEmpleado("Aldair Anaya");

        assertEquals("Aldair Anaya", nombre.toString());
    }
}
