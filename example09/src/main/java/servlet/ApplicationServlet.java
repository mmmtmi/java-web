package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//アプリケーションスコープに保存するインスタンスの生成
		Human human = new Human("湊 雄輔", 23);

		//ServletContextインスタンスの取得
		ServletContext application = this.getServletContext();
//		ServletContext application = response.getServletContext();
		/*							    ↑	
		 * 	ServeletContextインスタンスの取得方法はアプリに関与するいくつかのクラスに
		 * 用意されており、当然requestインスタンスにも用意されている！
		 * 
		 * セッションスコープと同じ方法論で使えるが、アプリケーションスコープは
		 * セッションスコープと役割が異なるため、同列扱いしないように、テキストのような
		 * 別の方法論をお奨めする。*/
		
		
		//アプリケーションにインスタンスを保存
		application.setAttribute("human", human);

		//アプリケーションスコープからインスタンスを取得
		Human h = (Human)application.getAttribute("human");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(h.getName() + "さんは"+ h.getAge() + "歳です。");
		
		//アプリケーションスコープからインスタンスを削除
		application.removeAttribute("human");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
