package com.wyk.wisper.utils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * Type Filtering Collection
 *
 * @author elt
 */
public class TypeFilteringCollection<E, T extends E> implements Collection<E> {
    private final Collection<T> elements = new ArrayList<>();
    private final Class<T> type;

    public TypeFilteringCollection(Class<T> type) {
        Objects.requireNonNull(type);
        this.type = type;
    }

    public Collection<T> getFilteredCollection() {
        return new ArrayList<>(this.elements);
    }

    @Override
    public boolean addAll(@Nonnull Collection<? extends E> newElements) {
        Objects.requireNonNull(newElements);

        return this.elements.addAll(CollectionUtils.filter(newElements, this.type));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(E element) {
        return this.type.isInstance(element) && this.elements.add((T) element);
    }

    @Override
    @Nonnull
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final Iterator<T> iterator = TypeFilteringCollection.this.elements.iterator();

            @Override
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            @Override
            public E next() {
                return this.iterator.next();
            }

            @Override
            public void remove() {
                this.iterator.remove();
            }
        };
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.elements.contains(o);
    }

    @Override
    @Nonnull
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    @Nonnull
    public <F> F[] toArray(@Nonnull F[] array) {
        return this.elements.toArray(array);
    }

    @Override
    public boolean remove(Object o) {
        return this.elements.remove(o);
    }

    @Override
    public boolean containsAll(@Nonnull Collection<?> c) {
        return this.elements.containsAll(c);
    }

    @Override
    public boolean removeAll(@Nonnull Collection<?> c) {
        return this.elements.removeAll(c);
    }

    @Override
    public boolean retainAll(@Nonnull Collection<?> c) {
        return this.elements.retainAll(c);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public String toString() {
        return this.elements.toString();
    }
}
