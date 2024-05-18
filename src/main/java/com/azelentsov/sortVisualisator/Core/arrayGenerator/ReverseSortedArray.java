package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ReverseSortedArray extends ArrayGenerator{
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        ArrayElement[] result = new ArrayElement[size];
        for (int i = size-1; i >= 0; i--) {
            result[i] = new ArrayElement(i,size - i);
        }
        return new ArrayList<>(Arrays.asList(result));
    }

}


