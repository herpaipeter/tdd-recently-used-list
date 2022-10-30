package hu.herpaipeter;

public class RecentlyUsedList {

    private final static int DEFAULT_CAPACITY = 100;

    int size = 0;
    final int capacity;
    String[] elements;

    public RecentlyUsedList() {
        capacity = DEFAULT_CAPACITY;
        elements = new String[capacity];
    }

    public RecentlyUsedList(int capacity) {
        if (capacity < 1)
            throw new InvalidCapacityException();
        this.capacity = capacity;
        elements = new String[capacity];
    }

    public int size() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }


    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElementException();
        if (capacity <= size) {
            System.arraycopy(elements, 1, elements, 0, size() - 1);
            elements[size - 1] = null;
            size--;
        }
        int index = find(elem);
        if (-1 == index)
            elements[size++] = elem;
        else
            moveToTop(index);
    }

    private void moveToTop(int index) {
        String element = elements[index];
        if (size() - 1 - index >= 0)
            System.arraycopy(elements, index + 1, elements, index, size() - 1 - index);
        elements[size() - 1] = element;
    }

    private int find(String elem) {
        int foundIndex = -1;
        for (int i = 0; i < size && foundIndex == -1; i++)
            if (elements[i].equals(elem))
                foundIndex = i;
        return foundIndex;
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

    public static class InvalidCapacityException extends RuntimeException {
    }
}
