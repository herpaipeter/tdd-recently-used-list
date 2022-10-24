package hu.herpaipeter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RecentlyUsedListTest {

    @Test
    void initial_list_size_is_empty() {
        RecentlyUsedList list = new RecentlyUsedList();
        assertEquals(0, list.size());
    }
}
