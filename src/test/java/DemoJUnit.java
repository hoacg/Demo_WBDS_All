import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoJUnit {

    @Test
    @DisplayName("Demo test case PASSED với giá trị true")
    void demoTestCase() {
        boolean expected = true;

        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Demo test case FAILED với giá trị false")
    void demoTestCase2() {
        boolean expected = true;

        boolean actual = false;
        assertEquals(expected, actual);
    }


}
