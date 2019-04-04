package lesson3;

import lesson2.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayStackTest {
    MyArrayStack<Integer> stack;

    @Before
    public void before(){
        stack = new MyArrayStack<>();
    }


    @Test
    public void getSize() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.getSize());
    }

    @Test
    public void isEmplty() {
        assertEquals(0, stack.getSize());
    }

    @Test
    public void push() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.getSize());
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        assertEquals(5, stack.getSize());
        assertEquals((Integer) 4, stack.peek());
    }

}