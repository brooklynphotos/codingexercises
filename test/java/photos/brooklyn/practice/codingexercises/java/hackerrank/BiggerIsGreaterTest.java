package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BiggerIsGreaterTest {

    @Test
    public void biggerIsGreater_eg0() {
        assertEquals("lmon", BiggerIsGreater.biggerIsGreater("lmno"));
    }

    @Test
    public void biggerIsGreater_eg1() {
        assertEquals("no answer", BiggerIsGreater.biggerIsGreater("dcba"));
    }

    @Test
    public void biggerIsGreater_eg2() {
        assertEquals("acbd", BiggerIsGreater.biggerIsGreater("abdc"));
    }

    @Test
    public void biggerIsGreater_eg3() {
        assertEquals("abdc", BiggerIsGreater.biggerIsGreater("abcd"));
    }

    @Test
    public void biggerIsGreater_eg4() {
        assertEquals("fedcbabdc", BiggerIsGreater.biggerIsGreater("fedcbabcd"));
    }

    @Test
    public void biggerIsGreater_eg5() {
        assertEquals("ba", BiggerIsGreater.biggerIsGreater("ab"));
    }

    @Test
    public void biggerIsGreater_eg6() {
        assertEquals("no answer", BiggerIsGreater.biggerIsGreater("bb"));
    }

    @Test
    public void biggerIsGreater_eg7() {
        assertEquals("hegf", BiggerIsGreater.biggerIsGreater("hefg"));
    }

    @Test
    public void biggerIsGreater_eg8() {
        assertEquals("dhkc", BiggerIsGreater.biggerIsGreater("dhck"));
    }

    @Test
    public void biggerIsGreater_eg9() {
        assertEquals("hcdk", BiggerIsGreater.biggerIsGreater("dkhc"));
    }
}