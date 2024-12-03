package sample;
//ルール①サーブレット関連のクラスをimport
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HellowServlet
 */
//↓偽装して呼ぶ
@WebServlet("/UranaiServlet") // /helloの/ をコンテキストルートと呼ぶ。
							// http://localhost:8080/example03/HeloServlet
//															  ↑コンテキストルート
//↓本名で呼ぶ
//@WebServlet("/HellowServlet")

public class UranaiServlet extends HttpServlet {
//					ルール②￣￣￣￣￣￣￣￣￣￣継承
	private static final long serialVersionUID = 1L;
								//↑クラス構造が変わっていないことを保証するための
								//名前の通り、バージョン管理をするための値。
								//記述はの残しても害はないので、残しておいて構わない。

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		//ルール③￣￣￣オーバーライド
		
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		￣￣￣￣￣￣￣￣￣￣ここで、PrintWriter型のインスタンスが生成されている！
		
		//★　運勢をランダムで決定
		// 1-1 運勢を配列で管理。
		String[] luckArray = {"超スッキリ","スッキリ","最悪"};
		//1-2 配列の要素番号を生成。
//		int index = (int)(Math.random()*3);
		int index = (int)(Math.random()* luckArray.length);
		//1-3運勢を算出
		String luck = luckArray[index];
		
		//実行日を取得
		//2-1.現在の日時情報を持つインスタンスを生成。
		Date date = new Date();
		//2-2.書式文字列を指定するインスタンスを生成。
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		//2-3.取得した日時情報に書式文字列を適用。
		String today = sdf.format(date);
		
		//【HTMLの出力処理】
		//処理①Content-Typeヘッダの設定
		response.setContentType("text/html; charset=UTF-8");
		//						￣￣￣￣￣￣￣￣￣￣￣￣￣参照[p.56]
		//処理②HTMLを出力　(例[p.67]コード2-1)
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");  //エスケープシーケンス
		out.println("<title>スッキリ占い</title>");
//		out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
		out.println("<link rel=\"stylesheet\" href=https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.css");
		out.println("</head>");
		out.println("<body>");
		out.println("<p class=\"display-4\">"+date+ "の運勢は「"+luck+"」です</p>");
		out.println("<p>"+today+ "の運勢は「"+ luck + "」です</p>");
		out.println("<p><a href=\"/example03/UranaiServlet\">もう一回</p>");
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
