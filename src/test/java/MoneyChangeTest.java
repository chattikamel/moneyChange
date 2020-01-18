import io.projects.moneychange.Solution;
import io.projects.moneychange.model.Change;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoneyChangeTest {


    @ParameterizedTest
    @ValueSource(longs = { 2, 4 ,6 , 8})
    @DisplayName("Change for even amount")
    public void testEvenAmount(long s) {

        Change change = Solution.optimalChange(s);

        assertNotNull(change);

        System.out.println(change);

        assertEquals(s, change.sum());

    }

}
