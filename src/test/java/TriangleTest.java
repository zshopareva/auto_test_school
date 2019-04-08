import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TriangleTest {
    @Parameterized.Parameter(0)
    public int a;

    @Parameterized.Parameter(1)
    public int b;

    @Parameterized.Parameter(2)
    public int c;

    @Parameterized.Parameter(3)
    public boolean result;


    @Parameterized.Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(
                new Object[]{1, 1, 1, true},
                new Object[]{3, 4, 5, true},
                new Object[]{2, 3, 4, true},
                new Object[]{5, 5, 3, true},
                new Object[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false},
                new Object[]{1, 1, 0, false},
                new Object[]{-5, -4, -3, false},
                new Object[]{150, 80, 4, false},
                new Object[]{0, 0, 0, false}
        );
    }

    @Test
    public void isTriangleTest(){
        Triangle triangle = new Triangle();
        boolean actual = triangle.isTriangle(a, b, c);
        assertEquals(result, actual);

    }
}
