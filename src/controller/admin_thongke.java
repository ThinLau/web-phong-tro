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


@WebServlet("/admin_thongke.html")
public class admin_thongke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("/home.html").forward(request, response);
		
		TaiKhoanDao tkd = new TaiKhoanDao();
		List<TaiKhoan> tks;
		tks = tkd.getTaiKhoans();
		session.setAttribute("list_tk", tks);
		
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		String mact = tk.getTentk();
		request.setAttribute("tentaikhoan", mact);
		
		request.getRequestDispatcher("/views/admin_thongke.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
