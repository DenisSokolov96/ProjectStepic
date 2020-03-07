package org.denis.collection;

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainCollection {

    public static void main(String[] args) {

        Set<String> set1 = new LinkedHashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("0");
        set2.add("1");
        set2.add("2");

        System.out.println(symmetricDifference(set1, set2)); // {0, 3}
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);


        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (set1.contains(item) && set2.contains(item)) {
                iterator.remove();
            }
        }

        return set;
    }
}
