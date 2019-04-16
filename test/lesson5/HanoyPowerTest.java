package lesson5;

import org.junit.Test;

import static org.junit.Assert.*;

public class HanoyPowerTest {

    @Test
    public void print() {
        HanoyPower.hanoi(5, 1, 2, 3);

        System.out.println(HanoyPower.cycle);
    }
}