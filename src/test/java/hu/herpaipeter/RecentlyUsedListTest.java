package hu.herpaipeter;

import hu.herpaipeter.RecentlyUsedList.EmptyListException;
import hu.herpaipeter.RecentlyUsedList.InvalidListElementException;
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
        assertThrowsExactly(InvalidListElementException.class, () -> list.add(null));
        assertThrowsExactly(InvalidListElementException.class, () -> list.add(""));
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

    @Test
    void find_index_out_of_bound_throws_exception() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element one");
        list.add("element two");
        list.add("element three");
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.find(3));
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.find(-1));
    }

    @Test
    void first_last_on_empty_list_throws_exception() {
        RecentlyUsedList list = new RecentlyUsedList();
        assertThrowsExactly(EmptyListException.class, list::first);
        assertThrowsExactly(EmptyListException.class, list::last);
    }

    @Test
    void items_should_be_unique_same_items_count_once() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("element");
        list.add("element");
        list.add("element");
        assertEquals(1, list.size());
    }
}
