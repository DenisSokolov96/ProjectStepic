package org.denis.generics;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class MainGeneric {

    private  static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        //pairFunc();

    }

    private static void pairFunc() {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        stringBuilder.append(i + "  " + s + "\n");


        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        stringBuilder.append(mustBeTrue + "  " + mustAlsoBeTrue);
        System.out.println(stringBuilder);
    }
}
