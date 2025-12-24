package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LOCATION_MASTER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private Long warehouseId;
    private String zoneId;
    private String rackId;
    private String shelfId;

    @Id
    private String locationCode;  // 主キーとして設定

    private int maxCapacity;
    private int isVisible = 1;
}