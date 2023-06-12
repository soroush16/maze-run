package com.findwaysout.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    public void testFindMinimumStepsWithNoExitPoint() {
        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap1.txt");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void testFindMinimumStepsWith() {

        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap2.txt");
        Assertions.assertEquals(1, steps);
    }

    @Test
    public void testFindMinimumStepsWithSurroundedByOnes() {

        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap3.txt");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void testFindMinimumStepsWithMultipleExitPoints() {
        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap4.txt");
        Assertions.assertEquals(2, steps);
    }

    @Test
    public void testFindMinimumStepsWithExitPointAwayFromStart() {
        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap5.txt");
        Assertions.assertEquals(9, steps);
    }

    @Test
    public void testReturnZeroWhenThereIsNoStartPoint() {
        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap6.txt");
        Assertions.assertEquals(0, steps);
    }

    @Test
    public void testReturnZeroWhenXIsOnExitPoint() {
        Solution gameImp = new Solution();
        int steps = gameImp.countMinimumSteps("testMap7.txt");
        Assertions.assertEquals(0, steps);
    }

}