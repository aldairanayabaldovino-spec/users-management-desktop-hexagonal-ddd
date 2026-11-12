
package com.jcaa.usersmanagement.infrastructure.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception.PersistenceException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.UserController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.EmpleadoController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("DependencyContainer")
@ExtendWith(MockitoExtension.class)
class DependencyContainerTest {

    @Mock
    private Connection mockConnection;

    @Test
    @DisplayName("Debe crear correctamente el controlador de usuarios")
    void shouldWireAllDependenciesAndExposeNonNullUserController() {
        try (final MockedStatic<DriverManager> mockedDriverManager =
                mockStatic(DriverManager.class)) {

            mockedDriverManager
                    .when(() -> DriverManager.getConnection(
                            any(String.class), any(String.class), any(String.class)))
                    .thenReturn(mockConnection);

            final DependencyContainer container = new DependencyContainer();

            assertNotNull(container.userController());
        }
    }

    @Test
    @DisplayName("Debe mantener la misma instancia del controlador de usuarios")
    void shouldReturnTheSameUserControllerInstanceOnEveryCall() {
        try (final MockedStatic<DriverManager> mockedDriverManager =
                mockStatic(DriverManager.class)) {

            mockedDriverManager
                    .when(() -> DriverManager.getConnection(
                            any(String.class), any(String.class), any(String.class)))
                    .thenReturn(mockConnection);

            final DependencyContainer container = new DependencyContainer();

            final UserController first = container.userController();
            final UserController second = container.userController();

            assertSame(first, second);
        }
    }

    @Test
    @DisplayName("Debe crear correctamente el controlador de empleados")
    void shouldExposeNonNullEmpleadoController() {
        try (final MockedStatic<DriverManager> mockedDriverManager =
                mockStatic(DriverManager.class)) {

            mockedDriverManager
                    .when(() -> DriverManager.getConnection(
                            any(String.class), any(String.class), any(String.class)))
                    .thenReturn(mockConnection);

            final DependencyContainer container = new DependencyContainer();

            assertNotNull(container.empleadoController());
        }
    }

    @Test
    @DisplayName("Debe mantener la misma instancia del controlador de empleados")
    void shouldReturnTheSameEmpleadoControllerInstanceOnEveryCall() {
        try (final MockedStatic<DriverManager> mockedDriverManager =
                mockStatic(DriverManager.class)) {

            mockedDriverManager
                    .when(() -> DriverManager.getConnection(
                            any(String.class), any(String.class), any(String.class)))
                    .thenReturn(mockConnection);

            final DependencyContainer container = new DependencyContainer();

            final EmpleadoController first = container.empleadoController();
            final EmpleadoController second = container.empleadoController();

            assertSame(first, second);
        }
    }

    @Test
    @DisplayName("Debe propagar el error cuando falla la conexión a la base de datos")
    void shouldPropagatePersistenceExceptionWhenDatabaseConnectionFails() {
        final SQLException cause = new SQLException("Connection refused");

        try (final MockedStatic<DriverManager> mockedDriverManager =
                mockStatic(DriverManager.class)) {

            mockedDriverManager
                    .when(() -> DriverManager.getConnection(
                            any(String.class), any(String.class), any(String.class)))
                    .thenThrow(cause);

            assertThrows(
                    PersistenceException.class,
                    DependencyContainer::new
            );
        }
    }
}
