package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 3. Slf4j - вывод переменных. [#279249]
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int a = 1;
        byte b = 2;
        char c = '3';
        short d = 4;
        double e = 5D;
        float f = 6F;
        long g = 7L;
        boolean l = true;
        LOG.debug("List of variables : int {}, byte {}, char {}, short {}, double {}, float {}, long {}, boolean {}",
                a, b, c, d, e, f, g, l);
    }
}
