package com.mariia.runtotals;

public class ReversePushUp {
    private int upExercise;

    public ReversePushUp(int upExercise) {
        this.upExercise = upExercise;
    }

    public int getUpExercise() {
        return upExercise;
    }

    @Override
    public String toString() {
        return "ReversePushUp{" +
                "upExercise=" + upExercise +
                '}';
    }
}
