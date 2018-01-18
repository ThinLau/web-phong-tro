package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaiDangDao;
import dao.DiaChiDao;

@WebServlet("/delbaidang_admin")
public class delbaidang_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delbaidang_admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("/home.html").forward(request,response);

		int mabd = Integer.parseInt(request.getParameter("mabd"));
		BaiDangDao bdd = new BaiDangDao();
		bdd.deleteBaiDang(mabd);
		DiaChiDao dcd= new DiaChiDao();
		dcd.deleteDiaChi(mabd);
		
		request.setAttribute("alertMsg", "xoa thanh cong");
		request.getRequestDispatcher("/admin_manage.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
