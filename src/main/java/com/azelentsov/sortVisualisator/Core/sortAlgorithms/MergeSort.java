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
            highlightBorders(left, mid, right);
            temp.add(listToSort.get(i++));

            saveArrayAfterIteration();
        }

        while (j <= right) {
            saveArrayBeforeIteration();
            highlightVariable(j,"j");
            highlightVariable(j+1,"j++");
            highlightBorders(left, mid, right);
            temp.add(listToSort.get(j++));

            saveArrayAfterIteration();
        }

        for (i = left; i <= right; i++) {
            saveArrayBeforeIteration();
            highlightVariable(i,"i");
            highlightVariable(left,"left");
            highlightVariable(i-left,"i-left");
            highlightBorders(left, mid, right);
            listToSort.set(i, temp.get(i - left));

            saveArrayAfterIteration();
        }
    }

    private void highlightBorders(int left, int mid, int right) {
        highlightVariable(right,"right");
        highlightVariable(mid,"mid");
        highlightVariable(left,"left");
    }


    @Override
    protected void populateProps() {
        props.put("Time Complexity (Average)", "O(n log n)");
        props.put("Time Complexity (Best)", "O(n log n)");
        props.put("Time Complexity (Worst)", "O(n log n)");
        props.put("Space Complexity", "O(n)");
        props.put("Stable", "Yes");
        props.put("In-Place", "No");
        props.put("Adaptive", "No");
        props.put("First Published", "1945");
        props.put("Swaps", "N/A (merges rather than swaps)");
        props.put("Passes", "O(log n)");
    }
}
