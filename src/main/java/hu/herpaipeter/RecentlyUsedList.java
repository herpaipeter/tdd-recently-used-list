package hu.herpaipeter;

public class RecentlyUsedList {

    public int size() {
        return 0;
    }

    public void add(String elem) {
        if (elem == null || elem.isEmpty())
            throw new InvalidListElement();
    }

    public static class InvalidListElement extends RuntimeException {
    }

}
