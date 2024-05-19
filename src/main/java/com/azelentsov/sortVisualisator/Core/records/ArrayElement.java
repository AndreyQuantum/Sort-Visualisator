package com.azelentsov.sortVisualisator.Core.records;

public record ArrayElement(int initIndex, int value) implements Comparable<ArrayElement> {
    @Override
    public int compareTo(ArrayElement o) {
        return Integer.compare(this.value, o.value);
    }
}
