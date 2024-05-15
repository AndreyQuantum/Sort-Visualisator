package com.azelentsov.sortVisualisator.Core.arrayGenerator;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NearlySortedArray extends ArrayGenerator{
    @Override
    public List<ArrayElement> generateArray(int size, int maxValue) {
        List<ArrayElement> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new ArrayElement(i, i));
        }

        // Randomly swap a few elements to make it "nearly sorted"
        Random random = new Random();
        int swaps = size / 5; // Number of swaps, can be adjusted
        for (int i = 0; i < swaps; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            // Swap elements at index1 and index2
            ArrayElement temp = result.get(index1);
            result.set(index1, result.get(index2));
            result.set(index2, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        NearlySortedArray nearlySortedArray = new NearlySortedArray();
        List<ArrayElement> array = nearlySortedArray.generateArray(10, 100);
    }
}
