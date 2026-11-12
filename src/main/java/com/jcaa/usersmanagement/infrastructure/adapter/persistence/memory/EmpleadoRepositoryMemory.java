package com.jcaa.usersmanagement.infrastructure.adapter.persistence.memory;


import com.jcaa.usersmanagement.application.port.out.DeleteEmpleadoPort;
import com.jcaa.usersmanagement.application.port.out.GetAllEmpleadosPort;
import com.jcaa.usersmanagement.application.port.out.GetEmpleadoByDocumentoPort;
import com.jcaa.usersmanagement.application.port.out.GetEmpleadoByIdPort;
import com.jcaa.usersmanagement.application.port.out.SaveEmpleadoPort;
import com.jcaa.usersmanagement.application.port.out.UpdateEmpleadoPort;
import com.jcaa.usersmanagement.domain.model.EmpleadoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmpleadoRepositoryMemory implements
        SaveEmpleadoPort,
        UpdateEmpleadoPort,
        GetEmpleadoByIdPort,
        GetEmpleadoByDocumentoPort,
        GetAllEmpleadosPort,
        DeleteEmpleadoPort {

    private final Map<String, EmpleadoModel> empleados = new HashMap<>();

    @Override
    public EmpleadoModel save(EmpleadoModel empleado) {
        empleados.put(empleado.getId(), empleado);
        return empleado;
    }

    @Override
    public EmpleadoModel update(EmpleadoModel empleado) {
        empleados.put(empleado.getId(), empleado);
        return empleado;
    }

    @Override
    public Optional<EmpleadoModel> getById(String id) {
        return Optional.ofNullable(empleados.get(id));
    }

    @Override
    public Optional<EmpleadoModel> getByDocumento(String documento) {
        return empleados.values().stream()
                .filter(empleado -> empleado.getDocumento().equals(documento))
                .findFirst();
    }

    @Override
    public List<EmpleadoModel> getAll() {
        return new ArrayList<>(empleados.values());
    }

    @Override
    public void delete(String id) {
        empleados.remove(id);
    }
}
