package com.company;

import com.company.Handlers.IvanovHandler;
import com.company.Handlers.NecheporycHandler;
import com.company.Handlers.PetrovHandler;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int stolenThingsNumber = 50;
        ProducerConsumerQueue<Integer> ivanovQueue = new ProducerConsumerQueue<>(10);
        ProducerConsumerQueue<Integer> necheporycQueue = new ProducerConsumerQueue<>(10);

        IvanovHandler ivanovHandler = new IvanovHandler(ivanovQueue, stolenThingsNumber);
        PetrovHandler petrovHandler = new PetrovHandler(ivanovQueue, necheporycQueue, stolenThingsNumber);
        NecheporycHandler necheporycHandler = new NecheporycHandler(necheporycQueue, stolenThingsNumber);

        Thread[] threads = new Thread[] {
                new Thread(ivanovHandler),
                new Thread(petrovHandler),
                new Thread(necheporycHandler)
        };

        for (int i = 0; i < 3; i++)
            threads[i].start();
        threads[2].join();
        System.out.println("Sum of all stolen things is " + necheporycHandler.getSum());
    }
}
