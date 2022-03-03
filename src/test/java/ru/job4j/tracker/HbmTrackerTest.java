package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {

    private HbmTracker store = new HbmTracker();

    @Test
    public void whenAdd() {
        Item item = new Item("item1", "desc1");
        store.add(item);
        List<Item> all = store.findAll();
        assertEquals(item, all.get(0));
    }

    @Test
    public void whenAddThenFindById() {
        Item item = new Item("item1", "desc1");
        store.add(item);
        assertEquals(item, store.findById(1));
    }

    @Test
    public void whenAddFewItemsThenFindByName() {
        Item item1 = new Item("item1", "desc1");
        Item item2 = new Item("item2", "desc2");
        Item item3 = new Item("item1", "desc3");
        store.add(item1);
        store.add(item2);
        store.add(item3);
        List<Item> byName = store.findByName("item1");
        List<Item> expected = new ArrayList<>(Arrays.asList(item1, item3));
        assertEquals(byName, expected);
    }

    @Test
    public void whenAddThenDelete() {
        store.add(new Item("item1", "desc1"));
        store.delete(1);
        assertNull(store.findById(1));
    }

    @Test
    public void whenAddThenReplace() {
        Item replaced = new Item("replaced_name", "replaced_desc");
        store.add(new Item("item1", "desc1"));
        store.replace(1, replaced);
        assertEquals(replaced, store.findById(1));
    }
}