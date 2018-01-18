package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.html")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("action", "");
		session.setAttribute("tk", null);
		session.invalidate();
		//response.sendRedirect("views/home.jsp");
		request.getRequestDispatcher("home.html").forward(request,response);
	}

}
