package com.example.demo.model.math;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestResult {
    private Double sum;
    private Double sub;
    private Double multi;
    private Double div;
    private Double sqrt;
    private Double pow;
}
