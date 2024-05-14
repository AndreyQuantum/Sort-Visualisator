package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Sorted extends ArrayGenerator {

    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(new ArrayElement(i, i));
        }
        return array;
    }

}
