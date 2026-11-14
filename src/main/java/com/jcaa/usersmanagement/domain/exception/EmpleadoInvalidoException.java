package com.jcaa.usersmanagement.domain.exception;


/**
 * Excepción para representar errores en los datos de un empleado.
 */
public class EmpleadoInvalidoException extends DomainException {

    public EmpleadoInvalidoException(String message) {
        super(message);
    }

    public EmpleadoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
