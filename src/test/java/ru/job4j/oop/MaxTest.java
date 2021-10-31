package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class MaxTest extends TestCase {

    @Test
    public void testWhen2Nums() {
        Max max = new Max();
        int exp = 6;
        int rsl = max.max(5, 6);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void testWhen3Nums() {
        Max max = new Max();
        int exp = 9;
        int rsl = max.max(5, 6, 9);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void testWhen4Nums() {
        Max max = new Max();
        int exp = -1;
        int rsl = max.max(-100, -2, -7, -1);
        Assert.assertEquals(exp, rsl);
    }
}