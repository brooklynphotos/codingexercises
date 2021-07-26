package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtraLongFactorialsTest {

    @Test
    public void getExtraLongFactorials_eg0() {
        assertEquals("15511210043330985984000000", ExtraLongFactorials.getExtraLongFactorials(25));
    }

    @Test
    public void getExtraLongFactorials_eg2() {
        assertEquals("119622220865480194561963161495657715064383733760000000000", ExtraLongFactorials.getExtraLongFactorials(45));
    }
}