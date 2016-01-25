package com.manywho.sdk.utils;

import com.github.fge.lambdas.runnable.ThrowingRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static final ExecutorService THREADPOOL = Executors.newCachedThreadPool();

    public static void runInBackground(ThrowingRunnable runnable) {
        THREADPOOL.submit(runnable);
    }
}
