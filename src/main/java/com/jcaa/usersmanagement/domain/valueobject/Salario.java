
package com.jcaa.usersmanagement.domain.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Objeto de valor que representa el salario de un empleado.
 */
public final class Salario {

    private final BigDecimal value;

    public Salario(BigDecimal value) {
        if (value == null || value.signum() < 0) {
            throw new IllegalArgumentException(
                    "El salario no puede ser nulo ni negativo"
            );
        }

        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }

    public boolean esMayorOIgual(Salario otro) {
    Objects.requireNonNull(otro, "El salario a comparar es obligatorio");
    return value.compareTo(otro.value) >= 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Salario)) {
            return false;
        }

        Salario that = (Salario) other;
        return value.compareTo(that.value) == 0;
    }

    @Override
    public int hashCode() {
        return value.stripTrailingZeros().hashCode();
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}
