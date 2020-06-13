package io.rr.other;

/**
 * @author roman on 3/11/17.
 */

/**
 * TODO to implement
 * - reading array from file
 * - writing output to file
 */

public class Hedgehog {
    private int endRow;
    private int endColumn;
    private int onRow;
    private int onColumn;
    private static final int ONE_STEP = 1;
    private int[][] garden;
    private int sum;

    public Hedgehog(int[][] garden) {
        this.endRow = garden.length - ONE_STEP;
        this.endColumn = garden[0].length - ONE_STEP;
        this.garden = garden;
        sum = sum + garden[onRow][onColumn];
    }

    public int goIter() {
        while (onRow != endRow || onColumn != endColumn) {
            if (onRow == endRow) {
                onColumn = goRight(onRow, onColumn);
            } else if (onColumn == endColumn) {
                onRow = goLower(onRow, onColumn);
            } else if (garden[onRow][onColumn + ONE_STEP] > garden[onRow + ONE_STEP][onColumn]) {
                onColumn = goRight(onRow, onColumn);
            } else {
                onRow = goLower(onRow, onColumn);
            }
        }
        return sum;
    }

    private int goLower(int onRow, int onColumn) {
        sum = sum + garden[onRow + ONE_STEP][onColumn];
        onRow = onRow + ONE_STEP;
        return onRow;
    }

    private int goRight(int onRow, int onColumn) {
        sum = sum + garden[onRow][onColumn + ONE_STEP];
        onColumn = onColumn + ONE_STEP;
        return onColumn;
    }

    public int goRec() {
        if (onRow != endRow || onColumn != endColumn) {
            if (onRow == endRow) {
                onColumn = goRight(onRow, onColumn);
            } else if (onColumn == endColumn) {
                onRow = goLower(onRow, onColumn);
            } else if (garden[onRow][onColumn + ONE_STEP] > garden[onRow + ONE_STEP][onColumn]) {
                onColumn = goRight(onRow, onColumn);
            } else {
                onRow = goLower(onRow, onColumn);
            }
            goRec();
        }
        return sum;
    }
}
