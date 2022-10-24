package hu.herpaipeter;

public class RecentlyUsedList {

    int size = 0;

    public int size() {
        return size;
    }

    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElement();
        size++;
    }

    public static class InvalidListElement extends RuntimeException {
    }

}
