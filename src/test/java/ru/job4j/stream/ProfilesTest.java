package ru.job4j.stream;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void testWhenSuccessfully() {
        Profiles pf = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 27, 16)),
                new Profile(new Address("New York", "Central Park", 49, 51))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Red Square", 27, 16),
                new Address("New York", "Central Park", 49, 51)
        );
        List<Address> result = pf.collect(profiles);
        assertThat(result, is(expected));
    }

    @Test
    public void testWhenFail() {
        Profiles pf = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 27, 16)),
                new Profile(new Address("New York", "Central Park", 49, 51))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Red Square", 27, 16)
        );
        List<Address> result = pf.collect(profiles);
        assertNotEquals(expected, result);
    }

    @Test
    public void testWhenUniqueSuccessfully() {
        Profiles pf = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 27, 16)),
                new Profile(new Address("Moscow", "Red Square", 27, 16))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Red Square", 27, 16)
        );
        List<Address> result = pf.collect(profiles);
        assertThat(result, is(expected));
    }

    @Test
    public void testWhenUniqueFail() {
        Profiles pf = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 27, 16)),
                new Profile(new Address("Moscow", "Red Square", 27, 17))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Red Square", 27, 16)
        );
        List<Address> result = pf.collect(profiles);
        assertNotEquals(expected, result);
    }
}