package lesson3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class MyArrayDequeueTest {
    MyArrayDequeue<Integer> dequeue;

    @Before
    public void setUp() {
        dequeue = new MyArrayDequeue<>();
    }

    @Test
    public void testRightRight() {
        for (int i = 0; i < 10; i++) {
            dequeue.insertRight(i);
        }

        assertEquals(10, dequeue.getSize());

        for (int i = 0; i < 10; i++) {
            dequeue.removeRight();
        }
    }

    @Test
    public void testLeftLeft() {
        for (int i = 0; i < 10; i++) {
            dequeue.insertLeft(i);
        }

        assertEquals(10, dequeue.getSize());

        for (int i = 0; i < 10; i++) {
            dequeue.removeLeft();
        }
    }

    @Test
    public void testRightLeft() {
        for (int i = 0; i < 10; i++) {
            dequeue.insertRight(i);
        }

        assertEquals(10, dequeue.getSize());

        for (int i = 0; i < 10; i++) {
            dequeue.removeLeft();
        }

    }

    @Test
    public void testLeftRight() {
        for (int i = 0; i < 10; i++) {
            dequeue.insertLeft(i);
        }

        assertEquals(10, dequeue.getSize());

        for (int i = 0; i < 10; i++) {
            dequeue.removeRight();
        }

    }

}