package com.darkland.fraction;

import lombok.Getter;


@Getter
public class Fraction implements IFraction{
    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) throws IllegalArgumentException {
        if(denominator == 0)
        {
            throw new IllegalArgumentException("denominator must not be 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Fraction plus(Fraction fraction) {
        Integer newDenominator = lcm(this.denominator, fraction.getDenominator());
        Integer newNumerator = ((lcm(newDenominator, this.denominator) / this.denominator) * this.numerator) +
                ((lcm(newDenominator, fraction.denominator) / fraction.denominator) * fraction.numerator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction = tryToReduceFraction(newFraction);
        return newFraction;
    }

    @Override
    public Fraction minus(Fraction fraction) {
        Integer newDenominator = lcm(this.denominator, fraction.getDenominator());
        Integer newNumerator = ((lcm(newDenominator, this.denominator) / this.denominator) * this.numerator) -
                ((lcm(newDenominator, fraction.denominator) / fraction.denominator) * fraction.numerator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction = tryToReduceFraction(newFraction);
        return newFraction;
    }

    @Override
    public Fraction multiply(Fraction fraction) {
        Integer newNumerator = this.numerator * fraction.getNumerator();
        Integer newDenominator = this.denominator * fraction.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        newFraction = tryToReduceFraction(newFraction);
        return newFraction;
    }

    @Override
    public Fraction divide(Fraction fraction) {
        Fraction reverseFraction = new Fraction(fraction.getDenominator(), fraction.getNumerator());
        return this.multiply(reverseFraction);
    }

    private Integer gcd(Integer a, Integer b){
        return b == 0 ? a : gcd(b,a % b);
    }

    private Integer lcm(Integer a,Integer b){
        return a * b / gcd(a,b);
    }

    private Fraction tryToReduceFraction(Fraction fraction)
    {
        Integer numerator = fraction.getNumerator();
        Integer denominator = fraction.getDenominator();
        Integer gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return new Fraction(numerator, denominator);
    }
}
