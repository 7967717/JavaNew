package io.rr.messaging;

import org.apache.camel.util.CaseInsensitiveMap;

import java.util.Map;

/**
 * @author rrudenko on 30.10.2017.
 */
public class CaseInsensitiveMapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new CaseInsensitiveMap();
//        map.put("book", "bbb");
        map.put("Book", "BBB");
        map.put("book", "bbb");
//        map.put("Book", "BBB");
        System.out.println(map);
        System.out.println(map.get("Book"));
        System.out.println(map.get("book"));
    }
}
