package lesson5;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {

    @Test
    public void testFastPow(){
        assertEquals(100, Pow.tryFastPow(10, 2));
        assertEquals(10000, Pow.tryFastPow(10, 4));
        assertEquals(9, Pow.tryFastPow(3, 2));
        assertEquals(1024, Pow.tryFastPow(2, 10));
        assertEquals(49, Pow.tryFastPow(7, 2));
        assertEquals(81, Pow.tryFastPow(3, 4));

        assertEquals(7, Pow.tryFastPow(7, 1));
        assertEquals(27, Pow.tryFastPow(3, 3));

        assertEquals(9765625, Pow.tryFastPow(5, 10));
        assertEquals(1048576, Pow.tryFastPow(2, 20));
    }

    @Test
    public void testPow(){
        assertEquals(100, Pow.getPow(10, 2));
        assertEquals(10000, Pow.getPow(10, 4));
        assertEquals(9, Pow.getPow(3, 2));
        assertEquals(1024, Pow.getPow(2, 10));
        assertEquals(49, Pow.getPow(7, 2));
        assertEquals(81, Pow.getPow(3, 4));

        assertEquals(7, Pow.getPow(7, 1));
        assertEquals(27, Pow.getPow(3, 3));

        assertEquals(9765625, Pow.getPow(5, 10));
        assertEquals(1048576, Pow.getPow(2, 20));

        assertEquals(1048576, Pow.getPow(2, 20));
    }

}