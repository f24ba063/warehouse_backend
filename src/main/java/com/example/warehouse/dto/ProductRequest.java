package com.example.warehouse.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "商品名は必須です")
    private String productName;

    @NotBlank(message = "メーカー名は必須です")
    private String makerName;

    @NotBlank(message = "重量単位は必須です")
    private String unitOfMeasure;

    @NotBlank(message = "カテゴリーは必須です")
    private String category;

    @Min(value = 1, message = "安全在庫は1以上である必要があります")
    private int safetyStock;

    @Min(value = 1, message = "最小発注数は1以上である必要があります")
    private int minOrderQty;

    private boolean isLotManaged;
    private boolean isActive;

    // Getter / Setter
}