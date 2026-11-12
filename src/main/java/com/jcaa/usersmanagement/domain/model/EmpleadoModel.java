
package com.jcaa.usersmanagement.domain.model;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class EmpleadoModel {

    private final String id;
    private final String nombre;
    private final String documento;
    private final String cargo;
    private final BigDecimal salario;

    public EmpleadoModel(
            String id,
            String nombre,
            String documento,
            String cargo,
            BigDecimal salario) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }

        if (cargo == null || cargo.isBlank()) {
            throw new IllegalArgumentException("El cargo es obligatorio");
        }

        if (salario == null || salario.signum() < 0) {
            throw new IllegalArgumentException("El salario no puede ser nulo ni negativo");
        }

        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.cargo = cargo;
        this.salario = salario;
    }
}
