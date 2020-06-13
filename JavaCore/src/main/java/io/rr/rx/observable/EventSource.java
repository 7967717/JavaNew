package io.rr.rx.observable;

import java.util.Observable;
import java.util.Scanner;

/**
 * @author romanr on 2/17/2017.
 */
public class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}
