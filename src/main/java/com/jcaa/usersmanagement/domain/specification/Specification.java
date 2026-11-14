
package com.jcaa.usersmanagement.domain.specification;

/**
 * Interfaz genérica para definir reglas de negocio.
 *
 * @param <T> tipo de objeto que se desea evaluar.
 */
@FunctionalInterface
public interface Specification<T> {

    boolean isSatisfiedBy(T candidate);
}
