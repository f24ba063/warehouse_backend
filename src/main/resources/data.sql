
-- =========================
-- USER(利用者)
-- =========================
--INSERT INTO APP_USER (USERNAME, PASSWORD, ROLE, ENABLED)
--VALUES
--('admin', 
--'$2a$10$ZmNTpowvbc0FwWBnIxskn.1GEIXlufophfiSVkArMTBJ9LaFJ8.e6',
--'ROLE_ADMIN',
--1);

-- =========================
-- MAKER_MASTER(商品製作企業マスタ)
-- =========================
INSERT INTO MAKER_MASTER (MAKER_NAME, MAKER_ADDRESS_1, 
MAKER_ADDRESS_2, MAKER_ADDRESS_3, ACCESS, MAIL)
VALUES
('メーカーA', 'A県','B市C町', '〇〇地区X-X-X','0011223344','abcde@mail.com'),
('メーカーB', 'D県','E市F町', 'YY kkビル2階', '0055667788','abcde@mail.com'),
('メーカーC', 'G県','H市I町', '1-7-22','0123456789','abcde@mail.com'),
('メーカーD', 'J県','K市L町', '△-331','0101010101','abcde@mail.com');

-- =========================
-- FACTORY_MASTER(商品製作企業マスタ)
-- =========================
INSERT INTO FACTORY_MASTER (FACTORY_NAME, FACTORY_ADDRESS_1, 
FACTORY_ADDRESS_2, FACTORY_ADDRESS_3, ACCESS, MAIL)
VALUES
('工場A', 'A県','B市C町', '〇〇地区X-X-X','0011223344','abcde@mail.com'),
('工場B', 'D県','E市F町', 'YY kkビル2階', '0055667788','abcde@mail.com'),
('工場C', 'G県','H市I町', '1-7-22','0123456789','abcde@mail.com'),
('工場D', 'J県','K市L町', '△-331','0101010101','abcde@mail.com');

-- =========================
-- CATEGORY_MASTER(カテゴリーマスタ)
-- =========================
INSERT INTO CATEGORY_MASTER (CATEGORY)
VALUES('家電'),('マテリアル'),('生鮮'),('電子部品');

-- =========================
-- PRODUCT_MASTER(商品マスタ)
-- =========================
INSERT INTO PRODUCT_MASTER (
	PRODUCT_NAME, 
	MAKER_NAME, 
	UNIT_OF_MEASURE, 
	CATEGORY, 
	SAFETY_STOCK, 
	ORDER_QTY, 
	MIN_ORDER_QTY,
	PACKAGE_QTY,
	PALLET_QTY,
	IS_LOT_MANAGED, 
	IS_ACTIVE,
	CREATED_BY,
	LAST_UPDATED_BY
	)
VALUES 
('商品A', 'メーカーA', 'PCS', '家電', 500,  100,  200,   50,   250, 1, 1, 1, 1),
('商品B', 'メーカーB', 'KG','マテリアル',  400,   10,   30,   50,   400, 0, 1, 1, 1),
('商品C', 'メーカーC', 'M', 'マテリアル',     8,   40,  200,   20,   200, 1, 1, 1, 1),
('商品D', 'メーカーD', 'M', 'マテリアル',  5000,   50,   50,   50,   500, 1, 1, 1, 1),
('商品E', 'メーカーA', 'M', 'マテリアル',     5,    1,    5,   10,    50, 0, 1, 1, 1),
('商品F', 'メーカーA', 'M', '家電',    60,   12,   12,   12,    60, 0, 1, 1, 1),
('商品G', 'メーカーA', 'M', '生鮮',   120,   30,   30,   30,   360, 1, 1, 1, 1),
('商品H', 'メーカーB', 'M', '生鮮',     8,  500,  500,  500,  2500, 0, 1, 1, 1),
('商品I', 'メーカーB', 'M', '生鮮',     8,   50,  100,   20,   240, 1, 1, 1, 1),
('商品J', 'メーカーC', 'M', '家電',     8,   10,   30,   15,    75, 1, 1, 1, 1),
('商品K', 'メーカーC', 'M', '電子部品',     8,   50,  100,   40,   800, 0, 1, 1, 1),
('商品L', 'メーカーD', 'M', '電子部品',     8,   10,   50,   10,    30, 1, 1, 1, 1),
('商品M', 'メーカーD', 'M', '電子部品',     8,    3,   30,    6,    12, 0, 1, 1, 1),
('商品N', 'メーカーA', 'M', '電子部品',     8,    3,    3,   14,    70, 1, 1, 1, 1);

-- =========================
-- VENDOR_MASTER(仕入先企業マスタ)
-- =========================
INSERT INTO VENDOR_MASTER (VENDOR_NAME, 
	VENDOR_ADDRESS_1, VENDOR_ADDRESS_2, VENDOR_ADDRESS_3, 
	ACCESS,MAIL)
VALUES
('仕入先A', 'A県', 'B市', 'C町', '0011223344','abcde@mail.com'),
('仕入先B', 'D県', 'E市', 'F町', '0055667788', 'eddfbcde@mail.com');

-- =========================
-- CUSTOMER_MASTER(仕入先企業マスタ)
-- =========================
INSERT INTO CUSTOMER_MASTER (CUSTOMER_NAME, 
	CUSTOMER_ADDRESS_1, CUSTOMER_ADDRESS_2, CUSTOMER_ADDRESS_3, 
	ACCESS,MAIL)
VALUES
('顧客A', 'G県', 'H市', 'I町', '0123456789', 'jshtshz@vbf.com'),
('顧客B', 'J県', 'K市', 'L町', '0101010101', 'bgdnsryjyrf@bff.com');

