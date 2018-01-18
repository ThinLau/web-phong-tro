package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChuTroDao;
import models.ChuTro;
import models.TaiKhoan;

@WebServlet("/chutro.html")
public class chutro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public chutro() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("tk") == null)
		{
			request.getRequestDispatcher("/views/login.jsp").forward(request,response);
		}
		
		TaiKhoan tk = new TaiKhoan();
		tk = (TaiKhoan) session.getAttribute("tk");
		String mact = tk.getTentk();
		ChuTroDao ctd = new ChuTroDao();
		ChuTro ct = new ChuTro();
		ct = ctd.getChuTro(mact);
		session.setAttribute("chutro", ct);
		request.setAttribute("tentaikhoan", mact);
		
		
		request.getRequestDispatcher("/views/account.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
