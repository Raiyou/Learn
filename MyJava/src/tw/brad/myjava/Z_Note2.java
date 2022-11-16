package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class Z_Note2 {
public static void main(String[] args) {
// Storage
try {
	
	// 應用 Properties 儲存 key-value 內容
	Properties prop = new Properties();
	prop.put("user", "root");
	prop.put("password", "root");
	// 連結資料庫
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eeit53", prop);
	// 操作資料庫的接口
	Statement stmt = conn.createStatement(); 
	// 關閉資料庫連接
	conn.close();
	// SQL命令
	String sql1 = "INSERT INTO cust (cname,tel,birthday) VALUES ('Alan','0988','1234')";
	String sql2 = "DELETE FROM cust WHERE id >= 4";
	String sql3 = "UPDATE cust SET cname='Meta', tel='123' WHERE id = 2";
	// 執行SQL命令
	stmt.execute("SELECT * FROM cust");
	stmt.execute(sql1);	// 返回值是boolean
	stmt.executeUpdate(sql1); //返回值是int
	// 應用 PreparedStatment
	String sql4 = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql4);
	pstmt.setString(1, "Richard");
	pstmt.setString(2, "111");
	pstmt.setString(3, "0101");
	pstmt.executeUpdate();
	
} catch (Exception e) {}
// Practice
try {
	Connection conn2 = DriverManager.getConnection(null);
	Statement stmt2 = conn2.createStatement();
	Connection conn3 = DriverManager.getConnection(null);
	Statement stmt3 = conn3.createStatement();
	
	
/*
 * 基本命令
SELECT 
FROM 
JOIN
WHERE
GROUP BY
HAVING
ORDER BY
LIMIT
 * 常用
USE eeit53;
SHOW databases;
SHOW tables;
DESC cust;
SELECT name,addr FROM food;
SELECT id,name,addr FROM food LIMIT 10,10;
RENAME table old_table to new_table;

 * 課堂範例
// 1. 各客戶的訂單數量統計(CustomerID, count), 大於 20 筆, 排序
	1.1 各客戶的訂單數量統計
	1.2 大於 20 筆
	1.3 排序
// orders
SELECT customer_id, COUNT(*) nums FROM orders
GROUP BY customer_id
HAVING nums >= 10
ORDER BY nums DESC

// 2. Seafood 的產品有哪些?
// products
SELECT ProductName FROM products WHERE CategoryID =
(SELECT CategoryID FROM categories WHERE CategoryName = 'Seafood')

// 3. Seafood 的產品供應商
// suppliers
SELECT CompanyName, Phone FROM suppliers
WHERE SupplierID in
(
    SELECT SupplierID FROM products 
 	WHERE CategoryID =
	(
  		SELECT CategoryID FROM categories
 		WHERE CategoryName = 'Seafood'
 	)
)

// 4. 查詢特定公司提供的商品(公司'Exotic Liquids', 'Tokyo Traders')
// products
SELECT ProductName, SupplierID FROM products
WHERE SupplierID IN (
	SELECT SupplierID FROM suppliers
	WHERE CompanyName IN (
		'Exotic Liquids', 'Tokyo Traders'
	)
) 

// 4.1. 查詢特定公司提供的商品, 並顯示公司名(公司'Exotic Liquids', 'Tokyo Traders')
// products
SELECT ProductName, p.SupplierID, s.CompanyName FROM products p
JOIN suppliers s ON (s.SupplierID = p.SupplierID)
WHERE p.SupplierID IN (
	SELECT SupplierID FROM suppliers
	WHERE CompanyName IN (
		'Exotic Liquids', 'Tokyo Traders'
	)
) 

// 5. 銷售業績(營業額)排行榜
// 思路: orderdetail => product, unit, qty -> order orderid -> employee
// orders

SELECT e.LastName, SUM(od.UnitPrice * od.Quantity) sum FROM orders o
JOIN employees e ON (o.EmployeeID = e.EmployeeID)
JOIN orderdetails od ON (o.OrderID = od.OrderID)
GROUP BY e.LastName
ORDER BY sum DESC
// or
SELECT e.LastName, SUM(od.UnitPrice * od.Quantity) sum FROM orderdetails od
JOIN orders o ON (o.OrderID = od.OrderID)
JOIN employees e ON (o.EmployeeID = e.EmployeeID)
GROUP BY e.LastName
ORDER BY sum DESC

驗算
SELECT SUM(UnitPrice * Quantity) sum FROM orderdetails
WHERE OrderID IN 
(SELECT OrderID FROM orders WHERE EmployeeID = 4)

*/


	
} catch (Exception e) {}




}
}
