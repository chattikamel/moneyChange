import io.projects.moneychange.Solution;
import io.projects.moneychange.model.Change;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoneyChangeTest {


    @ParameterizedTest
    @ValueSource(longs = {2, 4, 6, 8})
    @DisplayName("Change for even amount")
    public void testEvenAmount(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);
        assertEquals(s, change.sum());

    }

    @Test
    @DisplayName("Change for multipe of 5 amount")
    public void testMulipleOf5_Amount() {
        Change change = Solution.optimalChange(15);

        assertNotNull(change);

        assertEquals(15, change.sum());
    }

    @Test
    @DisplayName("Change for multipe of 10 amount")
    public void testMulipleOf10_Amount() {
        Change change = Solution.optimalChange(20);

        assertNotNull(change);

        assertEquals(Change.builder().bill10(2).build(), change);
    }

    @DisplayName("Change composed of bill(10, 5)")
    @ParameterizedTest
    @ValueSource(longs = {25, 45, 55, 75})
    public void testMultiBillTypeChange(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);

        assertEquals(Change.builder()
                .bill10(s / 10)
                .bill5(s % 10 / 5)
                .build(), change);
    }


    @DisplayName("Change composed of bill(10, 5) & coin2")
    @ParameterizedTest
    @ValueSource(longs = {27, 49, 59, 77})
    public void testMultiBillTypeAndCoinChange(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);

        assertEquals(Change.builder()
                .bill10(s / 10)
                .bill5(s % 10 / 5)
                .coin2(s % 10 % 5 / 2)
                .build(), change);
    }




    @DisplayName("Big amount 9223372036854775807l")
    @Test
    public void testBigAmount() {
        Change change = Solution.optimalChange(9223372036854775807l);

        assertNotNull(change);

        assertEquals(Change.builder()
                .bill10(922337203685477580l)
                .bill5(1)
                .coin2(1)
                .build(), change);
    }

}
