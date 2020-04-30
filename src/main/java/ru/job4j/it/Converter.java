package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.4. Создать convert(Iterator<Iterator>) [#279216]
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> tempIt = it.next();

            @Override
            public boolean hasNext() {
                if (!tempIt.hasNext()) {
                    if (it.hasNext()) {
                        tempIt = it.next();
                        while (!tempIt.hasNext() && it.hasNext()) {
                            tempIt = it.next();
                        }
                    }
                }
                return tempIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return tempIt.next();
            }
        };
    }
}
