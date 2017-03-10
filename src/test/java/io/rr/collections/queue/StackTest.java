package io.rr.collections.queue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author roman on 3/10/17.
 */
public class StackTest {
    private static Stack<Integer> stack;

    @BeforeClass
    public static void setUp() throws Exception {
        stack = new Stack<>(5);

    }

    @Test
    public void add() throws Exception {
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);

        System.out.println(Arrays.toString(stack.data));

    }

    @Test
    public void remove() throws Exception {
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
//        System.out.println(stack.remove());

        System.out.println(Arrays.toString(stack.data));
    }

}