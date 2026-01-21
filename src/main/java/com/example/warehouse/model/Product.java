package com.example.warehouse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//PRODUCT_MASTERのテーブル定義。このクラスをデータベースと紐づけるに際して
//クラス名とテーブル名が違うとそのままではエラーが出るので
//@Tableで対応するテーブルを指定すること
@Entity
@Table(name="PRODUCT_MASTER",
 uniqueConstraints = {
		 @UniqueConstraint(columnNames = "PRODUCT_NAME")
 })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "MAKER_NAME")
	private String makerName;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "UNIT_OF_MEASURE")
	private String unitOfMeasure;
	
	@Column(name = "SAFETY_STOCK")
	private Integer safetyStock;
	
	@Column(name = "ORDER_QTY")
	private Integer orderQty;
	
	@Column(name = "MIN_ORDER_QTY")
	private Integer minOrderQty;
	
	@Column(name = "PACKAGE_QTY")
	private Integer packageQty;
	
	@Column(name = "PALLET_QTY")
	private Integer palletQty;
	
	@Column(name = "IS_LOT_MANAGED")
	private Integer isLotManaged;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive;
	
	@Column(name = "IS_VISIBLE")
	private Integer isVisible = 1;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@Column(name = "CREATED_BY")
	private long createdBy;
	
	@Column(name = "LAST_UPDATED_AT")
	private LocalDateTime lastUpdatedAt;
	
	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedBy;
	
}
