package org.denis.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");
        Map<String, Integer> hashMap = new HashMap<>();
        scanner.forEachRemaining(s -> hashMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));
        hashMap.entrySet().stream()
                        .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                                .reversed()
                                .thenComparing(Map.Entry::getKey))
                        .limit(10)
                        .map(Map.Entry::getKey)
                        .forEach(System.out::println);
    }

}
