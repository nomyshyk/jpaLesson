import forttest.FirstTestAidaPavel;
import forttest.Squares;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(JUnitPlatform.class)
public class MyTests {
    @Test
    public void shamil(){
        Squares squares = new Squares();
        assertEquals( squares.isSimple(49), false);
        /*assertTrue(squares.kvadrat(8)>0,
                "Должно быть больше нуля!");*/
    }

    @Test
    void testSingleSuccessTest() {
        //assertEquals(triangle(4,6),12);
        //assertEquals(circle(3.14,3),18.84);
        FirstTestAidaPavel fp = new FirstTestAidaPavel();
        assertEquals(fp.trueFalse(9),false);
    }

    @Test
    public void kanat(){
        Squares squares = new Squares();
        assertEquals( squares.simpleNum(49), false);
        assertEquals( squares.simpleNum(97), true);
        /*assertTrue(squares.kvadrat(8)>0,
                "Должно быть больше нуля!");*/
    }

}
