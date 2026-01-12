package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

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
	private Long productId;
	
	@NotBlank(message = "商品名は必須です。")
	private String productName;
	
	@NotBlank(message = "メーカー名は必須です。")
	private String makerName;
	
	@NotBlank(message = "重量単位は必須です。")
	private String unitOfMeasure;
	
	@NotBlank(message = "カテゴリーは必須です。")
	private Integer safetyStock;
	
	@NotBlank(message = "安全在庫は１以上である必要があります。")
	private Integer minOrderQty;
	
	@NotBlank(message = "最小発注数は１以上である必要があります。")
	private String category;
	
	private boolean isLotManaged;
	
	private boolean isActive;
	
	private int isVisible = 1;
}
