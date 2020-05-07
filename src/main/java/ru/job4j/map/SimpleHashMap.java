package ru.job4j.map;

import java.util.*;

/**
 * 8. Реализовать собственную структуру данных - HashMap [#279238]
 */
public class SimpleHashMap<K, V> {
    private Node<K, V>[] container = new Node[16];
    private int cellBalance = 0;

    /**
     * Вставляем пару в Таблицу.
     *
     * @param key   ключ.
     * @param value значение.
     * @return получилось добавить или нет.
     */
    public boolean insert(K key, V value) {
        checkEnoughSpace();
        Node<K, V> node = new Node<>(key, value);
        int index = hash(key);
        Node<K, V> currentNode = container[index];
        if (currentNode == null) {
            cellBalance++;
            container[index] = node;
            return true;
        } else if (node.key == currentNode.key) {
            return false;
        }
        return false;
    }

    /**
     * Получаем значение по ключу.
     *
     * @param key ключ.
     * @return значение.
     */
    public V get(K key) {
        Node<K, V> node = container[hash(key)];
        return node.value;
    }

    /**
     * Удаляем пару по ключу.
     *
     * @param key ключ.
     * @return получилось удалить или нет.
     */
    public boolean delete(K key) {
        int index = hash(key);
        Node<K, V> node = container[index];
        if (node != null) {
            container[index] = null;
            cellBalance--;
            return true;
        }
        return false;
    }

    /**
     * Проверяем кол-во свободных ячеек.
     * Если массив подходит к заполнению, создаём новый массив,
     * копируем все пары в него, перераспределяя их в зависимости
     * от размера нового массива.
     */
    public void checkEnoughSpace() {
        if (cellBalance == container.length - 1) {
            Node<K, V>[] temp = Arrays.copyOf(container, container.length);
            int size = container.length;
            container = new Node[size * 2];
            cellBalance = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    Node<K, V> node = temp[i];
                    insert(node.key, node.value);
                }
            }
        }
    }

    /**
     * Итератор для прохода по массиву.
     *
     * @return пара
     */
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            int countIt = 0;
            int startIt = 0;
            @Override
            public boolean hasNext() {
                return countIt < cellBalance;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> node = null;
                for (int i = startIt; i < container.length; i++) {
                    if (container[i] != null) {
                        node = container[i];
                        startIt = ++i;
                        countIt++;
                        break;
                    }
                }
                return node;
            }
        };
    }

    /**
     * Определяем позицию пары в массиве по ключу.
     *
     * @param key ключ.
     * @return позиция в массиве.
     */
    public int hash(K key) {
        int h = key.hashCode() % container.length;
        return h & (container.length - 1);
    }

    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
