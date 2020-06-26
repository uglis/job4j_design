package ru.job4j.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.concurrent.TimeUnit;

public class BenchmarkRun {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    public String nativeUpperCase(Test text) {
        return text.line.toUpperCase();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    public String myUpperCase(Test text) {
        return StringUpperCase.toUpperCase(text.line);
    }

    @State(Scope.Thread)
    public static class Test {
        String line = "privet";
    }
}
