package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 処理手順［p.276］
	 * ①【確認】つぶやき履歴が取得できるか否か？
	 * 		→アプリケーションスコープに「つぶやきりすと」があるか？
	 * 		→無）「つぶやきリスト」を生成して保存
	 * 		→有）何もしない　＝　既存の「つぶやきリスト」を使用する
	 * ②【前提】メイン画面では「ログイン」していることを前提に出力する！
	 * 		→セッションスコープに「ユーザー情報」があるか？
	 * 		→無）　トップ画面に「リダイレクト」
	 * 		→有）　メイン画面に「フォワード」*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//①つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		/*
		 * ★Javaコンパイラーによる未検査のキャストの警告[p.458]★
		 * Java5.0で総称型が取り込まれてから、Object型から総称型へのキャストは、
		 * 「型の安全性」に問題がある（キャストに失敗する可能性）という理由で
		 * コンパイラが未検査のキャストの警告を出す仕様になっている。
		 * ただし、
		 * ・Object型からキャストするしか方法はなく、
		 * 							警告を出さないで実装することは仕様上できない。
		 * ・警告はコンパイルエラーではないので、対応しなくても実行可能！
		 * ↓
		 * 実行上は問題ないので未対応(黄色の波線は表示)のままでは構わない！
		 * */
		
		//取得できなかった場合は、
		if(mutterList == null ) {
			//、つぶやきリストを新規作成して
			mutterList = new ArrayList<>();
			//アプリケーションスコープに保存
			application.setAttribute("mutterList", mutterList);
		}
		
		//②ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null ) { //ログインしていない場合
			//リダイレクト　画面とURLを一致させる。
			response.sendRedirect("index.jsp");
			
			//return //早期リターンの場合。
		}else{  //ログイン済みの場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher
					("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 処理手順[p.287]
	 * ①「つぶやき内容」（リクエストパラメータ）を取得
	 * 		有）①アプリケーションスコープから「つぶやきリスト」を取得
	 * 			②セッションスコープから「ユーザー情報」を取得
	 * 			③「つぶやき情報」に「ユーザー名」と「つぶやき内容」を登録
	 * 			④「つぶやきリスト」に「つぶやき情報」を登録（モデルに作業依頼）
	 * 			⑤更新された「つぶやきリスト」をアプリケーションスコープに保存
	 * 		無）（現時点では保留［p.295実装］
	 * 			⑥エラーメッセージをリクエストスコープの保存
	 * ②処理結果を出力
	 * →メイン画面にフォワード
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		//①リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		Date date = new Date();
		
		//入力値チェック
		//★有）つぶやき内容
		if(text != null && text.length() != 0) {
			//①-①アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			//①-②セッションスコープに保温されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//つぶやくを作成してつぶやきリストに追加
			//①-③つぶやき情報を登録（ユーザー名、つぶやき内容）
			Mutter mutter = new Mutter(loginUser.getName(), text, date);
			//①-④つぶやき情報をつぶやきリストに追加
			//※最新の「つぶやき情報」が、つぶやきリストの先頭に来るように処理
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.excute(mutter, mutterList);
			
			//①-⑤アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList", mutterList);
		}else {		//★無）つぶやき内容
			//①-⑥エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません。");
		}
		
		//②メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
