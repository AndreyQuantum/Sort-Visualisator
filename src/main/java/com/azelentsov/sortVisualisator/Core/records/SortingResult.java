package com.azelentsov.sortVisualisator.Core.records;

import java.util.List;

public record SortingResult(List<IterationResult> results, String timeElapsed) {
}
