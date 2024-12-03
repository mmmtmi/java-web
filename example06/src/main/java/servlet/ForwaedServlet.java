package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwaedServlet
 */
@WebServlet("/ForwaedServlet")
public class ForwaedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwaedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("フォワードの動作を核にしますか？");
		System.out.println("[ハイ] true [いいえ] false");
		boolean judge = new java.util.Scanner(System.in).nextBoolean();
		
		if(!judge) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html >");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\"/>");
			out.println("<title>「サーブレット」でレスポス</title>");
			out.println("<body>");
			out.println("<h1>サーブレットでレスポンス</h1>");
			out.println("<p><a href=\"/example06/ForwaedServlet\">再リクエスト</a></p>");
			out.println("</body>");
			out.println("</html>");
			
			
		}else {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/forward.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
