package io.rr.tests.mockito;

import org.junit.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author rrudenko on 09.06.2017.
 */
public class StabMethod {

    @Test
    public void test() {
// you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

// stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

// the following prints "first"
        System.out.println(mockedList.get(0));

// the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

}
