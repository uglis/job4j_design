package ru.job4j.productstore;

import java.util.Date;

public interface CheckBalancePercent {
    /**
     * Checking how much percent was used to expired date.
     *
     * @param create create date.
     * @param exp    expire date.
     * @return percent.
     */
    default int checkBalancePercent(Date create, Date exp) {
        int totalTimeExp = daysBetween(create, exp);
        int totalPastTime = daysBetween(create, new Date(System.currentTimeMillis()));
        return (totalPastTime * 100) / totalTimeExp;
    }

    /**
     * Calculating days between two dates.
     *
     * @param d1 first date.
     * @param d2 second date.
     * @return days.
     */
    private int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
