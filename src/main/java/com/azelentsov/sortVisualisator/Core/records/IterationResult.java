package com.azelentsov.sortVisualisator.Core.records;


import java.util.HashMap;
import java.util.Map;

public record IterationResult(Map<Integer,String> indexesToFocusOn,
                              int[] arrayBeforeIteration,
                              int[] arrayAfterIteration,
                              IterationActionResult actionResult) {
}
