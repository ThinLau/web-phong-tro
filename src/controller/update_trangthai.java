package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaiDangDao;

@WebServlet("/update_trangthai.html")
public class update_trangthai extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public update_trangthai() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("/home.html").forward(request,response);

		int mabd = Integer.parseInt(request.getParameter("mabd"));
		BaiDangDao bdd = new BaiDangDao();
		bdd.updateTrangThaibd(mabd);
		
		request.setAttribute("alertMsg", "duyet thanh cong");
	    getServletContext().getRequestDispatcher("/admin.html").forward(request, response);
		
	}

}
