package ru.job4j.analize;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    @Test
    public void when3Changes() {
        Analize analize = new Analize();
        List<User> prev = List.of(
                new User(1, "Igor"),
                new User(2, "Olea"),
                new User(3, "Kolea"),
                new User(4, "Tanea")
        );
        List<User> current = List.of(
                new User(1, "Igo"),
                new User(2, "Olea"),
                new User(3, "Kole"),
                new User(4, "Tane")
        );
        Analize.Info changes = analize.diff(prev, current);
        Analize.Info expected = new Analize.Info(0, 3, 0);
        assertThat(changes, is(expected));
    }

    @Test
    public void whenDelete1() {
        Analize analize = new Analize();
        List<User> prev = List.of(
                new User(1, "user1"),
                new User(2, "user2")
        );
        List<User> current = List.of(
                new User(1, "user1")
        );
        Analize.Info info = analize.diff(prev, current);
        Analize.Info expected = new Analize.Info(0, 0, 1);
        assertThat(info, is(expected));
    }

    @Test
    public void whenAdd1AndChange2() {
        Analize analize = new Analize();
        List<User> prev = List.of(
                new User(1, "Igor"),
                new User(2, "Olea"),
                new User(3, "Kolea"),
                new User(4, "Tanea")
        );
        List<User> current = List.of(
                new User(1, "Igo"),
                new User(2, "Olea"),
                new User(3, "Kolea"),
                new User(4, "Tane"),
                new User(5, "Tolik")
        );
        Analize.Info info = analize.diff(prev, current);
        Analize.Info expected = new Analize.Info(1, 2, 0);
        assertThat(info, is(expected));
    }

    @Test
    public void whenDeleted3AndChange3() {
        Analize analize = new Analize();
        List<User> prev = List.of(
                new User(1, "Igor"),
                new User(2, "Olea"),
                new User(3, "Kolea"),
                new User(4, "Tanea"),
                new User(5, "Tolik"),
                new User(6, "Vasea"),
                new User(7, "Egor"),
                new User(8, "Kuzea")
        );
        List<User> current = List.of(
                new User(4, "Tane"),
                new User(5, "Olik"),
                new User(6, "Asea"),
                new User(7, "Egor"),
                new User(8, "Kuzea")
        );
        Analize.Info info = analize.diff(prev, current);
        Analize.Info expected = new Analize.Info(0, 3, 3);
        assertThat(info, is(expected));
    }

    @Test
    public void whenAllChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        List<User> previous = List.of(u1, u2, u3);
        List<User> current = List.of(new User(1, "AA"), u2, new User(4, "D"));
        Analize.Info result = new Analize().diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(1));
    }
}