package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChuTroDao;

@WebServlet("/update_imfor")
public class update_imfor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.print("----------------------------");
		String mact = request.getParameter("mact");
		String hoten = request.getParameter("us-name");
		String diachi = request.getParameter("us-address");
		String sdt = request.getParameter("us-phone");
		String cmnd = request.getParameter("us-card");
		String email = request.getParameter("us-email");
	
			ChuTroDao ctd = new ChuTroDao();
			ctd.updateChuTro(mact, hoten, diachi, sdt, email, cmnd);
			
			
			request.setAttribute("alertMsg", "Luu thanh cong");
			HttpSession session = request.getSession();
			session.setAttribute("action", "");
        	request.getRequestDispatcher("chutro.html").forward(request,response);
	}

}
