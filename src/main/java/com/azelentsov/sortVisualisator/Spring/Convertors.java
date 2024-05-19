package com.azelentsov.sortVisualisator.Spring;


import com.azelentsov.sortVisualisator.Core.records.ArrayRuntime;
import org.springframework.stereotype.Component;

@Component
public class Convertors {

    public static ArrayRuntimeEntity arrayRuntimeToArrayRuntimeEntity(ArrayRuntime runtime) {
        return  ArrayRuntimeEntity.builder()
                .arraySize(runtime.arraySize())
                .arrayType(runtime.arrayType())
                .sortAlgorithmName(runtime.sortAlgorithmName())
                .maxValue(runtime.maxNumber())
                .elapsedTimeMs(runtime.elapsedTimeMs())
                .build();
    }
}
