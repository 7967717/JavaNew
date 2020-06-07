package io.rr.other;

import org.testng.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConsecutiveSequenceTest {

    private ConsecutiveSequence solution;

    @BeforeTest
    public void setUp() {
        solution = new ConsecutiveSequence();
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                new Object[]{12, "1-2"},
                new Object[]{123, "1-3"},
                new Object[]{135, "1,3,5"},
                new Object[]{125, "1-2,5"},
                new Object[]{1357, "1,3,5,7"},
                new Object[]{12367, "1-3,6-7"},
                new Object[]{134567, "1,3-7"},
                new Object[]{1234567, "1-7"}
        };
    }

    @DataProvider(name = "test2")
    public Object[][] createData2() {
        return new Object[][]{
                new Object[]{1},
                new Object[]{-135},
                new Object[]{128}
        };
    }

    @Test(dataProvider = "test1")
    public void verifySolution1(int input, String expected) {
        Assert.assertEquals(solution.convert(input), expected);
    }

    @Test(dataProvider = "test2")
    public void verifySolution2(int input) {
        Assert.assertThrows(ConsecutiveSequence.WrongNumberException.class, () -> solution.convert(input));
    }

}