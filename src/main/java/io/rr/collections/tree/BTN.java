package io.rr.collections.tree;

/**
 * @author roman on 4/4/17.
 */
public class BTN<T> {
    private int val;
    private BTN<T> left;
    private BTN<T> right;

    public boolean compare(BTN<T> btn1, BTN<T> btn2) {
        if (btn1 == btn2) {
            return true;
        }
        if (btn1 == null || btn2 == null) {
            return false;
        }
        return btn1.val == (btn2.val) &&
                compare(btn1.left, btn2.left) &&
                compare(btn1.right, btn2.right);
    }
}
