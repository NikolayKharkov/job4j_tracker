package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityIncrease() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByName().thenComparing(new JobIncreaseByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(10));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("ABB", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameIncrease() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByName();
        int rsl = cmpNamePriority.compare(
                new Job("Fix Bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("ABB", 1)
        );
        assertThat(rsl, lessThan(2));
    }

    @Test
    public void whenCompatorByPriorityIncrease() {
        Comparator<Job> cmpNamePriority = new JobIncreaseByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix Bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(2));
    }
}