package org.example.formsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FertilizersAndPesticides {
    private Integer id;
    private Integer farmId;
    private String type;
    private Date applicationDate;
    private Double quantity;
}
