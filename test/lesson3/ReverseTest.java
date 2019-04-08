package lesson3;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {
    @Test
    public void testReverse(){
        Reverse r = new Reverse();
        String initialString = "Just in time";
        String rr = r.makeReverse(initialString);

        assertEquals("emit ni tsuJ", rr);
    }

}