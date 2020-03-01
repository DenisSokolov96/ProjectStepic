/*
 * Напишите программу, читающую текст из System.in и выводящую в System.out сумму
 * всех встреченных в тексте вещественных чисел с точностью до шестого знака после запятой.
 * Числом считается последовательность символов, отделенная от окружающего текста пробелами или переводами строк и
 * успешно разбираемая методом Double.parseDouble.
*/
package org.denis.files;

import java.util.Locale;
import java.util.Scanner;

public class MainSumma {
    public static void main(String[] args) {

        summa();
    }

    public static void summa() {

        String str = "-1e3 18 .111 11bbb";

        Scanner scanner = new Scanner(str)
                .useLocale(Locale.forLanguageTag("en"));
        double a = 0.0;
        double summa = 0.0;
        while ( scanner.hasNext()) {
            if (scanner.hasNextDouble())
                summa += scanner.nextDouble();
            else scanner.next();
        }
        System.out.printf(Locale.ENGLISH,"%.6f",summa);

        scanner.close();
    }
}
