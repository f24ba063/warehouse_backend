package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//PRODUCT_MASTERのテーブル定義。このクラスをデータベースと紐づけるに際して
//クラス名とテーブル名が違うとそのままではエラーが出るので
//@Tableで対応するテーブルを指定すること
@Entity
@Table(name="WAREHOUSE_MASTER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long warehouseId;
	
	private String warehouseName;
	private int isVisible = 1;
}