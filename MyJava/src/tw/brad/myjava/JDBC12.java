package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.myclass.BCrypt;
import tw.brad.myclass.Member;

public class JDBC12 {
	private final static String url = "jdbc:mysql://localhost:3306/eeit53";
	private final static String sql = "SELECT * FROM member WHERE account = ?";
	private static final String sqlUpdate = "UPDATE member SET passwd = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try (Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 帳號登入階段 -> 檢查密碼(加密)是否一致 -> 登入成功
				if (BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					Member member = new Member(rs.getInt("id"),
						rs.getString("account"),
						rs.getString("passwd"),
						rs.getString("realname"));
					System.out.printf("Welcome, %s", member.getRealname());
					// 進行密碼變更
					System.out.println("Change Password...");
					// 密碼變更階段 -> 請輸入舊密碼
					System.out.print("Old Password: ");
					String oldPasswd = scanner.next();
					// 密碼變更階段 -> 檢查舊密碼(加密)是否一致
					if (BCrypt.checkpw(oldPasswd, member.getPasswd())) {
						// 密碼變更階段 -> 請輸入新密碼
						System.out.println("New Password: ");
						String newPasswd = scanner.next();
						// 密碼變更階段 -> 變更為新密碼
						PreparedStatement pstmt2 = conn.prepareStatement(sqlUpdate);
						pstmt2.setString(1, BCrypt.hashpw(newPasswd, BCrypt.gensalt()));
						pstmt2.setInt(2, member.getId());
						// 密碼變更成功或失敗訊息
						if (pstmt2.executeUpdate() != 0) {
							System.out.println("Change passwd success");
						}else {
							System.out.println("Change passwd failure");
						}
					}else {
						// 密碼變更階段 -> 檢查舊密碼(加密)是否一致 -> 密碼錯誤
						System.out.println("Passwd not match!");
					}
										
				}else {
					// 帳號登入階段 -> 檢查密碼(加密)是否一致 -> 密碼錯誤
					System.out.println("Passwd wrong!");
				}
			}else {
				// 帳號登入階段 -> 帳號不存在
				System.out.println("get out here");
			}
			
			rs.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

