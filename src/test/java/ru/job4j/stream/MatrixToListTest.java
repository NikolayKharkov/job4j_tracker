package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void testToList() {
        Integer[][] input = {{1, 8, 3}, {0, 8, -1}};
        List<Integer> expected = List.of(1, 8, 3, 0, 8, -1);
        List<Integer> result = MatrixToList.toList(input);
        assertThat(result, is(expected));
    }
}