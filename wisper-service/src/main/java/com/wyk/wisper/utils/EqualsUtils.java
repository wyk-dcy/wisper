package com.wyk.wisper.utils;

import java.util.Arrays;
import java.util.Objects;

/**
 * Static utility methods pertaining to {@code EqualsUtils} instances.
 *
 * @author elt
 * @since 1.0
 */
public final class EqualsUtils {
    private EqualsUtils() {
    }

    public static boolean equals(Object a, Object b) {
        if (a == b) {
            return true;
        }

        if (a != null && b != null) {
            return a.equals(b);
        }

        return false;
    }

    public static boolean notEquals(Object a, Object b) {
        return !equals(a, b);
    }

    public static boolean notEquals(double a, double b, double delta) {
        return !equals(a, b, delta);
    }

    public static boolean equalsAnyOf(int a, int[] array) {
        Objects.requireNonNull(array);

        return Arrays.stream(array).anyMatch(b -> a == b);
    }

    public static boolean equalsAnyOf(char a, char[] array) {
        Objects.requireNonNull(array);

        for (char b : array) {
            if (a == b) {
                return true;
            }
        }

        return false;
    }

    @SafeVarargs
    public static <T, S extends T> boolean equalsAnyOf(T a, S... array) {
        Objects.requireNonNull(array);

        return Arrays.stream(array).anyMatch(b -> equals(a, b));
    }

    @SafeVarargs
    public static <T, S extends T> boolean notEqualsAnyOf(T a, S... oneOf) {
        return !equalsAnyOf(a, oneOf);
    }

    public static boolean equals(double[] a, double[] b, double delta) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        if ((a.length) != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!equals(a[i], b[i], delta)) {
                return false;
            }
        }

        return true;
    }

    public static boolean equals(double a, double b, double delta) {
        if (Double.compare(a, b) == 0) {
            return true;
        }

        return Math.abs(a - b) <= delta;
    }

    @SuppressWarnings("unchecked")
    public static <T> int compare(Comparable<T> a, Comparable<T> b) {
        if (a == b) {
            return 0;
        }

        if (a != null && b != null) {
            return a.compareTo((T) b);
        }

        return a == null ? 1 : -1;
    }

    public static boolean equalsType(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return a.getClass().equals(b.getClass());
    }

}
