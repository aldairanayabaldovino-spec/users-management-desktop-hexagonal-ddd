
package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.valueobject.CargoEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.DocumentoEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.NombreEmpleado;
import com.jcaa.usersmanagement.domain.valueobject.Salario;

import java.math.BigDecimal;

/**
 * Entidad de dominio que representa un empleado.
 */
public class EmpleadoModel {

    private final String id;
    private final NombreEmpleado nombre;
    private final DocumentoEmpleado documento;
    private final CargoEmpleado cargo;
    private final Salario salario;

    public EmpleadoModel(
            String id,
            String nombre,
            String documento,
            String cargo,
            BigDecimal salario
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        this.id = id.trim();
        this.nombre = new NombreEmpleado(nombre);
        this.documento = new DocumentoEmpleado(documento);
        this.cargo = new CargoEmpleado(cargo);
        this.salario = new Salario(salario);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre.value();
    }

    public String getDocumento() {
        return documento.value();
    }

    public String getCargo() {
        return cargo.value();
    }

    public BigDecimal getSalario() {
        return salario.value();
    }

    public NombreEmpleado getNombreValueObject() {
        return nombre;
    }

    public DocumentoEmpleado getDocumentoValueObject() {
        return documento;
    }

    public CargoEmpleado getCargoValueObject() {
        return cargo;
    }

    public Salario getSalarioValueObject() {
        return salario;
    }
}
