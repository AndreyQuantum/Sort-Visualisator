package com.azelentsov.sortVisualisator.Core.sortAlgorithms;

import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MergeSort extends BaseSort {

//
@Override
protected void run() {
    mergeSort(0, listToSort.size() - 1);
}

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        List<ArrayElement> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (listToSort.get(i).compareTo(listToSort.get(j)) <= 0) {
                temp.add(listToSort.get(i++));
            } else {
                temp.add(listToSort.get(j++));
            }
        }

        while (i <= mid) {
            saveArrayBeforeIteration();
            highlightVariable(i,"i");
            highlightVariable(i+1,"i+1");
            temp.add(listToSort.get(i++));

            saveArrayAfterIteration();
        }

        while (j <= right) {
            saveArrayBeforeIteration();
            highlightVariable(j,"j");
            highlightVariable(j+1,"j++");
            temp.add(listToSort.get(j++));

            saveArrayAfterIteration();
        }

        for (i = left; i <= right; i++) {
            saveArrayBeforeIteration();
            highlightVariable(i,"i");
            highlightVariable(i-left,"i-left");
            listToSort.set(i, temp.get(i - left));

            saveArrayAfterIteration();
        }
    }


    @Override
    protected void populateProps() {

    }
}
