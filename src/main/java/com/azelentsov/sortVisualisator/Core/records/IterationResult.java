package com.azelentsov.sortVisualisator.Core.records;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record IterationResult(Map<Integer, List<String>> indexesToFocusOn,
                              Map<String, Integer> indexesToDisplay,
                              int[] arrayBeforeIteration,
                              int[] arrayAfterIteration,
                              IterationActionResult actionResult) {
}
