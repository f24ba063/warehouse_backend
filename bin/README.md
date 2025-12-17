***

<table>1 PRODUCT_MASTER
<thead>
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> PRODUCT_ID      </td><td> BIGINT       </td><td> PK	 </td><td> 商品コード </td></tr>
  <tr><td> PRODUCT_NAME    </td><td> VARCHAR(255) </td><td> NOT NULL </td><td> 商品名 </td></tr>
  <tr><td> UNIT_OF_MEASURE </td><td> VARCHAR(10)  </td><td> NOT NULL </td><td> 計測単位 (例: PCS, 箱, ケース) [拡張性向上] </td></tr>
  <tr><td> SAFETY_STOCK    </td><td> INT          </td><td> NOT NULL </td><td> 安全在庫数 </td></tr>
  <tr><td> MIN_ORDER_QTY   </td><td> INT          </td><td> NOT NULL </td><td> 最低発注数量 </td></tr>
  <tr><td> IS_LOT_MANAGED  </td><td> BOOLEAN      </td><td> NOT NULL </td><td> ロット管理対象フラグ </td></tr>
  <tr><td> IS_ACTIVE       </td><td> BOOLEAN      </td><td> NOT NULL </td><td> 有効フラグ </td></tr>
 </tbody>
</table>

<table>
<thead>2	WAREHOUSE_MASTER
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> WAREHOUSE_ID   </td><td> CHAR(5)     </td><td> PK       </td><td> 倉庫ID </td></tr>
  <tr><td> WAREHOUSE_NAME </td><td> VARCHAR(50) </td><td> NOT NULL </td><td> 倉庫名 </td></tr>
 </tbody>
</table>

<table>
<thead>3 LOCATION_MASTER
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> WAREHOUSE_ID  </td><td> CHAR(5)  </td><td> PK, FK </td><td> 倉庫ID </td></tr>
  <tr><td> ZONE_ID       </td><td> CHAR(3)  </td><td> PK, FK </td><td> ゾーンID </td></tr>
  <tr><td> RACK_ID       </td><td> CHAR(3)  </td><td> PK, FK </td><td> ラックID </td></tr>
  <tr><td> SHELF_ID      </td><td> CHAR(5)  </td><td> PK, FK </td><td> シェルフID </td></tr>
  <tr><td> LOCATION_CODE </td><td> CHAR(16) </td><td> UNIQUE </td><td> 参照用コード (在庫実体参照キー) </td></tr>
  <tr><td> MAX_CAPACITY  </td><td> INT      </td><td>        </td><td> 最大収容数量 </td></tr>
 </tbody>
</table>	

<table>
<thead>4 PURCHASE_HEAD
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> ORDER_ID     </td><td> CHAR(12)        </td><td> PK        </td><td> 発注ID </td></tr>
  <tr><td> SUPPLIER_ID  </td><td> CHAR(4)         </td><td> FK (P.M.) </td><td> 仕入れ先ID </td></tr>
  <tr><td> ORDER_DATE   </td><td> DATE            </td><td> NOT NULL  </td><td> 発注日 [追加] </td></tr>
  <tr><td> TOTAL_AMOUNT </td><td> DECIMAL(14, 2) </td><td>            </td><td> 合計金額 (JPY) </td></tr>
 </tbody>
</table>

<table>5 PURCHASE_DETAIL
<thead>
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> ORDER_ID       </td><td> CHAR(12)       </td><td> PK, FK   </td><td> 発注ID </td></tr>
  <tr><td> LINE_NO        </td><td> INT            </td><td> PK       </td><td> 行番号 </td></tr>
  <tr><td> PRODUCT_ID     </td><td> BIGINT         </td><td> FK       </td><td> 商品ID </td></tr>
  <tr><td> UNIT_PRICE     </td><td> DECIMAL(10, 2) </td><td> NOT NULL </td><td> 発注単価 (JPY) </td></tr>
  <tr><td> ORDER_QUANTITY </td><td> INT            </td><td> NOT NULL </td><td> 数量 </td></tr>
 </tbody>
</table>

