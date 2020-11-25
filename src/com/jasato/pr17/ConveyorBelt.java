package com.jasato.pr17;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ConveyorBelt implements Runnable {

    private ConcurrentLinkedDeque<Garbage> separator = new ConcurrentLinkedDeque<>();

    public void initSeparation(Garbage garbage) {
        separator.add(garbage);
    }

    @Override
    public void run() {

        while (!separator.isEmpty()) {

            try {
                separator.element().process();
                separator.remove();
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.printf("%s -> No more garbage to process\n", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

    }
}
