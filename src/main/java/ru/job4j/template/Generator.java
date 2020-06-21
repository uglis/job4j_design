package ru.job4j.template;

import java.util.Map;

/**
 * 3. Шаблонизатор. [#279274]
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
