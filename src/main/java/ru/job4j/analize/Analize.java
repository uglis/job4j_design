package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 2. Статистику по коллекции. [#279202]
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> map = new HashMap<>();
        int changeSize = previous.size() - current.size();
        int changeNames = 0;
        for (User user : previous) {
            map.put(user.getId(), user);
        }
        for (User user : current) {
            if (map.containsKey(user.getId())
                    && !user.getName().equals(
                            map.get(user.getId()).getName())) {
                changeNames++;
            }
        }
        return new Info(Math.abs(Math.min(0, changeSize)),
                changeNames,
                Math.max(changeSize, 0));
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }
}
