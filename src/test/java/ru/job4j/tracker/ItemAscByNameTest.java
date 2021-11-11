package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest {
    @Test
    public void whenDesc() {
        List<Item> items = Arrays.asList(
                new Item("Fix bugs", 100),
                new Item("Ampl task", 9),
                new Item("Zeboot server", -1),
                new Item("Abboot", 69)
        );
        List<Item> expected = Arrays.asList(
                new Item("Abboot", 69),
                new Item("Ampl task", 9),
                new Item("Fix bugs", 100),
                new Item("Zeboot server", -1)
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items.get(0).getName(), is("Abboot"));
    }
}