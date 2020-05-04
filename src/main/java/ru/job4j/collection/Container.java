package ru.job4j.collection;

import java.util.*;

/**
 * 2. Создать контейнер на базе связанного списка [#279209]
 */
public class Container<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int modCount = 0;

    public void add(E value) {
        modCount++;
        if (head == null) {
            head = new Node(null, value, tail);
        } else if (tail == null) {
            tail = new Node(head, value, null);
            head.next = tail;
        } else {
            Node node = new Node(tail, value, null);
            tail.next = node;
            tail = node;
        }
    }

    public E get(int index) {
        Objects.checkIndex(index, modCount);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node node = head;
            final int expectedMod = modCount;

            @Override
            public boolean hasNext() {
                if (expectedMod != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = node.e;
                node = node.next;
                return element;
            }
        };
    }

    class Node {
        E e;
        Node prev;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }
}
