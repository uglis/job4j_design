package ru.job4j.collection;

import java.util.*;
import java.util.function.Consumer;

/**
 * 2. Создать контейнер на базе связанного списка [#279209]
 */
public class Container<E> implements Iterable<E> {
    private Node<E>[] data;
    private int point = 0;
    private int modCount = 0;

    public Container() {
        this.data = new Node[0];
    }

    public void add(E value) {
        if (point == data.length) {
            this.data = Arrays.copyOf(data, data.length + 1);
        }
        Node<E> e;
        if (point == 0) {
            e = new Node<>(null, value);
        } else {
            e = new Node<>(data[point - 1], value);
        }
        point++;
        modCount++;
        this.data[data.length - 1] = e;
    }

    public E get(int index) {
        Objects.checkIndex(index, point);
        return data[index].element;
    }

    public E getPrevious(int index) {
        Objects.checkIndex(index, point);
        return data[index].previous.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int expectCount = modCount;
            int itCount = 0;

            @Override
            public boolean hasNext() {
                if (expectCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return itCount < point;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) data[itCount++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private class Node<E> {
        private final E element;
        private final Node<E> previous;

        public Node(Node<E> previous, E current) {
            this.previous = previous;
            this.element = current;
        }
    }
}
