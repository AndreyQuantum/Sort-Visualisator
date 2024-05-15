package com.azelentsov.sortVisualisator.Spring;


import com.azelentsov.sortVisualisator.Core.sortAlgorithms.BaseSort;
import com.azelentsov.sortVisualisator.Core.arrayGenerator.ArrayGenerator;
import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controllers {
    private final List<BaseSort> algorythms;

    private final List<ArrayGenerator> arrayGenerator;

    @GetMapping("/props/")
    public List<BaseSort> getAllAlgorithmInfo(){
        return algorythms;
    }

//    TODO: add error handling if not found algorythm then return 404
    @GetMapping("/props/{sortingAlgorithmClassName}")
    public BaseSort getAlgorithmInfo(@PathVariable String sortingAlgorithmClassName) {
        return algorythms.stream()
                .filter(algorythm -> algorythm.getName().equals(sortingAlgorithmClassName))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/arrayGenerators/")
    public List<ArrayGenerator> getAllArrayTypes(){
        return arrayGenerator;
    }

    @GetMapping("/run/{sortingAlgorithmClassName}/")
    public SortingResult runAlgorithm(@PathVariable String sortingAlgorithmClassName,
                                      @RequestParam String InitArrayType,
                                      @RequestParam int arraySize,
                                      @RequestParam int maxValue) {

        List<ArrayElement> array =  arrayGenerator.stream().filter(gen -> gen.getName().equals(InitArrayType))
                                    .findFirst()
                                    .orElseThrow()
                                    .generateArray(arraySize, maxValue);
        System.out.println(array);
        return algorythms.stream()
                .filter(algorithm -> algorithm.getName().equals(sortingAlgorithmClassName))
                .findFirst()
                .orElseThrow()
                .getResult(array);
    }
}
