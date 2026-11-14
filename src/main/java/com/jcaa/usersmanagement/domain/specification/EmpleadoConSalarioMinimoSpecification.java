
package com.jcaa.usersmanagement.domain.specification;

import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Comprueba si el salario de un empleado cumple
 * con un mínimo definido por quien utiliza la regla.
 */
public class EmpleadoConSalarioMinimoSpecification
        implements Specification<EmpleadoModel> {

    private final BigDecimal salarioMinimo;

    public EmpleadoConSalarioMinimoSpecification(
            BigDecimal salarioMinimo
    ) {
        Objects.requireNonNull(
                salarioMinimo,
                "El salario mínimo es obligatorio"
        );

        if (salarioMinimo.signum() < 0) {
            throw new IllegalArgumentException(
                    "El salario mínimo no puede ser negativo"
            );
        }

        this.salarioMinimo = salarioMinimo;
    }

    @Override
    public boolean isSatisfiedBy(EmpleadoModel empleado) {
        if (empleado == null) {
            return false;
        }

        return empleado.getSalario().compareTo(salarioMinimo) >= 0;
    }
}
