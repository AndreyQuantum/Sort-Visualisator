package com.azelentsov.sortVisualisator.Spring;


import com.azelentsov.sortVisualisator.Core.SortingArrayService;
import com.azelentsov.sortVisualisator.Core.records.ArrayRuntime;
import com.azelentsov.sortVisualisator.Core.records.SortingResultWithStats;
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
    private final ArrayRuntimeRepository arrayRuntimeRepository;
    private final ArrayRuntimeRepository arrayRuntimeEntityRepository;
    private final SortingArrayService sortingArrayService;

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


        SortingResultWithStats runningResult = sortingArrayService.getSortResult(type, sortingAlgorithmClassName, size, maxValue);
        if (!arrayRuntimeEntityRepository
                .existsBySortAlgorithmNameAndArrayTypeAndArraySizeAndMaxValue(sortingAlgorithmClassName,type, size,maxValue)){
            ArrayRuntime runtime = runningResult.arrayRuntime();
            ArrayRuntimeEntity runtimeEntity = Convertors.arrayRuntimeToArrayRuntimeEntity(runtime);
            arrayRuntimeRepository.save(runtimeEntity);
        }
        return runningResult.sortingResult();
    }
//
    @GetMapping("/props/runtime")
    public List<ArrayRuntimeEntity> getAllRuntimeStats(){
        return arrayRuntimeRepository.findAll();
    }

    @GetMapping("/props/runtime/{sortingAlgorithmClassName}")
    public List<ArrayRuntimeEntity> getAllRuntimeStats(@PathVariable String sortingAlgorithmClassName){
        return arrayRuntimeRepository.findBySortAlgorithmName(sortingAlgorithmClassName);
    }

    @DeleteMapping("/props/runtime")
    public void deleteAllRuntimeStats() {
        arrayRuntimeRepository.deleteAll();
    }


}
