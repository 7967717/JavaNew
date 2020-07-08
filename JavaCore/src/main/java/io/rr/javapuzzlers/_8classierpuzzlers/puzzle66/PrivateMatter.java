package io.rr.javapuzzlers._8classierpuzzlers.puzzle66;

class Base {
    public String className = "Base";
}

class Derived extends Base {
    private String className = "Derived";
}

public class PrivateMatter {
    public static void main(String[] args) {
        Base derived = new Derived();
        System.out.println(derived.className);
    }
}
