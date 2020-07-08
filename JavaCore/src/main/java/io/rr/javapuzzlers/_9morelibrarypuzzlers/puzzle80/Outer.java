package io.rr.javapuzzlers._9morelibrarypuzzlers.puzzle80;

public class Outer {
    public static void main(String[] args) throws Exception {
        new Outer().greetWorld();
    }

    private void greetWorld() throws Exception {
//        System.out.println(Inner.class.newInstance());
        System.out.println(new Outer(). new Inner());
    }

    public class Inner {
        public String toString() {
            return "Hello world";
        }
    }
}
