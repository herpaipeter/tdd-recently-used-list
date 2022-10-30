package hu.herpaipeter;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {

    private final static int DEFAULT_CAPACITY = 100;

    final int capacity;
    List<String> elements;

    public RecentlyUsedList() {
        capacity = DEFAULT_CAPACITY;
        elements = new ArrayList<>(capacity);
    }

    public RecentlyUsedList(int capacity) {
        if (capacity < 1)
            throw new InvalidCapacityException();
        this.capacity = capacity;
        elements = new ArrayList<>(this.capacity);
    }

    public int size() {
        return elements.size();
    }
    public int getCapacity() {
        return capacity;
    }


    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElementException();
        int index = elements.indexOf(elem);
        if (-1 == index) {
            shiftOutLastOverCapacity();
            elements.add(elem);
        }
        else
            moveToTop(index);
    }

    private void shiftOutLastOverCapacity() {
        if (capacity <= elements.size())
            elements = elements.subList(1, elements.size());
    }

    private void moveToTop(int index) {
        String element = elements.get(index);
        elements.remove(index);
        elements.add(element);
    }

    public String first() {
        if (0 == size())
            throw new EmptyListException();
        return elements.get(elements.size() - 1);
    }

    public String last() {
        if (0 == size())
            throw new EmptyListException();
        return elements.get(0);
    }

    public String find(int i) {
        if (0 == size())
            throw new EmptyListException();
        if (i < 0 || elements.size() <= i)
            throw new IndexOutOfBoundsException();
        return elements.get(elements.size() - i - 1);
    }

    public static class InvalidListElementException extends RuntimeException {
    }

    public static class EmptyListException extends RuntimeException {
    }

    public static class InvalidCapacityException extends RuntimeException {
    }
}
