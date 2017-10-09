package com.bobby.peng.learning.java.sync;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by peng2035 on 2017/4/2.
 */
public class DelayedTest implements Delayed {

    private long time;

    public DelayedTest(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        return unit.convert(this.time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        long value = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);

        if(value == 0) return 0;

        else if(value > 0) return 1;

        else return -1;
    }

    public long getTime() {
        return time;
    }
}
