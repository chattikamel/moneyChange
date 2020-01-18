import io.projects.moneychange.Solution;
import io.projects.moneychange.model.Change;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoneyChangeTest {

    @Test
    @DisplayName("Change for 2 coins")
    public void test2Coins() {

        Change change = Solution.optimalChange(2l);

        assertNotNull(change);

        System.out.println(change);

        assertEquals(2, change.getCoin2() * 2 + change.getBill5() * 5 + change.getBill10() * 10);

    }

}
