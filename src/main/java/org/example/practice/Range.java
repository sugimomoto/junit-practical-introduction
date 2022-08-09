package org.example.practice;

public class Range {
    public final double min;
    public final double max;
    public Range(double min, double max){
        this.min = min;
        this.max = max;
    }

    public boolean contains(double target){
        return (min <= target && target <= max);
    }

}
