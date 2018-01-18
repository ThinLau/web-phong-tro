package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.TaiKhoan;
import dao.TaiKhoanDao;

@WebServlet("/deleteTaiKhoan.html")
public class deleteTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("home.html").forward(request,response);

		String tentk = request.getParameter("tentk");
		TaiKhoanDao tkd = new TaiKhoanDao();
		tkd.deleteTaiKhoan(tentk);

		List<TaiKhoan> tks = tkd.getTaiKhoans();
		
		request.setAttribute("taikhoans", tks);
		
		request.setAttribute("alertMsg", "xoa thanh cong");
		request.getRequestDispatcher("admin_thongke.html").forward(request, response);	}
}
