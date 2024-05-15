package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;

import java.util.List;

public abstract class ArrayGenerator {

    public abstract List<ArrayElement> generateArray(int size, int maxValue);

    public String getName(){
        return this.getClass().getSimpleName().replace("Array", "");
    };
}
