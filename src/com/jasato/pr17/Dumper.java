package com.jasato.pr17;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Dumper implements Runnable {

    private static final int MAX_GARBAGE = 5;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
    private ConveyorBelt conveyorBelt = new ConveyorBelt();
    private int num;
    private List<Garbage> garbageArrayList = new ArrayList<>();

    Dumper(ConveyorBelt conveyorBelt, int num) {
        this.conveyorBelt = conveyorBelt;
        this.num = num;
        for (int i = 0; i < MAX_GARBAGE; i++) {
            garbageArrayList.add(new Garbage(num, i));

        }
    }

    @Override
    public void run() {
        System.out.printf("%s -> Dumper %s started\n", LocalTime.now().format(format), num + 1);
        for (Garbage garbage : garbageArrayList) {
            try {
                conveyorBelt.initSeparation(garbage);
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s -> Dumper number %s is empty\n", LocalTime.now().format(format), num +1);
    }
}
