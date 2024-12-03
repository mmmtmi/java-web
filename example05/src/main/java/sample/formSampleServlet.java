package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formSampleServlet
 */
@WebServlet("/formSampleServlet")
//				↑Acrionと一緒にする！！！
public class formSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータを取得
		String name = request.getParameter("name");
		//										上下　部品な名前を指定して値を取得
		String gender = request.getParameter("gender");
		
		//リクエストされてきたデータを使って処理を行い、
		//HTMLに処理結果を出力する。
		
		//HTMLを出力(お決まりのパターン)
		response.setContentType("text/html ; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");  //エスケープシーケンス
		out.println("<title>servlet form test post out</title>");
		out.println("</head><bpdy>");
		out.println(name+"さん（"+gender+"）を登録しました。");
		out.println("</body></html>");
		
	}

}
