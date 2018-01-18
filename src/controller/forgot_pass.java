package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.TaiKhoan;
import dao.TaiKhoanDao;

@WebServlet("/forgot_pass.html")
public class forgot_pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public forgot_pass() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
		{
			 request.setAttribute("tentaikhoan","");
			 request.getRequestDispatcher("/views/forgot-pass.jsp").forward(request,response);
		}
		 else{
			 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			 String mact = tk.getTentk();
			 request.setAttribute("tentaikhoan", mact);
			 request.getRequestDispatcher("/views/forgot-pass.jsp").forward(request,response);
		 }
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("send_email");
		TaiKhoanDao tkd = new TaiKhoanDao();
		if (tkd.checkemail(email))
		{
			request.setAttribute("alertMsg", "xin check mail");
        	request.getRequestDispatcher("login.html").forward(request, response);
		}
		else{
			request.setAttribute("alertMsg", "Email không tồn tại!");
        	request.getRequestDispatcher("forgot_pass.html").forward(request, response);
		}
	}

}
