package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.TaiKhoan;


@WebServlet("/checktaikhoan")
public class checktaikhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public checktaikhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tentk = request.getParameter("");
		
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("home.html").forward(request,response);
		
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		String mact = tk.getTentk();
		request.setAttribute("tentaikhoan", mact);

		if(tentk == "admin"){
			request.setAttribute("alertMsg", "");
			request.getRequestDispatcher("admin_manage.html").forward(request, response);
		}
		else{
			request.setAttribute("alertMsg", "");
			request.getRequestDispatcher("account_manage.html").forward(request, response);
		}
	}
}
