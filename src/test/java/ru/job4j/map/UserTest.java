package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenPut2EqualsToMap() {
        Map<User, Object> map = new HashMap<>();
        User first = new User("Igor", 3, "12.12.2222");
        User second = new User("Igor", 3, "12.12.2222");
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
    }
}