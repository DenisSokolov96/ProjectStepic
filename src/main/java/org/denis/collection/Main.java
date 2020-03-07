package org.denis.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lines = br.readLine();
        if (lines!=null) {
            String[] line = lines.split(" ");

            List<String> list = new ArrayList<>();

            boolean flag = true;
            for (String a : line) {
                if (!flag) {
                    list.add(a);
                    flag = true;
                } else flag = false;
            }
            Collections.reverse(list);
            list.forEach(e -> System.out.print(e + " "));
        }
    }

}