package com.company.Handlers;

import com.company.ProducerConsumerQueue;

public class NecheporycHandler implements Runnable{
    private ProducerConsumerQueue<Integer> queue;
    private int elementsToHandle, sum;

    public int getSum() {
        return sum;
    }

    public NecheporycHandler(ProducerConsumerQueue<Integer> queue, int elementsToHandle) {
        this.queue = queue;
        this.elementsToHandle = elementsToHandle;
    }

    @Override
    public void run() {
        for (int i = 0; i < elementsToHandle; i++) {
            try {
                Integer elem = queue.get();
                sum += elem;
                System.out.println("Element with value " + elem + " accounted");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