<table>6 INVENTORY_STOCK
<thead>
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> STOCK_ID      </td><td> BIGINT   </td><td> PK </td><td> 在庫実体ID (代理主キー) </td></tr>
  <tr><td> PRODUCT_ID    </td><td> BIGINT   </td><td> FK </td><td> 商品ID </td></tr>
  <tr><td> LOCATION_CODE </td><td> CHAR(16) </td><td> FK </td><td> ロケーションコード </td></tr>
  <tr><td> LOT_NO        </td><td> CHAR(20) </td><td> FK </td><td> ロット番号 </td></tr>
  <tr><td colspan="4">(複合制約) UNIQUE(PRODUCT_ID, LOCATION_CODE, LOT_NO)	在庫の唯一性の定義</td></tr>
  <tr><td> STOCK </td><td> INT </td><td> NOT NULL </td><td> 現在の在庫数 (真実) </td></tr>
 </tbody>
</table>

<table>
<thead>7 SLIP_HEAD
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> SLIP_ID </td><td> CHAR(12) </td><td> PK </td><td> 伝票番号 </td></tr>
  <tr><td> SLIP_STATE_ID </td><td> CHAR(1) </td><td> NOT NULL, FK </td><td> 伝票の状態 </td></tr>
 </tbody>
</table>


<table>
<thead>8 SLIP_DETAIL
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> SLIP_ID    </td><td> CHAR(12) </td><td> PK, FK   </td><td> 伝票番号 </td></tr>
  <tr><td> LINE_NO    </td><td> INT      </td><td> PK       </td><td> 行番号 </td></tr>
  <tr><td> PRODUCT_ID </td><td> BIGINT   </td><td> FK       </td><td> 商品ID </td></tr>
  <tr><td> QUANTITY   </td><td> INT      </td><td> NOT NULL </td><td> 処理数量 </td></tr>
 </tbody>
</table>


<table>
<thead>9 STOCK_MOVEMENT
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> MOVEMENT_ID </td><td> BIGINT   </td><td> PK </td><td> 移動履歴ID (代理主キー) </td></tr>
  <tr><td> SLIP_ID     </td><td> CHAR(12) </td><td> FK </td><td> 元伝票ID </td></tr>
  <tr><td> LINE_NO     </td><td> INT      </td><td> FK </td><td> 元伝票行番号 </td></tr>
  <tr><td> MOVE_SEQ    </td><td> INT      </td><td>    </td><td> 移動時の連番 </td></tr>
  <tr><td> PRODUCT_ID  </td><td> BIGINT   </td><td> FK </td><td> 商品ID (分析・監査対応) </td></tr>
  <tr><td> LOT_NO </td><td> CHAR(20) </td><td> NOT NULL, FK </td><td> 移動ロット </td></tr>
  <tr><td> LOCATION_FROM </td><td> CHAR(16) </td><td> FK </td><td> 移動元 [NULL許容] </td></tr>
  <tr><td> LOCATION_TO </td><td> CHAR(16) </td><td> FK </td><td> 移動先 [NULL許容] </td></tr>
  <tr><td> STOCK_CHANGE </td><td> INT </td><td> NOT NULL </td><td> 増減量 (IN=+ / OUT=-) </td></tr>
  <tr><td colspan="4"> (複合制約)	UNIQUE(SLIP_ID, LINE_NO, MOVE_SEQ)	履歴ログの一意性定義   </td></tr>
 </tbody>
</table>

<table>
<thead>10 ALLOCATION_STOCK
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> SLIP_ID            </td><td> CHAR(12) </td><td> PK, FK   </td><td> 引当元伝票ID </td></tr>
  <tr><td> LINE_NO            </td><td> INT      </td><td> PK, FK   </td><td> 引当元行番号 </td></tr>
  <tr><td> ALLOCATION_ID      </td><td> BIGINT   </td><td> PK       </td><td> 引当識別子 </td></tr>
  <tr><td> LOT_NO             </td><td> CHAR(20) </td><td> FK	    </td><td> 引当対象ロット </td></tr>
  <tr><td> ALLOCATED_QUANTITY </td><td> INT      </td><td> NOT NULL </td><td> 引当済み数量
 </td></tr>
 </tbody>
