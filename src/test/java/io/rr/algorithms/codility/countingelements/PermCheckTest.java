package io.rr.algorithms.codility.countingelements;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PermCheckTest {
    private PermCheck solution;

    @BeforeTest
    public void setUp() {
        solution = new PermCheck();
    }

    @DataProvider(name = "test1")
    public Object [][] createData1() {
        return new Object [][] {
                new Object [] { new int [] {                1 }, 1 },
                new Object [] { new int [] {                2 }, 0 },
                new Object [] { new int [] {             1, 2 }, 1 },
                new Object [] { new int [] {             2, 2 }, 0 },
                new Object [] { new int [] {          1, 3, 2 }, 1 },
                new Object [] { new int [] {          1, 3, 3 }, 0 },
                new Object [] { new int [] {       4, 1, 3, 2 }, 1 },
                new Object [] { new int [] {          4, 1, 3 }, 0 },
                new Object [] { new int [] {    1, 3, 5, 4, 2 }, 1 },
                new Object [] { new int [] { 1, 3, 6, 4, 1, 2 }, 0 },
                new Object [] { new int [] { 1, 3, 5, 4, 6, 2 }, 1 },
                new Object [] { new int [] {          1000000 }, 0 },
                new Object [] { new int [] {       1, 1000000 }, 0 },
        };
    }

    @Test(dataProvider = "test1")
    public void verifySolution(int [] pA, int pExpected) {
        Assert.assertEquals(solution.solution(pA), pExpected);
    }

}