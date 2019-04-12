package lesson5;

public class Pow {

    public static long getPow(long number, int p){
        if (p == 1) {
            return number;
        } else {
            return number * getPow(number, --p);
        }
    }

    public static long tryFastPow(long number, int p){
        if (p % 2 == 0) {
            p = p / 2;
            long result = getPow(number, p);
            result *= result;
            return result;
        } else return getPow(number, p);
    }


}
