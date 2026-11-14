
package com.jcaa.usersmanagement.domain.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoEmpleadoTest {

    @Test
    void debeCrearDocumentoValido() {
        DocumentoEmpleado documento =
                new DocumentoEmpleado("123456789");

        assertEquals("123456789", documento.value());
    }

    @Test
    void debeEliminarEspaciosAlCrearDocumento() {
        DocumentoEmpleado documento =
                new DocumentoEmpleado("  123456789  ");

        assertEquals("123456789", documento.value());
    }

    @Test
    void noDebeAceptarDocumentoNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DocumentoEmpleado(null)
        );
    }

    @Test
    void noDebeAceptarDocumentoVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DocumentoEmpleado("")
        );
    }

    @Test
    void noDebeAceptarDocumentoConEspacios() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DocumentoEmpleado("   ")
        );
    }

    @Test
    void debeReconocerObjetosIguales() {
        DocumentoEmpleado documento1 =
                new DocumentoEmpleado("123456789");
        DocumentoEmpleado documento2 =
                new DocumentoEmpleado("123456789");

        assertEquals(documento1, documento2);
        assertEquals(documento1.hashCode(), documento2.hashCode());
    }

    @Test
    void noDebeConsiderarIgualesDocumentosDiferentes() {
        DocumentoEmpleado documento1 =
                new DocumentoEmpleado("123456789");
        DocumentoEmpleado documento2 =
                new DocumentoEmpleado("987654321");

        assertNotEquals(documento1, documento2);
    }

    @Test
    void noDebeConsiderarIgualUnObjetoDeOtraClase() {
        DocumentoEmpleado documento =
                new DocumentoEmpleado("123456789");

        assertNotEquals(documento, "123456789");
    }

    @Test
    void debeReconocerElMismoObjeto() {
        DocumentoEmpleado documento =
                new DocumentoEmpleado("123456789");

        assertEquals(documento, documento);
    }

    @Test
    void debeMostrarElDocumentoComoTexto() {
        DocumentoEmpleado documento =
                new DocumentoEmpleado("123456789");

        assertEquals("123456789", documento.toString());
    }
}
