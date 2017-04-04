package io.rr.collections;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author roman on 4/4/17.
 */

public class Element {
    private int num;
    private String name;
    private int age;

    public Element(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public static Collection<Element> getUnique(Collection<Element> in) {
        Collection <Element> out = new HashSet<>();
        for (Element elem : in) {
            if(elem.age > 20) {
                out.add(elem);
            }
        }

        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        return num == element.num;
    }

    @Override
    public int hashCode() {
        return num;
    }
}
