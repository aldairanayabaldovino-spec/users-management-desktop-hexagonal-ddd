
package com.jcaa.usersmanagement.domain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import com.jcaa.usersmanagement.domain.exception.InvalidUserPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserPasswordTest {

    @ParameterizedTest
    @ValueSource(strings = {"password123", "   password123   "})
    @DisplayName("Normaliza y aplica hash a la contraseña")
    void shouldNormalizeAndHashPassword(final String input) {
        final UserPassword result = UserPassword.fromPlainText(input);

        assertNotNull(result.value());
        assertNotEquals(input.trim(), result.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"clave", "    clave     "})
    @DisplayName("Rechaza contraseñas con menos de 8 caracteres")
    void shouldFailWhenPasswordIsTooShort(final String password) {
        assertThrows(
                InvalidUserPasswordException.class,
                () -> UserPassword.fromPlainText(password)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "\r", "\t", "\n", "\f", "\b", "\0"})
    @DisplayName("Rechaza contraseñas vacías")
    void shouldThrowWhenPasswordIsEmptyOrBlank(final String password) {
        assertThrows(
                InvalidUserPasswordException.class,
                () -> UserPassword.fromPlainText(password)
        );
    }

    @Test
    @DisplayName("Rechaza contraseña nula")
    void shouldThrowWhenPasswordIsNull() {
        assertThrows(
                NullPointerException.class,
                () -> UserPassword.fromPlainText(null)
        );
    }

    @Test
    @DisplayName("Verifica correctamente la contraseña original")
    void shouldVerifyPlainPassword() {
        final String plainPassword = "mySecurePassword";
        final UserPassword userPassword =
                UserPassword.fromPlainText(plainPassword);

        assertTrue(userPassword.verifyPlain(plainPassword));
    }

    @Test
    @DisplayName("Rechaza una contraseña incorrecta")
    void shouldRejectIncorrectPlainPassword() {
        final UserPassword userPassword =
                UserPassword.fromPlainText("mySecurePassword");

        assertFalse(userPassword.verifyPlain("AnotherPassword123"));
    }

    @Test
    @DisplayName("Crea un objeto desde un hash existente")
    void shouldCreateUserPasswordFromExistingHash() {
        final String rawPassword = "Abcde1234567";
        final UserPassword original =
                UserPassword.fromPlainText(rawPassword);

        final UserPassword fromHash =
                UserPassword.fromHash(original.value());

        assertEquals(original, fromHash);
        assertTrue(fromHash.verifyPlain(rawPassword));
    }

    @Test
    @DisplayName("equals: retorna true cuando es la misma referencia")
    void shouldReturnTrueWhenSameReference() {
        final UserPassword password =
                UserPassword.fromPlainText("MiPassword123");

        assertEquals(password, password);
    }

    @Test
    @DisplayName("equals: retorna false cuando el argumento no es UserPassword")
    void shouldReturnFalseWhenOtherIsNotInstanceOfUserPassword() {
        final UserPassword password =
                UserPassword.fromPlainText("MiPassword123");

        assertNotEquals(password, new Object());
    }

    @Test
    @DisplayName("equals: retorna false cuando los hashes son diferentes")
    void shouldReturnFalseWhenDifferentHash() {
        final UserPassword a =
                UserPassword.fromPlainText("MiPassword123");
        final UserPassword b =
                UserPassword.fromPlainText("OtroPassword456");

        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("hashCode: es consistente para la misma instancia")
    void shouldReturnConsistentHashCode() {
        final UserPassword password =
                UserPassword.fromPlainText("MiPassword123");

        assertEquals(password.hashCode(), password.hashCode());
    }

    @Test
    @DisplayName("Objetos iguales tienen el mismo hashCode")
    void shouldHaveSameHashCodeWhenEqual() {
        final UserPassword a =
                UserPassword.fromPlainText("MiPassword123");
        final UserPassword b =
                UserPassword.fromHash(a.value());

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}
