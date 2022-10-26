package hu.herpaipeter;

import java.util.Arrays;

public class RecentlyUsedList {

    int size = 0;
    String[] elements = new String[100];

    public int size() {
        return size;
    }

    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElementException();
        if (!find(elem))
            elements[size++] = elem;
    }

    private boolean find(String elem) {
        boolean found = false;
        for (int i = 0; i < size; i++)
            if (elements[i].equals(elem))
                found = true;
        return found;
    }

    public String first() {
        if (0 == size())
            throw new EmptyListException();
        return elements[size - 1];
    }

    public String last() {
        if (0 == size())
            throw new EmptyListException();
        return elements[0];
    }

    public String find(int i) {
        if (0 == size())
            throw new EmptyListException();
        if (i < 0 || size <= i)
            throw new IndexOutOfBoundsException();
        return elements[size - i - 1];
    }

    public static class InvalidListElementException extends RuntimeException {
    }

    public static class EmptyListException extends RuntimeException {
    }
}
