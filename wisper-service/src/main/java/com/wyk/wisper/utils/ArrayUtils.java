package com.wyk.wisper.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Static utility methods pertaining to {@code Array} instances.
 *
 * @author elt
 * @since 1.0
 */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    /**
     * Returns {@code true} if the given array is null or is the empty string.
     *
     * @param array a {@code Object} array reference to check
     * @return {@code true} if the array is null or is the empty string
     */
    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Returns {@code true} if the given array contains the item.
     *
     * @param item        a Object reference to check
     * @param listOfItems a {@code Object} array reference to check
     * @return {@code true} if the array contains the item.
     */
    public static boolean contains(Object item, Object[] listOfItems) {
        return Arrays.stream(listOfItems).anyMatch(it -> it == item);
    }

    /**
     * Returns {@code int} that represents the obj size.
     *
     * @param obj a {@code Object} reference to calculate
     * @return {@code int} that the obj size.
     */
    public static int sizeOf(Object obj) {
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        } else if (obj instanceof String) {
            return ((String) obj).length();
        } else if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        } else if (obj instanceof double[]) {
            return ((double[]) obj).length;
        } else if (obj instanceof float[]) {
            return ((float[]) obj).length;
        } else if (obj instanceof long[]) {
            return ((long[]) obj).length;
        } else if (obj instanceof int[]) {
            return ((int[]) obj).length;
        } else if (obj instanceof byte[]) {
            return ((byte[]) obj).length;
        } else if (obj instanceof short[]) {
            return ((short[]) obj).length;
        } else if (obj instanceof char[]) {
            return ((char[]) obj).length;
        } else {
            return obj instanceof boolean[] ? ((boolean[]) obj).length : -1;
        }
    }

    /**
     * Return {@code List<T>} of specified type
     *
     * @param selectedValues a {@code Object} array reference to filter
     * @param type           a filter type
     * @param <T>            the list type
     * @return {@code List<T>} of specified type
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> filter(Object[] selectedValues, Class<T> type) {
        List<T> result = new ArrayList<>();

        for (Object each : selectedValues) {
            if (type.isInstance(each)) {
                result.add((T) each);
            }
        }

        return result;
    }

    public static Object[] remove(Object[] selectedValues, int index) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < selectedValues.length; i++) {
            if (i != index) {
                result.add(selectedValues[i]);
            }
        }
        return result.toArray();
    }
}
