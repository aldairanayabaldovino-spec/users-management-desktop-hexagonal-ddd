
package com.jcaa.usersmanagement.infrastructure.adapter.persistence.memory;

import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoRepositoryMemoryTest {

    private EmpleadoRepositoryMemory repository;
    private EmpleadoModel empleado;

    @BeforeEach
    void setUp() {
        repository = new EmpleadoRepositoryMemory();

        empleado = new EmpleadoModel(
                "EMP-001",
                "Aldair",
                "123456789",
                "Auxiliar",
                new BigDecimal("1500000")
        );
    }

    @Test
    void shouldSaveEmpleado() {
        EmpleadoModel result = repository.save(empleado);

        assertEquals(empleado, result);
        assertTrue(repository.getById("EMP-001").isPresent());
    }

    @Test
    void shouldFindEmpleadoById() {
        repository.save(empleado);

        assertEquals(empleado,
                repository.getById("EMP-001").orElse(null));
    }

    @Test
    void shouldFindEmpleadoByDocumento() {
        repository.save(empleado);

        assertEquals(empleado,
                repository.getByDocumento("123456789").orElse(null));
    }

    @Test
    void shouldReturnAllEmpleados() {
        repository.save(empleado);

        assertEquals(1, repository.getAll().size());
    }

    @Test
    void shouldUpdateEmpleado() {
        repository.save(empleado);

        EmpleadoModel actualizado = new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "123456789",
                "Administrador",
                new BigDecimal("2000000")
        );

        repository.update(actualizado);

        assertEquals("Administrador",
                repository.getById("EMP-001").get().getCargo());
    }

    @Test
    void shouldDeleteEmpleado() {
        repository.save(empleado);

        repository.delete("EMP-001");

        assertFalse(repository.getById("EMP-001").isPresent());
    }
}
