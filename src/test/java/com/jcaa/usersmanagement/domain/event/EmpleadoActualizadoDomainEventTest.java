
package com.jcaa.usersmanagement.domain.event;

import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoActualizadoDomainEventTest {

    @Test
    void debeCrearEventoConNombreCorrecto() {
        EmpleadoActualizadoDomainEvent evento =
                new EmpleadoActualizadoDomainEvent(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789"
                );

        assertEquals("EmpleadoActualizado", evento.getEventName());
    }

    @Test
    void debeGenerarPayloadCorrecto() {
        EmpleadoActualizadoDomainEvent evento =
                new EmpleadoActualizadoDomainEvent(
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
        EmpleadoActualizadoDomainEvent evento =
                new EmpleadoActualizadoDomainEvent(
                        "EMP-001",
                        "Aldair Anaya",
                        "123456789"
                );

        assertNotNull(evento.getOccurredOn());
    }
}
