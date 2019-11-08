package rational;

public class RationalApp {
    public static void main(String[] args){
        Rational r = new Rational((int) -Math.pow(2.0, 31.0), 1);
        Rational r1 = new Rational(-201, 1);
        System.out.println(r.plus(r1));
    }
}
