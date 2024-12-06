package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

/**
 * Servlet implementation class MinatoIndex
 */
@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*アプリの動作手順
		 * ①前回のリクエストの結果を取得
		 * 		②無）　初回陸エスト　JBsインスタンスを生成
		 * 　	　有）　初回移行の陸エス路　何も処理しない
		 * ③リクエストパラメータを取得
		 * ④モデルのインスタンスを生成して、メソッドを実行
		 * 　※リクエストパラメーターの値によって実行するメソッドを場合わけする。
		 * ⑤実行後、JBsインスタンスをスコープへ保存
		 * ⑥結果表示をJBsに依頼(フォワード)
		 * 
		 * */
		
		// ①アプリケーションスコープに保存されているインスタンス(サイト評価)を取得
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV)application.getAttribute("siteEV");
		/*	  ￣￣￣￣
		 * 	初回リクエストの場合（siteEV == null ）
		 * 	②サイト評価の初期化(初回リクエスト実行時)
		 * 	インスタンスが保存されていない場合、*/
		
		if(siteEV == null ) {
			siteEV = new SiteEV();
		}
		
		/*	nullでなければ何もしない。
		 * 
		 * 	③リクエストパラメーターの取得*/
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//	④サイトの評価処理(モデルに作業依頼)
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		
		
		synchronized (siteEV) {			//スレッドの競合対策(交通整理)[p.256]
			
		
		//	action != null (リンクからのリクエスト)　→　評価処理する！
		if (action != null && action.equals("like")) {
			siteEVLogic.like(siteEV);
		}else if (action != null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		// null だったら、何も評価しない。
		
		}
		// ⑤アプレケーションスコープにサイト評価を保存
		application.setAttribute("siteEV", siteEV);
		
		//	⑥フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("WEB-INF/jsp/minatoIndex.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
	
	}

}
