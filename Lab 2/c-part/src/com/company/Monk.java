package com.company;

public class Monk implements Comparable<Monk>{
    @Override
    public int compareTo(Monk o) {
        return Integer.compare(strength, o.strength);
    }

    @Override
    public String toString() {
        return "Monk{" +
                "strength=" + strength +
                '}';
    }

    public Monk(int strength) {
        this.strength = strength;
    }

    int strength;

}
