package hu.herpaipeter;

public class RecentlyUsedList {

    int size = 0;
    String[] elements = new String[100];

    public int size() {
        return size;
    }

    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElement();
        elements[size++] = elem;
    }

    public String first() {
        return 0 < size ? elements[size - 1] : "";
    }

    public String last() {
        return 0 < size ? elements[0] : "";
    }

    public static class InvalidListElement extends RuntimeException {
    }

}