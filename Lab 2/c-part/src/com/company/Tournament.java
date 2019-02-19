package com.company;

import java.util.ArrayList;

public class Tournament {
    private ArrayList<Monk> monks;
    static class Helper implements Runnable {
        Tournament tournament;
        Monk monk;
        int l; int r;

        public Helper(Tournament tournament, int l, int r) {
            this.tournament = tournament;
            this.l = l;
            this.r = r;
        }

        @Override
        public void run() {
            monk = tournament.tournament(l, r);
        }
    }
    public Tournament(ArrayList<Monk> monks) {
        this.monks = monks;
    }
    private Monk tournament(int l, int r) {
        if (l >= r)
            return null;
        if (l + 1 == r)
            return monks.get(l);
        int m = (l + r) / 2;
        Helper helper = new Helper(this, m + 1, r);
        Thread thread = new Thread(helper);
        thread.start();
        Monk monk = tournament(l, m);
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (monk == null)
            return helper.monk;
        if (helper.monk == null)
            return monk;
        return (monk.compareTo(helper.monk) >0 ? monk : helper.monk);


    }
    public Monk tournament() {
        return tournament(0, monks.size());
    }
}
