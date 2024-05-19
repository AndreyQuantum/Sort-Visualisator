package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Component
public class NearlySortedArray extends ArrayGenerator{
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> array = new ArrayList<>();
        Random random = new Random(12345);
        for (int i = 0; i < size; i++) {
            array.add(new ArrayElement(i, random.nextInt(0, maxValue)));
        }
        array.sort(Comparator.comparingInt(ArrayElement::value));
        random = new Random();
        int swaps = size / 5;
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            ArrayElement temp = array.get(index1);
            array.set(index1, array.get(index2));
            array.set(index2, temp);
        }
        return array;
    }

}