-- =========================
-- WAREHOUSE_MASTER(倉庫マスタ)
-- =========================
INSERT INTO WAREHOUSE_MASTER (WAREHOUSE_NAME, WAREHOUSE_ADDRESS_1, 
	WAREHOUSE_ADDRESS_2, WAREHOUSE_ADDRESS_3, ACCESS, MAIL)
VALUES
('倉庫1', 'J県', 'K市', 'L町', '0101010101', 'bgdnsryjyrf@bff.com'),
('倉庫2', 'G県', 'H市', 'I町', '0123456789',  'abcde@mail.com');

-- =========================
-- LOCATION_MASTER(棚配置マスタ)
-- =========================
INSERT INTO LOCATION_MASTER (WAREHOUSE_ID, ZONE_ID, RACK_ID, SHELF_ID,
LOCATION_ID, PLACING_SIZE, MAX_CAPACITY)
VALUES
(1, 'Z01', 'R01', 'S001', '1Z01R01S001', '10mm * 100mm * 1mm', 5),
(1, 'Z01', 'R01', 'S002', '1Z01R01S002', '10mm * 100mm * 600mm',150),
(2, 'Z02', 'R01', 'S001', '2Z01R01S001', '200mm * 15mm * 1mm',200);

-- =========================
-- INCOMING_HEAD(受け取り荷物ヘッダー)
-- =========================
INSERT INTO INCOMING_HEADER (VENDOR_ID, WAREHOUSE_ID, SHIPMENT_NO,
	DOCUMENT_NO, ORDER_DATE, ORDER_STATUS,
	ORDER_PRIORITY, RECEIVE_STATUS, CREATED_BY)
VALUES
(1, 1, '123123123', 'DOC1', '2025-12-16', '発送中',
1, '未受理', 1),
(2, 2, '123456789', 'DOC2', '2002-04-03', '到着済',
2, '受入完了', 1);

-- =========================
-- INCOMING_DETAIL(受け取り荷物詳細)
-- =========================
INSERT INTO INCOMING_DETAIL (
	INCOMING_ID,LINE_NO, PRODUCT_ID, UNIT,
	INPUT_QTY, CALCULATED_QTY, RECEIVED_QTY,
	EXPIRE_DATE, QUALITY_STATUS, LOT_NO
)
VALUES
(1, 1, 1, 'パレット', 
	2, 500, 500, 
	 '2025-12-12', '合格', '11234'),
	
(1, 2, 2, '箱',
 	5, 50, 250,  
 	'2025-12-11', '要確認', '05537'),
	
(2, 1, 3, '桶',
 	8, 20, 160,  
 	'2025-12-10', '不良', '5593');

-- =========================
-- LOT_MASTER
-- =========================
INSERT INTO LOT_MASTER (PRODUCT_ID, LOT_NO, CREATION_DATE, VENDOR_ID, EXPIRATION_DATE, QC_STATUS_ID)
VALUES
(1, 'LOT001', TIMESTAMP '2025-12-16 10:00:00', 1, DATE '2026-12-16', 'A'),
(2, 'LOT002', TIMESTAMP '2025-12-16 11:00:00', 2, DATE '2026-11-30', 'A'),
(3, 'LOT003', TIMESTAMP '2025-12-15 09:00:00', 1, DATE '2026-10-31', 'B');

-- =========================
-- INVENTORY_STOCK
-- =========================
INSERT INTO INVENTORY_STOCK (PRODUCT_ID, LOCATION_ID, LOT_NO, STOCK)
VALUES
(1, '1Z01R01S001', 'LOT001', 50),
(2, '1Z01R01S002', 'LOT002', 30),
(3, '2Z01R01S001', 'LOT003', 40);


---- =========================
---- STOCK_MOVEMENT
---- =========================
--INSERT INTO STOCK_MOVEMENT (SLIP_ID, LINE_NO, MOVE_SEQ, PRODUCT_ID, LOT_NO, LOCATION_FROM, LOCATION_TO, STOCK_CHANGE)
--VALUES
--(1, 1, 1, 1, 'LOT001', '1Z01R01S001', '1Z01R01S002', -5),
--(1, 2, 1, 2, 'LOT002', '1Z01R01S002', '2Z01R01S001', -10),
--(2, 1, 1, 3, 'LOT003', '2Z01R01S001', '1Z01R01S001', -7);

---- =========================
---- SALES_HEAD
---- =========================
--INSERT INTO SALES_HEAD (CUSTOMER_ID, SHIPPING_DATE)
--VALUES
--(3, DATE '2025-12-17'),
--(4, DATE '2025-12-18');
--
---- =========================
---- SALES_DETAIL
---- =========================
--INSERT INTO SALES_DETAIL (SALES_ID, LINE_NO, PRODUCT_ID, UNIT_PRICE, ORDER_QUANTITY)
--VALUES
--(1, 1, 1, 150, 5),
--(1, 2, 2, 210, 3),
--(2, 1, 3, 160, 6);

---- =========================
---- ALLOCATION_HEAD
---- =========================
--INSERT INTO ALLOCATION_HEAD (SALES_ID, STATUS)
--VALUES
--(1, 'O'),
--(2, 'P');
--
---- =========================
---- ALLOCATION_STOCK
---- =========================
--INSERT INTO ALLOCATION_STOCK (SLIP_ID, LINE_NO, ALLOCATION_ID, PRODUCT_ID, LOT_NO, ALLOCATED_QUANTITY)
--VALUES
--(1, 1, 1, 1, 'LOT001', 5),
--(1, 2, 1, 2, 'LOT002', 3),
--(2, 1, 2, 3, 'LOT003', 6);