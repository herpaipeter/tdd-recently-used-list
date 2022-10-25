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

    @Test
    void most_recently_added_should_be_the_first() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("string");
        assertEquals("string", list.first());
    }

    @Test
    void add_two_element_the_most_recently_added_should_be_the_first() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element one");
        list.add("element two");
        assertEquals("element two", list.first());
    }

    @Test
    void add_two_element_the_least_recently_added_should_be_the_last() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element one");
        list.add("element two");
        assertEquals("element one", list.last());
    }

    @Test
    void find_by_index_0_should_return_the_first_element() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element one");
        list.add("element two");
        list.add("element three");
        assertEquals("element three", list.find(0));
    }

    @Test
    void find_by_index_1_should_return_the_second_element() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element one");
        list.add("element two");
        list.add("element three");
        assertEquals("element two", list.find(1));
    }
}
