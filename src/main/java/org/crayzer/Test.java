package org.crayzer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);;
        map.put(3, 11);
        map.put(1, 12);
        map.put(5, 23);
        map.put(2, 22);

        map.put(3, 26);
        map.get(5);


        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
