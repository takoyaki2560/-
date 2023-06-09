# DB期末後端

## 技術棧

* **系統框架: springboot**
* **架構: Mvc**
* **設計風格: Restful api**
* **身分驗證系統: Jwt**
* **數據庫: mySql**
* **數據庫運行環境: mysql - Official Docker Image: 8.0**
* **框架:**
1. **身分驗證框架: spring sercurity**
2. **jwt 加解密框架: jjwt**
3. **持久層框架: mybaits**

## apis
**path:**

**1. login handler**
* /check
* /register
* /perform_login

**2. apis**
* /api/Browse
* /api/Material 
* /api/Product 
* /api/Record 
* /api/Transaction 
* /api/Use 

**通用:**

    1.add
    path: ${api path}/add
    method: post
    header: Authorization: Bearer${jwt token}
    body: 類型:json, key:該數據schema欄位, value:欄位值
    descript: 插入數據
    
    
    2.findAll
    path: ${api path}/findAll
    method: get
    header: Authorization: Bearer${jwt token}
    descript: 全表查詢
    
    3.findbyId
    path: ${api path}/find${schema name}NameById/?id={$id}
    method: get
    header: Authorization: Bearer${jwt token}
    descript: 依據數據id查詢相應name
