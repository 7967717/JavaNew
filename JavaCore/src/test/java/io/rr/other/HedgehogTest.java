package io.rr.other;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author roman on 3/11/17.
 */
public class HedgehogTest {

    @Test
    public void testIter3X3() {
        int [][] arr3x3 = new int[][]{
                {1,2,3},
                {1,2,3},
                {1,2,3}
        };

        Hedgehog hedgehog = new Hedgehog(arr3x3);
        assertEquals(12, hedgehog.goIter());
    }

    @Test
    public void testIter2X3() {
        int [][] arr2x3 = new int[][]{
                {1,2,3},
                {3,2,1}
        };

        Hedgehog hedgehog = new Hedgehog(arr2x3);
        assertEquals(7, hedgehog.goIter());
    }

    @Test
    public void testIter3X2() {
        int [][] arr3x2 = new int[][]{
                {3,2},
                {2,3},
                {3,2}
        };

        Hedgehog hedgehog = new Hedgehog(arr3x2);
        assertEquals(10, hedgehog.goIter());
    }

    @Test
    public void testRec3X3() {
        int [][] arr3x3 = new int[][]{
                {1,2,3},
                {1,2,3},
                {1,2,3}
        };

        Hedgehog hedgehog = new Hedgehog(arr3x3);
        assertEquals(12, hedgehog.goRec());
    }

    @Test
    public void testRec2X3() {
        int [][] arr2x3 = new int[][]{
                {1,2,3},
                {3,2,1}
        };

        Hedgehog hedgehog = new Hedgehog(arr2x3);
        assertEquals(7, hedgehog.goRec());
    }

    @Test
    public void testRec3X2() {
        int [][] arr3x2 = new int[][]{
                {3,2},
                {2,3},
                {3,2}
        };

        Hedgehog hedgehog = new Hedgehog(arr3x2);
        assertEquals(10, hedgehog.goRec());
    }
}