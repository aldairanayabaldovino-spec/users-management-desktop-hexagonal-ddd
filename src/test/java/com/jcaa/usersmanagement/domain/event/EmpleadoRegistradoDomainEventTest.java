
package com.jcaa.usersmanagement.domain.event;

import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoRegistradoDomainEventTest {

    @Test
    void debeCrearEventoConNombreCorrecto() {
        EmpleadoRegistradoDomainEvent evento =
                new EmpleadoRegistradoDomainEvent(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789"
                );

        assertEquals("EmpleadoRegistrado", evento.getEventName());
    }

    @Test
    void debeGenerarPayloadCorrecto() {
        EmpleadoRegistradoDomainEvent evento =
                new EmpleadoRegistradoDomainEvent(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789"
                );

        Map<String, String> datos = evento.payload();

        assertEquals("EMP-001", datos.get("empleadoId"));
        assertEquals("Aldair Anaya", datos.get("nombre"));
        assertEquals("123456789", datos.get("documento"));
    }

    @Test
    void debeRegistrarFechaDeOcurrencia() {
        EmpleadoRegistradoDomainEvent evento =
                new EmpleadoRegistradoDomainEvent(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789"
                );

        assertNotNull(evento.getOccurredOn());
    }
}
