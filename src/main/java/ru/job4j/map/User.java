package ru.job4j.map;

import java.util.Objects;

/**
 * 1. Создать модель User [#279231]
 */
public class User {
    private String name;
    private int children;
    private String birthday;

    public User(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        User user = (User) o;
//        return children == user.children
//                && Objects.equals(name, user.name)
//                && Objects.equals(birthday, user.birthday);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, children, birthday);
//    }
}
