package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterzUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*[図8－3]
		 * リクエスト①URLからのリクエスト→入力画面にフォワード
		 * 					(リクエストパラメーター無)
		 * リクエスト③リンクからのリクエスト→完了画面にフォワード
		 * 					（リクエストパラメーター有）
		 * 
		 * 今回はリクエストパラメーターの有無でフォワード先を変更する仕様を
		 * 採用している。↓そのため、フォワードさきを格納する変数を用意*/
		String forwardPath = null;
		/*						↑
		 * 			今回のようにelseブロックを使用しない場合、条件によっては
		 * 			値が決まらない可能性があるため、初期化が必要。*/
		
		//①リクエストパラメーターの有無の確認（action 属性を取得）
//		request.setCharacterEncoding("UTF-8");			//今回はactionがnullかdoneなので省略
		String action = request.getParameter("action");
		
		//②action属性値で画面出力の切り替え。有）入力画面、無）完了画面
		
		if(action == null) {
			forwardPath = "WEB-INF/jsp/registerForm.jsp";
		}
		else if (action.equals("done")) {
			//事前処理
			//1.セッションスコープに保存された登録ユーザーを取得
			HttpSession settion = request.getSession();
			User registerUser = (User)settion.getAttribute("registerUser");
			
			//2．登録処理の呼び出し。
			RegisterzUserLogic logic = new RegisterzUserLogic();
			//boolean 戻り値を格納する変数 = logic.execute(registerzUser);
			// 		　↑処理実行後に「true」が変えるが、今回は何もしないので変数で受け取らない。
			boolean resault = logic.execute(registerUser);
			System.out.println("登録の可否の動作確認");
			System.out.println("【成功】true 【失敗】false");
			resault = new java.util.Scanner(System.in).nextBoolean();
			String msg = resault ? "登録完了しました":"登録失敗しました";
			request.setAttribute("msg",  msg);
			
			//フォワード先の設定
			settion.removeAttribute("registerUser");
			
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
		/*action属性値：あり（done以外）は考慮していない！
		 * 
		 * else {
		 *   フォワード先の設定
		 *   forwardPath = null;
		 *   [例、ログインさせる、入力画面にリダイレクトさせる
		 *   response.sendRedirect/example08~~~~~
		 *   return;]*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		/*
		 * [図8－3]
		 * リクエスト②（入力画面）からリクエスト→確認画面にフォワード
		 * 
		 * ★入力画面(フォーム)からリクエスト
		 * ①リクエストパラメータを取得
		 * ②取得した値をJavaBeans（JBs）インスタンスへ格納
		 * ③JBsインスタンスをスコープに保存
		 * ④結果表示をJSPに依頼(フォワード)
		 * */
		//①
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		//②
		User registerUser = new User(id, name, pass);
		//③
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		//④
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
