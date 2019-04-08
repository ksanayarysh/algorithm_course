package lesson3;

import java.util.NoSuchElementException;

public class MyArrayDequeue<Item> {
    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(start + i) % queue.length];
        }
        queue = tmp;
        start = 0;
        end = size;
    }

    public void insertRight(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[end++] = item;
        end %= queue.length;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start++;
        start %= queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public void insertLeft(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        if (--start== -1) start = queue.length - 1;
        queue[start] = item;
        //end %= queue.length;
        size++;
    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[end];
        queue[end] = null;
        size--;
        end--;
        if (end < 0) end = queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) queue[start];
    }

    public Item peekBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) queue[end];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(start + i) % queue.length] + ", ");

        }
        return s.toString();
    }}


