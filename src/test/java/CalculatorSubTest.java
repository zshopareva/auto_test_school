import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorSubTest {


    @Parameterized.Parameter(0)
    public int a;

    @Parameterized.Parameter(1)
    public int b;

    @Parameterized.Parameter(2)
    public int result;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(
                new Object[]{5, -5, 10},
                new Object[]{1, 1, 0}
        );
    }

    @Test
    public void culculatorSubShouldSumTwoNumbers(){
        Calculator calculator = new Calculator();
        int actual = calculator.sub(a, b);
        assertEquals(result, actual);

    }
}
