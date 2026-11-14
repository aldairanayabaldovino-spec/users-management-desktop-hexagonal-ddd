/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;
import com.jcaa.usersmanagement.domain.model.EmpleadoModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.EmpleadoController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.EmpleadoResponsePrinter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class CreateEmpleadoHandlerTest {

    @Test
    void debeRegistrarEmpleadoCorrectamente() {

        String entrada = "EMP-001\nAldair Anaya\n123456\nAuxiliar\n1500000\n";
        ByteArrayOutputStream salida = new ByteArrayOutputStream();

        ConsoleIO console = new ConsoleIO(
                new Scanner(entrada),
                new PrintStream(salida)
        );

        EmpleadoController controller = mock(EmpleadoController.class);

        EmpleadoModel empleado = new EmpleadoModel(
                "EMP-001",
                "Aldair Anaya",
                "123456",
                "Auxiliar",
                new BigDecimal("1500000")
        );

        when(controller.create(any(EmpleadoModel.class)))
                .thenReturn(empleado);

        CreateEmpleadoHandler handler = new CreateEmpleadoHandler(
                controller,
                console,
                new EmpleadoResponsePrinter()
        );

        handler.handle();

        verify(controller).create(any(EmpleadoModel.class));
        assertTrue(salida.toString().contains("REGISTRAR EMPLEADO"));
    }

    @Test
    void debeRechazarSalarioNoNumerico() {

        String entrada = "EMP-001\nAldair Anaya\n123456\nAuxiliar\nabc\n";
        ByteArrayOutputStream salida = new ByteArrayOutputStream();

        ConsoleIO console = new ConsoleIO(
                new Scanner(entrada),
                new PrintStream(salida)
        );

        EmpleadoController controller = mock(EmpleadoController.class);

        CreateEmpleadoHandler handler = new CreateEmpleadoHandler(
                controller,
                console,
                new EmpleadoResponsePrinter()
        );

        assertThrows(NumberFormatException.class, handler::handle);

        verifyNoInteractions(controller);
    }
}