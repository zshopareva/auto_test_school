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


    @Parameterized.Parameters(name = "a= {0} b={1} c={2} : result {3}")
    public static Collection<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {1, 1, 1, true},
                {3, 4, 5, true},
                {2, 3, 4, true},
                {5, 5, 3, true},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false},
                {1, 1, 0, false},
                {-5, -4, -3, false},
                {150, 80, 4, false},
                {0, 0, 0, false}
        });
    }

    @Test
    public void isTriangleTest(){
        Triangle triangle = new Triangle(a, b, c);
        boolean actual = triangle.isTriangle();
        assertEquals("Проверяем, что переданные значения образуют треугольник", result, actual);

    }
}
