import io.projects.moneychange.Solution;
import io.projects.moneychange.model.Change;
import io.projects.moneychange.model.NoChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyChangeTest {


    @ParameterizedTest
    @ValueSource(longs = {2, 4, 6, 8})
    @DisplayName("Change for even  amount & < 10")
    public void testLessThan10EvenAmount(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);
        assertEquals(Change.builder().coin2(s / 2).build(), change);

    }

    @ParameterizedTest
    @ValueSource(longs = {5, 7, 9, 17})
    @DisplayName("Change for odd amount")
    public void testOddAmount(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);

        assertEquals(Change.builder().bill10(s / 10).bill5(1).coin2(s % 5 / 2).build(), change);
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
    @ValueSource(longs = {19, 27, 49, 59, 77, 137})
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

    @DisplayName("Impossible solution")
    @ParameterizedTest
    @ValueSource(longs = {1, 11, 111, 1111, 13, 23})
    public void testImpossibleSolution(long s) {
        Change change = Solution.optimalChange(s);

        assertNotNull(change);

        assertFalse(change.isPossible());

        assertEquals(NoChange.NoCHANGE, change);
    }

}
