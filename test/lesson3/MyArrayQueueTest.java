package lesson3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayQueueTest {
    MyArrayQueue<Integer> queue;

    @Before
    public void before() {
        queue = new MyArrayQueue<>();
    }

    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.getSize());

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        assertEquals(5, queue.getSize());
        System.out.println(queue);

    }

}