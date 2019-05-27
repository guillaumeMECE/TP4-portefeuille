package model;

import model.Fond;

public class ComparableImplemente extends Fond implements Comparable<Fond> {

    @Override
    public int compareTo(Fond f) {
        int i;
        if (amount < f.getAmount()) {
            i = -1;
        } else if (amount > f.getAmount()) {
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

    public boolean equals(Fond f) {
        boolean isEqual;
        isEqual = (amount == f.getAmount());
        return isEqual;
    }
}