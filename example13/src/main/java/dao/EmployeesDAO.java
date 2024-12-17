package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;


public class EmployeesDAO {
	
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/Documents/database/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();
		//JDBCドライバーを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e){
			throw new IllegalStateException(
					"JDBCドライバーを読み込めませんでした。");
		}
		
		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL,
				DB_USER, DB_PASS)){
			//select文を準備
			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEES";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//selectを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果表に格納されたレコードの内容を
			//Employeeインスタンスに設定し、ArrayListインスタンスに追加。
			while (rs.next()) {
				String id  = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				//取得した値をEmployeeインスタンスに格納
				Employee employee = new Employee(id, name ,age);
				//ArrayList因数タンスにEmployeeインスタンスを追加
				empList.add(employee);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			//return null; //早期リターンするよりも戻り値の意味をわかりやすく
			empList = null; //したほうがいいのでは
		}
		return empList;
	}
}
