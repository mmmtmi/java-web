package sample;
//ルール①サーブレット関連のクラスをimport
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HellowServlet
 */
//↓偽装して呼ぶ
//@WebServlet("/hello.html") // /helloの/ をコンテキストルートと呼ぶ。
							// http://localhost:8080/example03/HeloServlet
//															  ↑コンテキストルート
//↓本名で呼ぶ
//@WebServlet("/HellowServlet")
public class HellowServlet extends HttpServlet {
//					ルール②￣￣￣￣￣￣￣￣￣￣継承
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ルール③￣￣￣オーバーライド
		
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		￣￣￣￣￣￣￣￣￣￣ここで、PrintWriter型のインスタンスが生成されている！
		
		//【HTMLの出力処理】
		//処理①Content-Typeヘッダの設定
		response.setContentType("text/html; charset=UTF-8");
		//						￣￣￣￣￣￣￣￣￣￣￣￣￣参照[p.56]
		//処理②HTMLを出力　(例[p.67]コード2-1)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");  //エスケープシーケンス
		out.println("<title>Hello,HTML</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("こんにちはHTML！！");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
