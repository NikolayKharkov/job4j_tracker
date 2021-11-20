package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {
    @Test
    public void testToMap() {
        Map<String, Student> expected = new HashMap<>(
                Map.of("Ivanov", new Student(69, "Ivanov"),
                        "Ksenia", new Student(84, "Ksenia"))
        );
        List<Student> orgList = List.of(
                new Student(69, "Ivanov"),
                new Student(84, "Ksenia"),
                new Student(69, "Ivanov"));

        ListToMap lmt = new ListToMap();
        Map<String, Student> result = lmt.toMap(orgList);
        assertThat(result, is(expected));
    }
}