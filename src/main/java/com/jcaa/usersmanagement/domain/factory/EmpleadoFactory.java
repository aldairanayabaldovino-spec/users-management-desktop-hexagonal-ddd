package com.jcaa.usersmanagement.domain.factory;


import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import java.math.BigDecimal;

/**
 * Factory encargada de crear empleados.
 */
public class EmpleadoFactory {

    public EmpleadoModel crear(
            String id,
            String nombre,
            String documento,
            String cargo,
            BigDecimal salario
    ) {
        return new EmpleadoModel(
                id,
                nombre,
                documento,
                cargo,
                salario
        );
    }
}
