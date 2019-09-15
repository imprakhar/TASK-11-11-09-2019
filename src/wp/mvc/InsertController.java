package wp.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wp.mvc.Book book = new wp.mvc.Book(request.getParameter("bid"),request.getParameter("btitle"),request.getParameter("bauthor"),request.getParameter("bsubject"),request.getParameter("bprice"));
		new BookDAO().saveBook(book);
		HttpSession session = request.getSession();
		session.setAttribute("newbook",book);
		response.sendRedirect("NewBook.jsp");
	}

}
