package hu.herpaipeter;

import hu.herpaipeter.RecentlyUsedList.InvalidListElement;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RecentlyUsedListTest {

    @Test
    void initial_list_size_is_empty() {
        RecentlyUsedList list = new RecentlyUsedList();
        assertEquals(0, list.size());
    }

    @Test
    void add_null_or_empty_string_throws_exception() {
        RecentlyUsedList list = new RecentlyUsedList();
        assertThrowsExactly(InvalidListElement.class, () -> list.add(null));
        assertThrowsExactly(InvalidListElement.class, () -> list.add(""));
    }

    @Test
    void add_string_list_size_should_be_one() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("string");
        assertEquals(1, list.size());
    }
}
