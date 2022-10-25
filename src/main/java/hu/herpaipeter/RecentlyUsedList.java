package hu.herpaipeter;

public class RecentlyUsedList {

    int size = 0;
    String element = "";

    public int size() {
        return size;
    }

    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElement();
        element = elem;
        size++;
    }

    public String first() {
        return element;
    }

    public static class InvalidListElement extends RuntimeException {
    }

}
