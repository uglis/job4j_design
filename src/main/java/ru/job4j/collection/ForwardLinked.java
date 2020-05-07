package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 3. Удалить head в односвязном списке. [#279206]
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int length = 0;

    public void add(T value) {
        length++;
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            Node<T> temp = current.next;
            current.next = previous;
            previous = current;
            head = current;
            current = temp;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        length--;
        head = head.next;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        length--;
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node<T> prevLast = head;
        while (prevLast != tail) {
            if (prevLast.next == tail) {
                break;
            }
            prevLast = prevLast.next;
        }
        prevLast.next = null;
        if (prevLast == tail) {
            head = null;
        }
        return tail.value;
    }

    public int getLength() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
