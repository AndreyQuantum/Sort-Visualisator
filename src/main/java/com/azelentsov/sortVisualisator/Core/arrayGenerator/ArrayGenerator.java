package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;

import java.util.List;

public interface ArrayGenerator {

    public List<ArrayElement> generateArray(int size, int maxValue);
}
