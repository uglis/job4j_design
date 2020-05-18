package ru.job4j.io;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogFilterTest {
    @Test
    public void whenHave3Line() {
        List<String> expected = List.of(
                "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:18 +0300] \"GET /items/ajax.html HTTP/1.1\" 404 1113",
                "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:23 +0300] \"GET /TrackStudio/ HTTP/1.1\" 404 1110",
                "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:34 +0300] \"GET /TrackStudioNew/ HTTP/1.1\" 404 -"
        );
        List<String> result = LogFilter.filter("log.txt");
        assertThat(result, is(expected));
    }
}