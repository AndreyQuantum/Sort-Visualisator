package com.azelentsov.sortVisualisator.Spring;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@ToString
public class ArrayRuntimeEntity implements Comparable<ArrayRuntimeEntity> {
    @Override
    public int compareTo(ArrayRuntimeEntity o) {
        return sortAlgorithmName.compareTo(o.sortAlgorithmName) +
                Long.compare(elapsedTimeMs, o.elapsedTimeMs);
    }

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    private String sortAlgorithmName;

    private String arrayType;

    private int arraySize;

    private int maxValue;

    private long elapsedTimeMs;

}
