package com.company.Handlers;

import com.company.ProducerConsumerQueue;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Random;

public class IvanovHandler implements Runnable {
    private ProducerConsumerQueue<Integer> queue;
    private int stolenElems;

    public IvanovHandler(ProducerConsumerQueue<Integer> queue, int stolenElems) {
        this.queue = queue;
        this.stolenElems = stolenElems;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < stolenElems; i++) {
            try {
                int elem = random.nextInt(1000);
                System.out.println("Element with value " + elem + " stolen (" +i+")" );
                queue.put(elem);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