</table>

<table>
<thead>11 LOT_COST
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> PRODUCT_ID         </td><td> BIGINT         </td><td> PK, FK   </td><td> ロットの対象商品 </td></tr>
  <tr><td> LOT_NO             </td><td> CHAR(20)       </td><td> PK, FK   </td><td> ロット番号 </td></tr>
  <tr><td> CONVERTED_COST_JPY </td><td> DECIMAL(14, 2) </td><td> NOT NULL </td><td> 日本円換算後の原価 (JPY) </td></tr>
 </tbody>
</table>

<table>
<thead>12 LOT_MASTER
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> PRODUCT_ID </td><td> BIGINT </td><td> PK, FK </td><td> ロットの対象商品 </td></tr>
  <tr><td> LOT_NO </td><td> CHAR(20) </td><td> PK </td><td> ロット番号 </td></tr>
  <tr><td> CREATION_DATE </td><td> DATETIME </td><td> NOT NULL </td><td> ロット生成日時 (入庫時) </td></tr>
  <tr><td> SUPPLIER_ID </td><td> CHAR(4) </td><td> FK (P.M.) </td><td> 仕入先ID </td></tr>
  <tr><td> EXPIRATION_DATE </td><td> DATE </td><td>  </td><td> ロット有効期限 </td></tr>
  <tr><td> QC_STATUS_ID </td><td> CHAR(1) </td><td> NOT NULL </td><td> 品質管理ステータス </td></tr>
 </tbody>
</table>

<table>
<thead>13 PARTNER_MASTER
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> PARTNER_ID   </td><td> CHAR(4)      </td><td> PK       </td><td> 取引先ID (仕入先、得意先共通) </td></tr>
  <tr><td> PARTNER_TYPE </td><td> CHAR(1)      </td><td> NOT NULL </td><td> 種別 (S:仕入先, C:得意先, B:両方) </td></tr>
  <tr><td> PARTNER_NAME </td><td> VARCHAR(100) </td><td> NOT NULL </td><td> 取引先名 </td></tr>
 </tbody>
</table>

<table>
<thead>
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>14 SALES_HEAD
  <tr><td> SALES_ID      </td><td> CHAR(12) </td><td> PK        </td><td> 出荷伝票ID </td></tr>
  <tr><td> CUSTOMER_ID   </td><td> CHAR(4)  </td><td> FK (P.M.) </td><td> 得意先ID </td></tr>
  <tr><td> SHIPPING_DATE </td><td> DATE     </td><td> NOT NULL  </td><td> 出荷予定日 </td></tr>
 </tbody>
</table>

<table>
<thead>15 SALES_DETAIL
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> SALES_ID </td><td> CHAR(12) </td><td> PK, FK </td><td> 出荷伝票ID </td></tr>
  <tr><td> LINE_NO </td><td> INT </td><td> PK </td><td> 行番号 </td></tr>
  <tr><td> PRODUCT_ID </td><td> BIGINT </td><td> FK </td><td> 商品ID </td></tr>
  <tr><td> UNIT_PRICE </td><td> DECIMAL(10, 2) </td><td> NOT NULL </td><td> 販売単価 (JPY) </td></tr>
  <tr><td> ORDER_QUANTITY </td><td> INT </td><td> NOT NULL </td><td> 注文数量 </td></tr>
 </tbody>
</table>

<table>
<thead>16 ALLOCATION_HEAD
 <tr><th>カラム名</th><th>型</th><th>制約</th><th>説明</tr>
</thead>
 <tbody>
  <tr><td> ALLOCATE_HEAD_ID </td><td> CHAR(12) </td><td> PK       </td><td> 引当ヘッダID </td></tr>
  <tr><td> SALES_ID         </td><td> CHAR(12) </td><td> FK       </td><td> 元の出荷伝票ID </td></tr>
  <tr><td> STATUS           </td><td> CHAR(1)  </td><td> NOT NULL </td><td> 引当ステータス </td></tr>
 </tbody>
</table>

