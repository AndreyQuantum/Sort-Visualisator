package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class NearlySortedArray extends ArrayGenerator{
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new ArrayElement(i, i));
        }

        Random random = new Random();
        int swaps = size / 5;
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            ArrayElement temp = result.get(index1);
            result.set(index1, result.get(index2));
            result.set(index2, temp);
        }
        return result;
    }

}
