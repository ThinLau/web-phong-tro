package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Encrypt.MD5;
import models.TaiKhoan;
import dao.TaiKhoanDao;


@WebServlet("/login.html")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		 if (session.getAttribute("tk") == null)
			{
				 request.setAttribute("tentaikhoan","");
				 request.getRequestDispatcher("/views/login.jsp").forward(request,response);
			}
			 else{
				 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
				 String mact = tk.getTentk();
				 request.setAttribute("tentaikhoan", mact);
				 request.getRequestDispatcher("/views/login.jsp").forward(request,response);
			 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		TaiKhoan tk = new TaiKhoan();
		TaiKhoanDao tkd = new TaiKhoanDao();
		
		String userid = request.getParameter("username");
		String pwd = MD5.encryption(request.getParameter("password"));
		
		// ma hoa md5
		//pwd = MD5.encryption(pwd);
		
		String action = "abc";
		action = (String) session.getAttribute("action");
		tk = tkd.login(userid, pwd);
		
		if(tk != null){
			String tinhtrang = tk.getTrangthai();
			request.setAttribute("tentaikhoan", userid);
			if(tinhtrang.equals("Hoạt động"))
			{
				session.setAttribute("tk",tk);
				
				if(action.equals("dangtin"))
				{
					session.setAttribute("action", "");
					
					request.getRequestDispatcher("/views/post.jsp").forward(request,response);
				}
					
				else if(action.equals("napcash"))
				{
					session.setAttribute("action", "");
					//request.getRequestDispatcher("nap_cash.html").forward(request,response);
					request.getRequestDispatcher("/views/nap-cash.jsp").forward(request,response);
				}
				else
					{
						if(tk.getTentk().equals("admin")) 
						{	
							request.getRequestDispatcher("admin.html").forward(request,response);
						}
						else
							request.getRequestDispatcher("chutro.html").forward(request,response);
					}
			}
			else{
				request.setAttribute("alertMsg", "tk bi khoa");
	        	request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("tentaikhoan", "");
			request.setAttribute("alertMsg", "sai ten dang nhap hoac mat khau");
        	request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
