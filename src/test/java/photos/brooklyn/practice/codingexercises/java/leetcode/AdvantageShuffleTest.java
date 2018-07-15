package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AdvantageShuffleTest {
    private final AdvantageShuffle shuffle = new AdvantageShuffle();

    @Test
    public void advantageCount1() {
        final int[] A = {2,7,11,15};
        final int[] B = {1,10,4,11};
        assertTrue(Arrays.equals(new int[]{2,11,7,15}, shuffle.advantageCount(A, B)));
    }

    @Test
    public void advantageCount2() {
        final int[] A = {12,24,8,32};
        final int[] B = {13,25,32,11};
        assertTrue(Arrays.equals(new int[]{24,32,8,12}, shuffle.advantageCount(A, B)));
    }

    @Test
    public void advantageCount3() {
        final int[] A = {2,0,4,1,2};
        final int[] B = {1,3,0,0,2};
        assertTrue(Arrays.equals(new int[]{2,0,2,1,4}, shuffle.advantageCount(A, B)));
    }

    @Test
    public void advantageCountLong() throws IOException {
        final Map<String, int[]> data = loadData("advantage_shuffle");
        final int[] A = data.get("a");
        final int[] B = data.get("b");
        assertTrue(Arrays.equals(new int[]{2,0,2,1,4}, shuffle.advantageCount(A, B)));
    }

    private Map<String, int[]> loadData(String propName) throws IOException {
        final Properties props = new Properties();
        try(final InputStream ip = AdvantageShuffleTest.class.getClassLoader().getResourceAsStream(propName+".properties")){
            props.load(ip);
        }
        final Map<String, int[]> m = new HashMap<>();
        for(Object key:props.keySet()){
            String v = (String) props.get(key);
            String[] cs = v.split(",");
            final int[] ints = new int[cs.length];
            for(int i=0;i<cs.length;i++){
                final String c = cs[i];
                ints[i] = Integer.parseInt(c);
            }
            m.put((String) key, ints);
        }
        return m;
    }
}