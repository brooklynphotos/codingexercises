package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;
import static photos.brooklyn.practice.codingexercises.java.hackerrank.DecentNumber.*;

import static org.junit.Assert.*;

public class DecentNumberTest {

    @Test
    public void getDecentNumber_eg1() {
        assertEquals("-1", getDecentNumber(1));
    }

    @Test
    public void getDecentNumber_eg2() {
        assertEquals("555", getDecentNumber(3));
    }

    @Test
    public void getDecentNumber_eg3() {
        assertEquals("33333", getDecentNumber(5));
    }

    @Test
    public void getDecentNumber_eg4() {
        assertEquals("55555533333", getDecentNumber(11));
    }
}