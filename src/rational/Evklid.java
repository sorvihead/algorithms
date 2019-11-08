package rational;

public class Evklid {
    public static int GCD(int a, int b){
        if (b == 0){
            return a;
        }
        int r = a % b;
        return GCD(b, r);
    }
}
