import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BankerPlanTest {

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: fortune");
        testing(BankerPlan.fortune(100000, 1, 2000, 15, 1), true);
        testing(BankerPlan.fortune(100000, 1, 9185, 12, 1), false);
        testing(BankerPlan.fortune(100000000, 1, 100000, 50, 1), true);
        testing(BankerPlan.fortune(100000000, 1.5, 10000000, 50, 1), false);
        testing(BankerPlan.fortune(100000000, 5, 1000000, 50, 1), true);
    }
}