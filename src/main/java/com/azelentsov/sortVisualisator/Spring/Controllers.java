package com.azelentsov.sortVisualisator.Spring;


import com.azelentsov.sortVisualisator.Core.sortAlgorithms.BaseSort;
import com.azelentsov.sortVisualisator.Core.arrayGenerator.ArrayGenerator;
import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controllers {
    private final List<BaseSort> algorithms;

    private final List<ArrayGenerator> arrayGenerator;

    @GetMapping("/props")
    public Map<String, Map<String,String>> getAllAlgorithmInfo(){
        Map<String, Map<String,String>> result = new HashMap<>();
        algorithms.forEach(alg -> result.put(alg.getName(), alg.getProps()));
        return result;
    }

    @GetMapping("/props/name")
    public List<String> getAllAlgorithmName(){
        return algorithms.stream().map(BaseSort::getName).toList();
    }

//    TODO: add error handling if not found algorythm then return 404
    @GetMapping("/props/{sortingAlgorithmClassName}")
    public BaseSort getAlgorithmInfo(@PathVariable String sortingAlgorithmClassName) {
        return algorithms.stream()
                .filter(algorythm -> algorythm.getName().equals(sortingAlgorithmClassName))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("array/types")
    public List<String> getAllArrayTypes(){
        return arrayGenerator.stream().map(ArrayGenerator::getName).toList();
    }

    @GetMapping("/run/{sortingAlgorithmClassName}")
    public SortingResult runAlgorithm(@PathVariable String sortingAlgorithmClassName,
                                      @RequestParam String type,
                                      @RequestParam int size,
                                      @RequestParam int maxValue) {

        List<ArrayElement> array =  arrayGenerator.stream().filter(gen -> gen.getName().equals(type))
                                    .findFirst()
                                    .orElseThrow()
                                    .generateArray(size, maxValue);
        return algorithms.stream()
                .filter(algorithm -> algorithm.getName().equals(sortingAlgorithmClassName))
                .findFirst()
                .orElseThrow()
                .getResult(array);
    }
//
//    @GetMapping("/props/runtime")
//    public
}
