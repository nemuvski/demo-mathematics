package org.demo.mathematics.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class NumListRepositoryImp implements NumListRepository {
    @Override
    public List<Double> findAll() {
        return new ArrayList<>(
                Arrays.asList(10.0, 58.0, 100.0, 49.0, 10.0, 29.0, null)
        );
    }
}
