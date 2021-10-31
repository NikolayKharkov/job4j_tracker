package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(2, 6);
        Point b = new Point(0, 6);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2, 0.001));
    }
}