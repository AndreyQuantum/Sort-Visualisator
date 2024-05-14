package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Random extends ArrayGenerator {
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> arrayToSort = new ArrayList<>();
        java.util.Random random = new java.util.Random(12345);
        for (int i = 0; i<= size-1; i++){
            arrayToSort.add(new ArrayElement(i, random.nextInt(0,maxValue)));
        }
        return arrayToSort;
    }
}
