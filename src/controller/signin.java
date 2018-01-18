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

@WebServlet("/signin.html")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				TaiKhoan tk = new TaiKhoan();
				TaiKhoanDao tkd = new TaiKhoanDao();
				
				String userid = request.getParameter("username");
				String pwd = request.getParameter("password");
				
				tk = tkd.login(userid, pwd);
// them chu tro voi mact = ma tk...-> chua lam
				if(tk != null){
					String tinhtrang = tk.getTrangthai();
					if(tinhtrang.equals("Hoạt động"))
					{
						HttpSession session =  request.getSession();
						session.setAttribute("tk",tk);
						if(tk.getTentk().equals("admin")) 
						{	
							request.getRequestDispatcher("admin.html").forward(request,response);
						}
						else
							request.getRequestDispatcher("chutro.html").forward(request,response);
					}
					else{
						request.setAttribute("alertMsg", "tk bi khoa");
			        	request.getRequestDispatcher("login.html").forward(request, response);
					}
				}
				else{
					request.setAttribute("alertMsg", "sai ten dang nhap hoac mat khau");
		        	request.getRequestDispatcher("login.html").forward(request, response);
				}
	}


}
