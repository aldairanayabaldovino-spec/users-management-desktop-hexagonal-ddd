
package com.jcaa.usersmanagement.domain.valueobject;

import java.util.Objects;

/**
 * Objeto de valor que representa el cargo de un empleado.
 */
public final class CargoEmpleado {

    private final String value;

    public CargoEmpleado(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "El cargo es obligatorio"
            );
        }

        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof CargoEmpleado)) {
            return false;
        }

        CargoEmpleado that = (CargoEmpleado) other;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
