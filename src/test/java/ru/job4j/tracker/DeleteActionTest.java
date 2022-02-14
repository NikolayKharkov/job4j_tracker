package ru.job4j.tracker;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DeleteActionTest {
    @Test
    public void whenDeleteActionIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Delete item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        input.askStr("Enter id: ");
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
    }

    @Test
    public void whenDeleteActionNotSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Delete item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        input.askStr("Enter id: ");
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
    }
}