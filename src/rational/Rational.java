package rational;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new ArithmeticException("Divide by zero");
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public Rational plus(Rational b) {
        Rational result;
        int new_numerator;
        int new_denominator;
        if (this.denominator == b.getDenominator()) {
            new_numerator = this.numerator + b.getNumerator();
            if (this.numerator >= 0 && b.getNumerator() >= 0){
                assert this.numerator <= new_numerator: "Переполнение";
            }
            else if (this.numerator < 0 && b.getNumerator() < 0) {
                assert this.numerator > new_numerator: "Переполнение";
            }

            new_denominator = this.denominator;
        } else {
            new_numerator = this.numerator * b.getDenominator() + b.getNumerator() * this.denominator;
            new_denominator = this.denominator * b.getDenominator();
        }
        if (new_numerator == 0) {
            result = new Rational(0, 0);
            return result;
        }

        int divider = Evklid.GCD(new_numerator, new_denominator);
        if (divider != 1) {
            new_numerator /= divider;
            new_denominator /= divider;
        }
        result = new Rational(new_numerator, new_denominator);
        return result;
    }

    public Rational minus(Rational b) {
        Rational negative = new Rational(-b.getNumerator(), b.getDenominator());
        return plus(negative);
    }

    public Rational times(Rational b) {
        Rational result;
        int new_numerator = this.numerator * b.getNumerator();
        int new_denominator = this.denominator * b.getDenominator();
        result = new Rational(new_numerator, new_denominator);
        return result;
    }

    public Rational divides(Rational b) {
        Rational reverse = new Rational(b.getDenominator(), b.getNumerator());
        return times(reverse);
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        Rational that_ = (Rational) that;
        return this.numerator == that_.getNumerator() && this.denominator == that_.getDenominator();
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
