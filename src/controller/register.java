package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xss.EscapeUtils;
import Encrypt.MD5;
import models.TaiKhoan;
import dao.ChuTroDao;
import dao.TaiKhoanDao;

/**
 * Servlet implementation class register
 */
@WebServlet("/register.html")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("tk") == null)
		{
			 request.setAttribute("tentaikhoan","");
			 request.getRequestDispatcher("/views/register.jsp").forward(request,response);
		}
		 else{
			 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			 String mact = tk.getTentk();
			 request.setAttribute("tentaikhoan", mact);
			 request.getRequestDispatcher("/views/register.jsp").forward(request,response);
		 }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tentk = new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
		String hoten = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
		String pass = new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
		String re_pass = new String(request.getParameter("re-password").getBytes("ISO-8859-1"),"utf-8");
		String email = request.getParameter("user_email");
		
		
		if(pass.equals(re_pass))
		{
			TaiKhoanDao tkd = new TaiKhoanDao();
			
			// ma hoa md5
			pass = MD5.encryption(pass);
			
			// fix xss cho tentk
			if(tentk.contains("<script>")){
				tentk = EscapeUtils.escapeHtml(tentk);
				//System.out.println("ten tk fix: " + tentk);
			}
			
			tkd.insertTaiKhoan(tentk, pass, email);
			
			ChuTroDao ctd = new ChuTroDao();
			ctd.insertChuTro(tentk, hoten, null, null, email, null);
			
			
			request.setAttribute("alertMsg", "dang ki thanh cong");
			HttpSession session = request.getSession();
			session.setAttribute("action", "");
        	request.getRequestDispatcher("/views/login.jsp").forward(request,response);
		}
		else{
			request.setAttribute("alertMsg", "mat khau khong khop");
        	request.getRequestDispatcher("register.html").forward(request, response);
		}
		
	}

}
