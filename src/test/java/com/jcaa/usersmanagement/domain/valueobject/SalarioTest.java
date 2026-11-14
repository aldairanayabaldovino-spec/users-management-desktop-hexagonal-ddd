
package com.jcaa.usersmanagement.domain.valueobject;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalarioTest {

    @Test
    void debeCrearSalarioValido() {
        Salario salario = new Salario(new BigDecimal("1500000"));

        assertEquals(
                new BigDecimal("1500000"),
                salario.value()
        );
    }

    @Test
    void noDebeAceptarSalarioNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Salario(null)
        );
    }

    @Test
    void noDebeAceptarSalarioNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Salario(new BigDecimal("-100"))
        );
    }

    @Test
    void debeAceptarSalarioCero() {
        Salario salario = new Salario(BigDecimal.ZERO);

        assertEquals(BigDecimal.ZERO, salario.value());
    }

    @Test
    void debeCompararSalariosCorrectamente() {
        Salario salario1 = new Salario(new BigDecimal("2000000"));
        Salario salario2 = new Salario(new BigDecimal("1500000"));

        assertTrue(salario1.esMayorOIgual(salario2));
        assertFalse(salario2.esMayorOIgual(salario1));
    }

    @Test
    void debeRechazarComparacionConSalarioNulo() {
        Salario salario = new Salario(new BigDecimal("1000000"));

        assertThrows(
                NullPointerException.class,
                () -> salario.esMayorOIgual(null)
        );
    }

    @Test
    void debeReconocerObjetosIguales() {
        Salario salario1 = new Salario(new BigDecimal("1500000"));
        Salario salario2 = new Salario(new BigDecimal("1500000"));

        assertEquals(salario1, salario2);
        assertEquals(salario1.hashCode(), salario2.hashCode());
    }

    @Test
    void debeReconocerIgualdadConDistintaEscalaDecimal() {
        Salario salario1 = new Salario(new BigDecimal("1500000.0"));
        Salario salario2 = new Salario(new BigDecimal("1500000.00"));

        assertEquals(salario1, salario2);
        assertEquals(salario1.hashCode(), salario2.hashCode());
    }

    @Test
    void noDebeConsiderarIgualesObjetosConDistintoSalario() {
        Salario salario1 = new Salario(new BigDecimal("1500000"));
        Salario salario2 = new Salario(new BigDecimal("2000000"));

        assertNotEquals(salario1, salario2);
    }

    @Test
    void noDebeConsiderarIgualUnObjetoDeOtraClase() {
        Salario salario = new Salario(new BigDecimal("1500000"));

        assertNotEquals(salario, "1500000");
    }

    @Test
    void debeReconocerElMismoObjeto() {
        Salario salario = new Salario(new BigDecimal("1500000"));

        assertEquals(salario, salario);
    }

    @Test
    void debeMostrarElSalarioComoTexto() {
        Salario salario = new Salario(new BigDecimal("1500000.00"));

        assertEquals("1500000.00", salario.toString());
    }
}
