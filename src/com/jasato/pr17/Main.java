package com.jasato.pr17;

import java.sql.Time;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ConveyorBelt conveyorBelt = new ConveyorBelt();
        Thread conveyorBeltThread = new  Thread(conveyorBelt);
        Thread dumper;

        for (int i = 0; i < NUM_THREADS; i++) {
            dumper = new Thread(new Dumper(conveyorBelt, i));
            dumper.start();

        }

        TimeUnit.SECONDS.sleep(3);
        conveyorBeltThread.start();
    }
}
