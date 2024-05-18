package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReverseSortedArray extends ArrayGenerator{
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> array = new ArrayList<>();
        Random random = new Random(12345);
        for (int i = 0; i < size; i++) {
            array.add(new ArrayElement(i, random.nextInt(0, maxValue)));
        }
        array.sort(Comparator.comparingInt(ArrayElement::value).reversed());
        return array;
    }

}


