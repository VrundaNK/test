package com.company.util;

/**
 * Created by vnagpurkar on 6/26/16.
 */
public class Frequency{

    char c;
    int frequency;

    public Frequency(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getCharacter() {
        return this.c;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frequency frequency1 = (Frequency) o;

        if (c != frequency1.c) return false;
        return frequency == frequency1.frequency;

    }

    @Override
    public int hashCode() {
        int result = (int) c;
        result = 31 * result + frequency;
        return result;
    }

}
