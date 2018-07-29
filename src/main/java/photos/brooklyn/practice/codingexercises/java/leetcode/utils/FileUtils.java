package photos.brooklyn.practice.codingexercises.java.leetcode.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtils {
    private FileUtils(){}
    public static Map<String, int[]> loadData(String propName) throws IOException {
        final Properties props = new Properties();
        try(final InputStream ip = FileUtils.class.getClassLoader().getResourceAsStream(propName+".properties")){
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
