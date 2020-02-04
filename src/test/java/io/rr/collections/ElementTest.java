package io.rr.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author roman on 4/4/17.
 */
public class ElementTest {


    @Test
    public void getUnique() {
        Collection<Element> coll = Arrays.asList(
                new Element(1, "one", 22),
                new Element(1, "one1", 22),
                new Element(2, "two", 19),
                new Element(3, "three", 21),
                new Element(3, "three", 21)
                );

        Collection<Element> unique = Element.getUnique(coll);

        unique.forEach(System.out::println);
    }

}