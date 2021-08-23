package com.wyk.wisper.utils;

import java.util.*;
import java.util.function.Predicate;

/**
 * Collection Utils
 *
 * @author elt
 */
public final class CollectionUtils {
    @SafeVarargs
    public static <T> Collection<T> combineAll(Collection<T>... collections) {
        Collection<T> result = new ArrayList<>();
        for (Collection<T> collection : collections) {
            result.addAll(collection);
        }

        return result;
    }

    public static <T> List<T> filter(T[] what, Predicate<? super T> how) {
        return filter(Arrays.asList(what), how);
    }

    public static <T> List<T> filter(Iterable<T> what, Predicate<? super T> how) {
        return filter(what, how, null);
    }

    public static <T> List<T> filter(Iterable<?> what, Class<T> type) {
        return filter(what, new Predicates.AllowAll(), type);
    }

    public static <T> List<T> filter(Enumeration<?> what, Class<T> type) {
        return filter(Iterables.toIterable(what), type);
    }

    @SuppressWarnings("unchecked")
    public static <E, T> List<T> filter(Iterable<E> what, Predicate<? super E> how, Class<T> type) {
        List<T> result = new ArrayList<>();

        Iterator<E> iterator = what.iterator();
        while (true) {
            E each;
            do {
                if (!iterator.hasNext()) {
                    return result;
                }

                each = iterator.next();
            } while (type != null && !type.isInstance(each));

            if (how.test(each)) {
                result.add((T) each);
            }
        }
    }

    public static <T> List<T> create(Enumeration<?> children, Class<T> type) {
        return filter(children, type);
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... instances) {
        return new HashSet<>(Arrays.asList(instances));
    }
}