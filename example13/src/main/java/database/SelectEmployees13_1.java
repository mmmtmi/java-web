package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectEmployees13_1 {
	public static void main(String[] args) {
		
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした。");
		}
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/Documents/database/example","sa","")){
			//SELECT文を準備
			String sql = "select ID, NAME, AGE FROM EMPLOYEES";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECTを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				
				System.out.println("ID:" + id);
				System.out.println("名前：" + name);
				System.out.println("年齢：" + age + "\n");
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		}

}
