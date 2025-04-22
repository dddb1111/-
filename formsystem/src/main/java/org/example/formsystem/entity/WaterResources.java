package org.example.formsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WaterResources {
    private Integer id;
    private Integer farmId;
    private String waterSource;
    private Double usageRate;
    private Date lastChecked;
}