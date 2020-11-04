package org.drexel.se320;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.InOrder;

public class MockExamples {

  @Test
  public void checkClient() {
    // Mock the protocol --- we don't even have a real implementation yet!
    Protocol p = mock(Protocol.class);

    // Configure some stubbing
    when(p.end()).thenReturn(true);

    // Normally there would be some client code using the mock
    // for brevity we'll just poke at it directly

    p.end();
    p.middle();
    p.start(3);

    // These calls verify that the calls occured, but they don't impose ordering!
    verify(p).start(anyInt());
    verify(p).middle();
    verify(p).end();
  }

  @Test
  public void checkClientInOrder() {
    // Mock the protocol --- we don't even have a real implementation yet!
    Protocol p = mock(Protocol.class);

    // Configure some stubbing
    when(p.end()).thenReturn(true);

    // Normally there would be some client code using the mock
    // for brevity we'll just poke at it directly

    p.middle();
    p.start(3);
    p.end();

    InOrder inOrder = inOrder(p);

    // These calls verify that the calls occured, but they don't impose ordering!
    inOrder.verify(p).start(anyInt());
    inOrder.verify(p).middle();
    inOrder.verify(p).end();
  }
}
