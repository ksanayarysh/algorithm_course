package lesson2;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {
    private Object[] array = new Object[1];
    private int size = 0;

    public void add(Item item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size] = item;
        size++;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            remove(get(i));
        }
    }

    public void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) return false;
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        array[size - 1] = null;
        size--;
        return false;
    }

    public Item get(int Index) {
        if (Index < 0 || Index > size - 1)
            throw new ArrayIndexOutOfBoundsException();
        return (Item) array[Index];
    }

    public void set(Item item, int Index) {
        if (Index < 0 || Index > size - 1)
            throw new ArrayIndexOutOfBoundsException();
        array[Index] = item;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(array[i].toString() + ", ");
        }
        return s.toString();
    }

    private class MyArrayListIterator implements Iterator<Item> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) array[cursor];
            cursor++;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }

    private void exch(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) array[j], (Item) array[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) array[j], (Item) array[j - 1], cmp)) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }


    public void bubbleSort(Comparator<Item> cmp){
        int out, in;
        for (out = size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (!(less((Item) array[in], (Item) array[in + 1], cmp))) {
                    exch(in, in + 1);
                }
            }
        }
    }

    public void sort(SortType sortType){
        if (sortType == SortType.SELECTION) selectionSort(new UniversalComparator());
        if (sortType == SortType.INSERTION) insertionSort(new UniversalComparator());
        if (sortType == SortType.BUBBLE) bubbleSort(new UniversalComparator());
    }

}
