package ru.job4j.tracker;

import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class FindByNameActionTest {
    @Test
    public void whenFindActionIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Found item");
        input.askStr("Enter name: ");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findByName("Found item"), is(List.of(item)));
    }

    @Test
    public void whenFindActionNotSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Found fake");
        input.askStr("Enter name: ");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find items by name ==="
                        + ln
                        + "Заявки с именем: Found fake не найдены."
                        + ln)
        );
        assertThat(tracker.findByName("Found fake"), is(Collections.emptyList()));
    }
}