package BADtesting;

import static org.junit.Assert.*;
import org.junit.Test;

public class BADTest {

    @Test
    public void testImmAction(){
        assertEquals(13, BADtestCode.assignInstruction(2.0, 4.2,5.9));
    }
}
