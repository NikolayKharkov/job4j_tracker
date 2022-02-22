package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class FindByIdActionTest {
    @Test
    public void whenFindActionIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Find item by id", "desc");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        input.askStr("Enter id: ");
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findById(1), is(item));
    }

    @Test
    public void whenFindActionNotSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Find item by id", "desc");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(5);
        input.askStr("Enter id: ");
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find item by id ==="
                        + ln
                        + "Заявка с введенным id: 5 не найдена."
                        + ln)
        );
        assertThat(tracker.findByName("Found fake"), is(Collections.emptyList()));
    }
}