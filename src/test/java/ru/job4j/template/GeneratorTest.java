package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {
    @Ignore
    @Test
    public void whenHaveRightAnswer() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> input = Map.of(
                "name", "Igor",
                "subject", "you");
        String expected = "I am a Igor, Who are you? ";
        assertThat(new GeneratorTemp().produce(template, input), is(expected));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenKeyIsAbsented() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> input = Map.of("subject", "you");
        new GeneratorTemp().produce(template, input);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenHave3Keys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> input = Map.of(
                "name", "Igor",
                "subject", "you",
                "User2", "user");
        new GeneratorTemp().produce(template, input);
    }
}