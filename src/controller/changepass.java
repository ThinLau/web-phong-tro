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

@WebServlet("/changepass.html")
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public changepass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		String tentk = tk.getTentk();
		
		request.setAttribute("tentaikhoan", tentk);
			request.getRequestDispatcher("/views/changepass.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		
		String tentk = tk.getTentk();
		request.setAttribute("tentaikhoan", tentk);
		System.out.print(tentk);
		String old_pass = request.getParameter("old_pass");
		String new_pass = request.getParameter("new_pass");
		String re_newpass = request.getParameter("re_newpass");

		TaiKhoanDao tkd = new TaiKhoanDao();
		if (tkd.checkpass(tentk,old_pass)) {
			if (new_pass.equals(re_newpass)) {
				tkd.updatePass(tentk, new_pass);

				request.setAttribute("alertMsg", "doi mat khau thanh cong");
				session.setAttribute("action", "");
				request.getRequestDispatcher("chutro.html").forward(request,
						response);
			} else {
				request.setAttribute("alertMsg", "mat khau moi khong khop");
				request.getRequestDispatcher("/views/changepass.jsp").forward(request,
						response);
			}
		} else {
			request.setAttribute("alertMsg", "mat khau cu ko chinh xac");
			request.getRequestDispatcher("/views/changepass.jsp").forward(request,
					response);
		}

	}

}
