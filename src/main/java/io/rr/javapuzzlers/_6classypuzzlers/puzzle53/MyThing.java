package io.rr.javapuzzlers._6classypuzzlers.puzzle53;

public class MyThing extends Thing {
    private final int arg;

    /*
     * This constructor is illegal. Rewrite it so that it has the same
     * effect but is legal.
     */
    public MyThing() {
        this((int)System.currentTimeMillis());
    }

    private MyThing(int i) {
        super(i);
        this.arg = i;
    }
}
