package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaiDang;
import models.TaiKhoan;
import dao.BaiDangDao;

@WebServlet("/admin_manage.html")
public class admin_manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("/home.html").forward(request,response);

		BaiDangDao bdd = new BaiDangDao();
		List<BaiDang> bds = bdd.getBaiDangs_chutro();
		
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		String mact = tk.getTentk();
		
		request.setAttribute("tentaikhoan", mact);
		request.setAttribute("baidangs", bds);
		request.setAttribute("alertMsg", "");
		request.getRequestDispatcher("/views/admin_manage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
