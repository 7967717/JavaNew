package io.rr.tests.test;

public class App111 {


    static Node getSmallestCommonSubtree(Node a, Node b) {
        if(a == null || b == null || a.parent == null || b.parent == null) {
            throw new IllegalArgumentException();
        }

        if(check(a, b)){
            return a.parent;
        } else {
            getSmallestCommonSubtree(a.parent, b);
            getSmallestCommonSubtree(a, b.parent);
        }
        return null;
    }

    static boolean check(Node a, Node b) {
        return a.parent.equals(b.parent);
    }
}

class Node {
    Node parent;
}