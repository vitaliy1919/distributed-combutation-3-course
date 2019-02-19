package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Monk> monks = new ArrayList<>();
        monks.add(new Monk(4));
        monks.add(new Monk(1));
        monks.add(new Monk(7));
        monks.add(new Monk(14));

        Tournament tournament = new Tournament(monks);

        Monk monk = tournament.tournament();
        System.out.println(monk);
    }
}
