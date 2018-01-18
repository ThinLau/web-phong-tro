package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaiDang;
import models.TaiKhoan;
import dao.BaiDangDao;

@WebServlet("/detail_room.html")
public class detail_room extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detail_room() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int mabd = Integer.parseInt(request.getParameter("mabd"));
		
		BaiDangDao bdd = new BaiDangDao();
		BaiDang bd = new BaiDang();
		
		bd = bdd.getBaiDang(mabd); 
		session.setAttribute("baidang", bd);
		
		 String fileSavePath = getServletContext().getRealPath("/images") + File.separator + mabd;
		 File directory = new File(fileSavePath);
		 
		 ArrayList<String> fileNames = new ArrayList<>();
		 String activeImg = "";
		 
		 if (directory.exists() && directory.isDirectory()) {
			 int i = 0;
			 for (File file : directory.listFiles())
			 {
				 if(i == 0)
				 {
					 activeImg = file.getName();
					 i++;
					 continue;
				 } 
				 fileNames.add(file.getName());
			 }
		 }
		 session.setAttribute("activeImg", activeImg);
		 session.setAttribute("list_img", fileNames);
		 
		 if (session.getAttribute("tk") == null)
		{
			 request.setAttribute("tentaikhoan","");
			 request.getRequestDispatcher("/views/detail-room.jsp").forward(request,response);
		}
		 else{
			 TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			 String mact = tk.getTentk();
			 request.setAttribute("tentaikhoan", mact);
			 request.getRequestDispatcher("/views/detail-room.jsp").forward(request,response);
		 }
	}
}
