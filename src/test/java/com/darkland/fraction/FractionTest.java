package com.darkland.fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void plus() {
        Fraction fraction = new Fraction(2, 5);
        Fraction fraction1 = new Fraction(3, 9);
        Fraction fraction2 = fraction.plus(fraction1);
        assertEquals(11, fraction2.getNumerator());
        assertEquals(15, fraction2.getDenominator());
    }

    @Test
    void minus() {
        Fraction fraction = new Fraction(2, 5);
        Fraction fraction1 = new Fraction(3, 9);
        Fraction fraction2 = fraction.minus(fraction1);
        assertEquals(1, fraction2.getNumerator());
        assertEquals(15, fraction2.getDenominator());
    }

    @Test
    void multiply() {
        Fraction fraction = new Fraction(2, 5);
        Fraction fraction1 = new Fraction(3, 9);
        Fraction fraction2 = fraction.multiply(fraction1);
        assertEquals(2, fraction2.getNumerator());
        assertEquals(15, fraction2.getDenominator());
    }

    @Test
    void divide() {
        Fraction fraction = new Fraction(2, 5);
        Fraction fraction1 = new Fraction(3, 9);
        Fraction fraction2 = fraction.divide(fraction1);
        assertEquals(6, fraction2.getNumerator());
        assertEquals(5, fraction2.getDenominator());
    }

    @Test
    void notNull() {
        Fraction fraction = new Fraction(2, 11);
        assertNotNull(fraction);
    }

    @Test
    void notNullNumerator() {
        Fraction fraction = new Fraction(2, 3);
        assertNotNull(fraction.getNumerator());
    }

    @Test
    void notNullDenominator() {
        Fraction fraction = new Fraction(2, 3);
        assertNotNull(fraction.getDenominator());
    }

    @Test
    void denominatorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fraction fraction = new Fraction(2, 0);
        });
    }

    @Test
    void denominatorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fraction fraction = new Fraction(2, null);
        });
    }

    @Test
    void numeratorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fraction fraction = new Fraction(null, 3);
        });
    }
}