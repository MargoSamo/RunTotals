package com.mariia.runtotals;

public class Run {
    private int runLength;

    public Run(int runLength) {
        this.runLength = runLength;
    }

    public int getRunLength() {
        return runLength;
    }

    @Override
    public String toString() {
        return "Run{" +
                "runLength=" + runLength +
                '}';
    }
}
