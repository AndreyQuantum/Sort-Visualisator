package com.azelentsov.sortVisualisator.Core;

import com.azelentsov.sortVisualisator.Core.arrayGenerator.ArrayGenerator;
import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.ArrayRuntime;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;
import com.azelentsov.sortVisualisator.Core.records.SortingResultWithStats;
import com.azelentsov.sortVisualisator.Core.sortAlgorithms.BaseSort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortingArrayService {

    private List<ArrayGenerator> arrayGenerator;
    private List<BaseSort> sortingAlgorithms;

    public SortingArrayService(List<ArrayGenerator> arrayGenerator, List<BaseSort> sortingAlgorithms) {
        this.arrayGenerator = arrayGenerator;
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public SortingResultWithStats getSortResult(String arrayTypeName, String sortingAlgorithmClassName, int size, int maxValue){
        List<ArrayElement> listToSort =  arrayGenerator.stream().filter(gen -> gen.getName().equals(arrayTypeName))
                .findFirst()
                .orElseThrow()
                .generateArray(size, maxValue);
        SortingResult sortingResult = sortingAlgorithms.stream()
                .filter(algorithm -> algorithm.getName().equals(sortingAlgorithmClassName))
                .findFirst()
                .orElseThrow()
                .getResult(listToSort);
        ArrayRuntime arrayRuntime = new ArrayRuntime(sortingAlgorithmClassName,arrayTypeName, size,maxValue,sortingResult.timeElapsed());
        return new SortingResultWithStats(sortingResult,arrayRuntime);
    }
}
