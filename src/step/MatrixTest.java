package step;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liupeijie on 西暦15/06/22.
 */
public class MatrixTest {
    @Test
    public void testMatrix(){

        assertEquals(450.0, Matrix.matrix(3), 0);
        assertEquals(3680.0, Matrix.matrix(4), 0);
        assertEquals(18250.0, Matrix.matrix(5), 0);
   
    }
}