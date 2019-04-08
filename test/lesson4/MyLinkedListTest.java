package lesson4;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void iterator() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        for (int i = 0; i < 300; i++) {
            linked.addLast(i);
        }

        Iterator<Integer> iterator = linked.iterator();
        for (int i = 0; i < 300; i++) {
            assert iterator.next() == i;
        }

        assert !iterator.hasNext();
    }
}