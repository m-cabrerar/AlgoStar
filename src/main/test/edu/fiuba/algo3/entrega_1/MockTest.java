package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void mockTest() {
        Message message = mock(Message.class);
        when(message.greet()).thenReturn("Hola Mundo!");
        assertEquals("Hola Mundo!", message.greet());
    }
}
