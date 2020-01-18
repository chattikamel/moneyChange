import io.projects.moneychange.Solution;
import io.projects.moneychange.model.Change;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyChangeTest {

    @Test
    @DisplayName("Dummy test")
    public void test() {

        Change change = Solution.optimalChange(4l);

        Assertions.assertNotNull(change);

    }

}
