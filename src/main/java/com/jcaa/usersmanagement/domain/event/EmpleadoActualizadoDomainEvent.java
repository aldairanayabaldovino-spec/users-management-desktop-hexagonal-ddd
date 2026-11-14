
package com.jcaa.usersmanagement.domain.event;

import java.util.HashMap;
import java.util.Map;

public class EmpleadoActualizadoDomainEvent extends DomainEvent {

    private final String empleadoId;
    private final String nombre;
    private final String documento;

    public EmpleadoActualizadoDomainEvent(
            String empleadoId,
            String nombre,
            String documento
    ) {
        super("EmpleadoActualizado");

        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.documento = documento;
    }

    @Override
    public Map<String, String> payload() {
        Map<String, String> datos = new HashMap<>();

        datos.put("empleadoId", empleadoId);
        datos.put("nombre", nombre);
        datos.put("documento", documento);

        return datos;
    }
}
