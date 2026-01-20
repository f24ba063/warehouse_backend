
-- =========================
-- USER(利用者)
-- =========================
INSERT INTO APP_USER (USERNAME, PASSWORD, ROLE, ENABLED)
VALUES
('admin', 
'$2a$10$ZmNTpowvbc0FwWBnIxskn.1GEIXlufophfiSVkArMTBJ9LaFJ8.e6',
'ROLE_ADMIN',
1);

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
	IS_LOT_MANAGED, 
	IS_ACTIVE,
	CREATED_BY,
	LAST_UPDATED_BY
	)
VALUES 
('商品A', 'メーカーA', 'PCS', 'カテゴリー1', 10,2,   2,    1, 1, 1, 1),
('商品B', 'メーカーB', 'KG', 'カテゴリー2',  5, 500, 1000, 0, 1, 1, 1),
('商品C', 'メーカーC', 'M', 'カテゴリー3',   8, 40,  200,  1, 1, 1, 1),
('商品D', 'メーカーD', 'M', 'カテゴリー3',   8, 3,   6,    1, 1, 1, 1),
('商品E', 'メーカーA', 'M', 'カテゴリー3',   8, 3,   3,    0, 1, 1, 1),
('商品F', 'メーカーA', 'M', 'カテゴリー1',   8, 40,  40,   0, 1, 1, 1),
('商品G', 'メーカーA', 'M', 'カテゴリー2',   8, 2000,6000, 1, 1, 1, 1),
('商品H', 'メーカーB', 'M', 'カテゴリー2',   8, 500, 500,  0, 1, 1, 1),
('商品I', 'メーカーB', 'M', 'カテゴリー3',   8, 50,  100,  1, 1, 1, 1),
('商品J', 'メーカーC', 'M', 'カテゴリー1',   8, 10,  30,   1, 1, 1, 1),
('商品K', 'メーカーC', 'M', 'カテゴリー4',   8, 50,  100,  0, 1, 1, 1),
('商品L', 'メーカーD', 'M', 'カテゴリー6',   8, 10,  50,   1, 1, 1, 1),
('商品M', 'メーカーD', 'M', 'カテゴリー7',   8, 3,   30,   0, 1, 1, 1),
('商品N', 'メーカーA', 'M', 'カテゴリー3',   8, 3,   3,    1, 1, 1, 1);

-- =========================
-- PARTNER_MASTER(商品受け取り元企業・送り先企業マスタ)
-- =========================
INSERT INTO PARTNER_MASTER (PARTNER_TYPE, PARTNER_NAME, 
	PARTNER_ADDRESS_1, PARTNER_ADDRESS_2, PARTNER_ADDRESS_3, 
	ACCESS,MAIL)
VALUES
('S', '仕入先A', 'A県', 'B市', 'C町', '0011223344','abcde@mail.com'),
('S', '仕入先B', 'D県', 'E市', 'F町', '0055667788', 'eddfbcde@mail.com'),
('C', '顧客A', 'G県', 'H市', 'I町', '0123456789', 'jshtshz@vbf.com'),
('C', '顧客B', 'J県', 'K市', 'L町', '0101010101', 'bgdnsryjyrf@bff.com');

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
LOCATION_ID, PLACING_SIZE, MAX_WEIGHT_KG)
VALUES
(1, 'Z01', 'R01', 'S001', '1Z01R01S001', '10mm * 100mm * 1mm', 5),
(1, 'Z01', 'R01', 'S002', '1Z01R01S002', '10mm * 100mm * 600mm',150),
(2, 'Z02', 'R01', 'S001', '2Z01R01S001', '200mm * 15mm * 1mm',200);

-- =========================
-- INCOMING_HEAD(受け取り荷物ヘッダー)
-- =========================
INSERT INTO INCOMING_HEAD (SUPPLIER_ID, WAREHOUSE_ID, SHIPMENT_NO,
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
	ORDER_QTY, RECEIVED_QTY, STORAGE_LOCATION,
	EXPIRE_DATE, ITEM_WEIGHT, VOLUME, QUALITY_STATUS,
	LOT_NO
)
VALUES
(1, 1, 1, 'パレット', 
	10, 10, '1Z01R01S001',
	 '2025-12-12', 12, '10mm * 100mm * 10mm','合格', 
	 '11234'),
	
(1, 2, 2, '箱',
 	5, 3, '1Z01R01S002', 
 	'2025-12-11', 24, '5mm * 45cm * 120mm', '要確認', 
 	'05537'),
	
(2, 1, 3, '桶',
 	8, 8, '2Z01R01S001', 
 	'2025-12-10', 36, '200mm * 200 mm * 200mm', '不良', 
 	'5593');

-- =========================
-- LOT_MASTER
-- =========================
INSERT INTO LOT_MASTER (PRODUCT_ID, LOT_NO, CREATION_DATE, SUPPLIER_ID, EXPIRATION_DATE, QC_STATUS_ID)
VALUES
(1, 'LOT001', TIMESTAMP '2025-12-16 10:00:00', 1, DATE '2026-12-16', 'A'),
(2, 'LOT002', TIMESTAMP '2025-12-16 11:00:00', 2, DATE '2026-11-30', 'A'),
(3, 'LOT003', TIMESTAMP '2025-12-15 09:00:00', 1, DATE '2026-10-31', 'B');

-- =========================
-- LOT_COST
-- =========================
INSERT INTO LOT_COST (PRODUCT_ID, LOT_NO, CONVERTED_COST_JPY)
VALUES
(1, 'LOT001', 1200),
(2, 'LOT002', 1500),
(3, 'LOT003', 1100);

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