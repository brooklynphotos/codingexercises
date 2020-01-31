package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryGapTest {

    private BinaryGap binGap;

    @Before
    public void setup(){
        this.binGap = new BinaryGap();
    }
    @Test
    public void binaryGap22() {
        assertEquals(2, binGap.binaryGap(22));
    }
    @Test
    public void binaryGap5() {
        assertEquals(2, binGap.binaryGap(5));
    }
    @Test
    public void binaryGap6() {
        assertEquals(1, binGap.binaryGap(6));
    }
    @Test
    public void binaryGap8() {
        assertEquals(0, binGap.binaryGap(8));
    }
}