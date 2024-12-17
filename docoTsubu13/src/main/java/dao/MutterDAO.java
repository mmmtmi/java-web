package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/Documents/database/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch(ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			String sql = 
					"select ID,NAME,TEXT from MUTTERS order by ID desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//selectを実行
			ResultSet rs = pStmt.executeQuery();
			
			//select文の結果をAllayListに格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	public boolean create(Mutter mutter) {
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした。");
		}
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//INSERST文の準備。
			//（idは自動連番なので指定しなくてよい。）
			String sql ="insert into MUTTERS(NAME,TEXT) values(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//INSESRT文の「？」に使用する値を設定してSQL文を完成
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			//INSERT文を実行(resultには追加された行数が代入される。)
			int result = pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
