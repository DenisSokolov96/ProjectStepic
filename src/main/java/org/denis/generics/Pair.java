package org.denis.generics;

import java.util.Objects;

class Pair<I,S> {

    private final I value;
    private final S str;

    public Pair(I value, S str) {
        this.value = value;
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(value, pair.value) &&
                Objects.equals(str, pair.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, str);
    }

    public static <I,S> Pair<I,S> of (I value, S str) {
        return new Pair<>(value, str);
    }

    public I getFirst() {
        return this.value;
    }

    public S getSecond() {
        return this.str;
    }
}
