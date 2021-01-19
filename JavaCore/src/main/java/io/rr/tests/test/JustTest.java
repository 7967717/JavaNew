package io.rr.tests.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author rrudenko on 13.06.2017.
 */
public class JustTest {
    public static void main(String[] args) throws NoSuchFieldException {
        List<Box<? extends Bakery>> list = List.of(new Box<Bakery>(), new Box<Cake>(), new Box<Pie>());

        for (Box<? extends Bakery> box : list) {

            Field field = box.getClass().getDeclaredField("item");
            Type type = field.getGenericType();
            System.out.println(type);
//            Type rawType = type.getRawType();
//            Type[] argumentTypes = type.getActualTypeArguments();
//            System.out.println(rawType);
//            System.out.println(rawType.getTypeName());
//            System.out.println(Arrays.toString(argumentTypes));
        }
    }
}

class Box<T> {
    private T item;
}

class Bakery { }
class Cake extends Bakery { }
class Pie extends Bakery { }