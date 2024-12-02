package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

/**
 * Servlet implementation class HealthCheck
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*
	 * 		POST リクエスト　入力フォームからリクエスト
	 * 		①リクエストパラメーターを取得
	 * 		②取得したデータをJavaBeans(JBs)インスタンスに格納
	 * 		③JBsインすランスを引数に、モデルのメソッドを実行
	 * 		④実行後、JBsインスタンスをスコープに保存
	 * 		⑤結果表示ぼビュー(JSP)に依頼
	 * 
	 * */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//①リクエストパラメータを取得
//		request.setCharacterEncoding("UTF-8");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		//②インスタンスに格納
		Health health = new Health();
		//入力値をプロパティに設定(入力値は演算処理に活用する←要変換！)
		//                 double  ←‐‐‐‐‐ string
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		
		//③インスタンスを引数に、モデルのメソッドを実行
		//→MVCモデルのロジックモデル
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		healthCheckLogic.execute(health); //健康診断の処理を実行し、結果を求める。
		
		//④インスタンスをリクエストスコープに保存
		request.setAttribute("health", health);
		
		//⑤結果表示をJSPに依頼(フォワード)
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthChekResult.jsp");
		dispatcher.forward(request, response);
	}

}
