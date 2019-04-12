package lesson5;

public class HanoyPower {
    static int cycle = 1;

    public HanoyPower(int count) {
    }

    static void hanoi(int n, int from, int to, int additional) {
        cycle++;

        if (n == 0) return;

        hanoi(n - 1, from, additional, to);

        System.out.println(from + " " + to);

        hanoi(n - 1, additional, to, from);

    }
}
