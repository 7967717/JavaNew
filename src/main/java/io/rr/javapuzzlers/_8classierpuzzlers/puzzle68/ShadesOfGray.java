package io.rr.javapuzzlers._8classierpuzzlers.puzzle68;

public class ShadesOfGray {
    public static void main(String[] args){
        System.out.println(X.Y.Z);
    }
}

class X {
    static class Y {
        static String Z = "Black";
    } 

    static C y = new C();
}

class C {
    String Z = "White";
}
