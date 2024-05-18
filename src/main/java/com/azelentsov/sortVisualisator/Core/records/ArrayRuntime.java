package com.azelentsov.sortVisualisator.Core.records;

public record ArrayRuntime(String sortAlgorithmName,
                           String arrayType,
                           int arraySize,
                           int maxNumber,
                           long elapsedTimeMs) {
}
