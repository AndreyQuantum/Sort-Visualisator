package com.azelentsov.sortVisualisator.Spring;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrayRuntimeRepository extends JpaRepository<ArrayRuntimeEntity, Integer> {
    List<ArrayRuntimeEntity> findBySortAlgorithmName(@NonNull String sortAlgorithmName);


}
