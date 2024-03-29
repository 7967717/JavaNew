package io.rr.rx.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author romanr on 2/17/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        EventSource eventSource = new EventSource();

        eventSource.addObserver((observable, message) ->
                System.out.println("Received message: " + message + " from " + observable.getClass()));

        new Thread(eventSource).start();
    }
}
