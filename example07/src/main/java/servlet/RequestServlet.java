package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Human human = new Human("湊 祐輔", 23);
		/*
		 * 		解説①リクエストスコープに「
		 * 					名前を付けて　インスタンスを保存
		 * 						↓　　　　　↓
		 * */
		request.setAttribute("human", human);
	//		解説②リクエストスコープから名前を指定してインスタンスを取得
	//											↓
		Human h = (Human)request.getAttribute("human");
	//					￣￣￣￣↑￣￣￣￣￣￣￣￣￣￣
	//Human型 = キャスト Object型　ダウンキャスト
	//専用の型			　汎用の型
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>リクエストスコープのテスト</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(h.getName()+"さんは"+h.getAge()+"歳です");
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
