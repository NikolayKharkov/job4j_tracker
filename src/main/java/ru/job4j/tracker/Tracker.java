package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int cnt = 0;
        Item[] result = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i] != null) {
                result[cnt] = items[i];
                cnt++;
            }
        }
        return Arrays.copyOf(result, cnt);
    }

    public Item[] findByName(String key) {
        int cnt = 0;
        Item[] result = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                result[cnt] = items[i];
                cnt++;
            }
        }
        return Arrays.copyOf(result, cnt);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = true;
        int index = indexOf(id);
        if (index == -1) {
            result = false;
        } else {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }
}