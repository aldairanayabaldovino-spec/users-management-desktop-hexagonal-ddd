package com.jcaa.usersmanagement.domain.valueobject;


import java.util.Objects;

/**
 * Esto es un objeto de valor que representa el documento de un empleado.
 */
public final class DocumentoEmpleado {

    private final String value;

    public DocumentoEmpleado(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "El documento es obligatorio"
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

        if (!(other instanceof DocumentoEmpleado)) {
            return false;
        }

        DocumentoEmpleado that = (DocumentoEmpleado) other;
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
