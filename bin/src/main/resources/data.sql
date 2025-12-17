-- =========================
-- PRODUCT_MASTER
-- =========================
INSERT INTO PRODUCT_MASTER (PRODUCT_NAME, UNIT_OF_MEASURE, SAFETY_STOCK, MIN_ORDER_QTY, IS_LOT_MANAGED, IS_ACTIVE)
VALUES 
('商品A', 'PCS', 10, 1, 1, 1),
('商品B', 'KG', 5, 2, 0, 1),
('商品C', 'M', 8, 3, 1, 1);

-- =========================
-- PARTNER_MASTER
-- =========================
INSERT INTO PARTNER_MASTER (PARTNER_TYPE, PARTNER_NAME)
VALUES
('S', '仕入先A'),
('S', '仕入先B'),
('C', '顧客A'),
('C', '顧客B');

-- =========================
-- WAREHOUSE_MASTER
-- =========================
INSERT INTO WAREHOUSE_MASTER (WAREHOUSE_NAME)
VALUES
('倉庫1'),
('倉庫2');

-- =========================
-- LOCATION_MASTER
-- =========================
INSERT INTO LOCATION_MASTER (WAREHOUSE_ID, ZONE_ID, RACK_ID, SHELF_ID, LOCATION_CODE, MAX_CAPACITY)
VALUES
(1, 'Z01', 'R01', 'S001', 'LOC000000000001', 100),
(1, 'Z01', 'R01', 'S002', 'LOC000000000002', 150),
(2, 'Z02', 'R01', 'S001', 'LOC000000000003', 200);

-- =========================
-- PURCHASE_HEAD
-- =========================
INSERT INTO PURCHASE_HEAD (SUPPLIER_ID, ORDER_DATE, TOTAL_AMOUNT)
VALUES
(1, DATE '2025-12-16', 10000),
(2, DATE '2025-12-15', 5000);

-- =========================
-- PURCHASE_DETAIL
-- =========================
INSERT INTO PURCHASE_DETAIL (ORDER_ID, LINE_NO, PRODUCT_ID, UNIT_PRICE, ORDER_QUANTITY)
VALUES
(1, 1, 1, 100, 10),
(1, 2, 2, 200, 5),
(2, 1, 3, 150, 8);

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
INSERT INTO INVENTORY_STOCK (PRODUCT_ID, LOCATION_CODE, LOT_NO, STOCK)
VALUES
(1, 'LOC000000000001', 'LOT001', 50),
(2, 'LOC000000000002', 'LOT002', 30),
(3, 'LOC000000000003', 'LOT003', 40);

-- =========================
-- SLIP_HEAD
-- =========================
INSERT INTO SLIP_HEAD (SLIP_STATE_ID)
VALUES
('N'),
('P');

-- =========================
-- SLIP_DETAIL
-- =========================
INSERT INTO SLIP_DETAIL (SLIP_ID, LINE_NO, PRODUCT_ID, QUANTITY)
VALUES
(1, 1, 1, 5),
(1, 2, 2, 10),
(2, 1, 3, 7);

-- =========================
-- STOCK_MOVEMENT
-- =========================
INSERT INTO STOCK_MOVEMENT (SLIP_ID, LINE_NO, MOVE_SEQ, PRODUCT_ID, LOT_NO, LOCATION_FROM, LOCATION_TO, STOCK_CHANGE)
VALUES
(1, 1, 1, 1, 'LOT001', 'LOC000000000001', 'LOC000000000002', -5),
(1, 2, 1, 2, 'LOT002', 'LOC000000000002', 'LOC000000000001', -10),
(2, 1, 1, 3, 'LOT003', 'LOC000000000003', 'LOC000000000001', -7);

-- =========================
-- SALES_HEAD
-- =========================
INSERT INTO SALES_HEAD (CUSTOMER_ID, SHIPPING_DATE)
VALUES
(3, DATE '2025-12-17'),
(4, DATE '2025-12-18');

-- =========================
-- SALES_DETAIL
-- =========================
INSERT INTO SALES_DETAIL (SALES_ID, LINE_NO, PRODUCT_ID, UNIT_PRICE, ORDER_QUANTITY)
VALUES
(1, 1, 1, 150, 5),
(1, 2, 2, 210, 3),
(2, 1, 3, 160, 6);

-- =========================
-- ALLOCATION_HEAD
-- =========================
INSERT INTO ALLOCATION_HEAD (SALES_ID, STATUS)
VALUES
(1, 'O'),
(2, 'P');

-- =========================
-- ALLOCATION_STOCK
-- =========================
INSERT INTO ALLOCATION_STOCK (SLIP_ID, LINE_NO, ALLOCATION_ID, PRODUCT_ID, LOT_NO, ALLOCATED_QUANTITY)
VALUES
(1, 1, 1, 1, 'LOT001', 5),
(1, 2, 1, 2, 'LOT002', 3),
(2, 1, 2, 3, 'LOT003', 6);