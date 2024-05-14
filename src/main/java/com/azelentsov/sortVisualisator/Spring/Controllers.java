package com.azelentsov.sortVisualisator.Spring;


import com.azelentsov.sortVisualisator.Core.BaseSort;
import com.azelentsov.sortVisualisator.Core.arrayGenerator.ArrayGenerator;
import com.azelentsov.sortVisualisator.Core.records.ArrayElement;
import com.azelentsov.sortVisualisator.Core.records.SortingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controllers {
    private final List<BaseSort> algorythms;

    private final List<ArrayGenerator> arrayGenerator;

    @GetMapping("/props/")
    public List<BaseSort> getAlgorythmsInfo(){
        return algorythms;
    }

//    TODO: add error handling if not found algorythm then return 404
    @GetMapping("/props/{name}")
    public BaseSort getAlgorythmInfo(@PathVariable String name) {
        return algorythms.stream()
                .filter(algorythm -> algorythm.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/run/{name}/{InitArrayType}")
    public SortingResult runAlgorythm(@PathVariable String name,
                                      @PathVariable String InitArrayType) {
        List<ArrayElement> array =  arrayGenerator.stream().filter(gen -> gen.getName().equals(InitArrayType))
                                    .findFirst()
                                    .orElseThrow()
                                    .generateArray(5, 5);
        System.out.println(array);
        return algorythms.stream()
                .filter(algorythm -> algorythm.getName().equals(name))
                .findFirst()
                .orElseThrow()
                .getResult(array);
    }
}
