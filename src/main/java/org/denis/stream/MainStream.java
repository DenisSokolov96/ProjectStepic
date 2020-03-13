package org.denis.stream;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream {
    public static void main(String[] args) {

        // pseudoRandomStream
        // IntStream intStream = pseudoRandomStream(13);
        // intStream.limit(10).forEach(System.out::println);

    }

    public static IntStream pseudoRandomStream(int seed) {

        IntSupplier intSupplier = new IntSupplier() {

            private int current = 0;

            private int mid(int x) {
                if (x == 0) return seed;
                int m = mid(x - 1); m *= m;

                int result = 0;
                int i = 1;
                while (m > 0) {
                    result += (i>=2 && i<=4) ? (m % 10) * Math.pow(10, i - 2):0;
                    m /= 10;
                    i++;
                }

                return result;
            }


            @Override
            public int getAsInt() {
                return mid(current++);
            }
        };

        IntStream natural = IntStream.generate(intSupplier);

        return natural;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T [] array =(T []) stream.sorted(order).toArray();

        if(array == null || array.length == 0) minMaxConsumer.accept(null,null);
        else minMaxConsumer.accept(array[0],array[array.length-1]);

    }
}
