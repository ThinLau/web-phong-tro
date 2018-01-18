package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.TaiKhoan;

@WebServlet("/nap_cash.html")
public class nap_cash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nap_cash() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tk") == null)
		{
			session.setAttribute("action", "napcash");
			request.getRequestDispatcher("login.html").forward(request,response);
		}
		if (session.getAttribute("tk") == null)
		{
			 request.setAttribute("tentaikhoan","");
			 request.getRequestDispatcher("/views/nap-cash.jsp").forward(request,response);
		}
		 else{
			 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			 String mact = tk.getTentk();
			 request.setAttribute("tentaikhoan", mact);
			 request.getRequestDispatcher("/views/nap-cash.jsp").forward(request,response);
		 }	
		
	}

}
