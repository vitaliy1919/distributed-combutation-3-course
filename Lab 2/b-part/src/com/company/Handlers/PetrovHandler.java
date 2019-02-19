package com.company.Handlers;

import com.company.ProducerConsumerQueue;

public class PetrovHandler implements Runnable{
    private ProducerConsumerQueue<Integer> ivanovQueue;
    private ProducerConsumerQueue<Integer> necheporycQueue;
    private int elementsToHandle;

    public PetrovHandler(ProducerConsumerQueue<Integer> ivanovQueue, ProducerConsumerQueue<Integer> necheporycQueue, int elementsToHandle) {
        this.ivanovQueue = ivanovQueue;
        this.necheporycQueue = necheporycQueue;
        this.elementsToHandle = elementsToHandle;
    }

    @Override
    public void run() {
        for (int i = 0; i < elementsToHandle; i++ ) {
            try {
                Integer thing = ivanovQueue.get();
                System.out.println("Element with value " + thing + " loaded");

                necheporycQueue.put(thing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
