package com.azelentsov.sortVisualisator.SortAlgorythms;

import com.azelentsov.sortVisualisator.SortAlgorythms.records.ArrayElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGenerator {

    protected static List<ArrayElement> getRandomArray(int length, int maxNumber){
        List<ArrayElement> arrayToSort = new ArrayList<>();
        Random random = new Random(12345);
        for (int i = 0; i<= length-1; i++){
            arrayToSort.add(new ArrayElement(i, random.nextInt(0,maxNumber)));
        }
        return arrayToSort;
    }

    protected static List<ArrayElement> getSortedArray(int length){
        List<ArrayElement> arrayToSort = new ArrayList<>();
        for (int i = 0; i<= length-1; i++){
            arrayToSort.add(new ArrayElement(i, i));
        }
        return arrayToSort;
    }
}
