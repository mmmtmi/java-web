package database;

import java.util.List;

import dao.EmployeesDAO;
import model.Employee;

public class SelectEmployees13_4 {

	public static void main(String[] args) {
		// Employeesテーブルの全レコードを取得
		EmployeesDAO empDAO  = new EmployeesDAO();
		List<Employee> empList = empDAO.findAll();
		
		//動作テスト----------------------
		System.out.println("接続テストの選択。\n 成功：true 失敗：false ");
		boolean judge = new java.util.Scanner(System.in).nextBoolean();
		empList = judge ? empList : null;
		//--------------------------------
		
		
		//取得したレコードの内容を出力
		if(empList != null) {
		
			for (Employee emp : empList) {
				System.out.println("ID：" + emp.getId());
				System.out.println("名前：" + emp.getName());
				System.out.println("年齢：" + emp.getAge() + "\n");
			}
		}else{
			System.err.println("データベースの接続に失敗しました。");
		}

	}

}
