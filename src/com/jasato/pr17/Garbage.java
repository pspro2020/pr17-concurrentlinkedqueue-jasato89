package com.jasato.pr17;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Garbage {

    private DateTimeFormatter  format = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final int dumper;
    private final int num;

    Garbage(int dumper, int num) {
        this.dumper = dumper;
        this.num = num;
        dropGarbage();
    }

    private void dropGarbage() {
        System.out.printf("%s -> Piece %s from dumper %s is in the conveyor belt\n", LocalTime.now().format(format), num + 1, dumper +1);
    }

    public void process() {
        System.out.printf("%s -> Piece %s from dumper %s has been processed\n", LocalTime.now().format(format), num +1, dumper +1);
    }
}
