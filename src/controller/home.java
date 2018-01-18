package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaiDang;
import models.Duong;
import models.Phuong_Xa;
import models.Quan_Huyen;
import models.TaiKhoan;
import models.Tinh_TP;
import dao.BaiDangDao;
import dao.DuongDao;
import dao.Phuong_XaDao;
import dao.Quan_HuyenDao;
import dao.Tinh_TPDao;


@WebServlet("/home.html")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BaiDangDao bdd = new BaiDangDao();
		List<BaiDang> bds;
		List<BaiDang> bd_temp;    
		bds = bdd.getBaiDangs(); 
		session.setAttribute("list_bd", bds);
		
		List<BaiDang> tinmoidang = new ArrayList<BaiDang>();
		if(!bds.isEmpty())
			if(bds.size() >= 5)
				tinmoidang = bds.subList(0,5);
			else tinmoidang = bds.subList(0,bds.size());
		
		bd_temp = bds;
		
		session.setAttribute("tinmoidang", tinmoidang);
		session.setAttribute("bd_temp", bd_temp);

		Tinh_TPDao ttpd = new Tinh_TPDao();
		Quan_HuyenDao qhd	= new Quan_HuyenDao();
		Phuong_XaDao pxd = new Phuong_XaDao();
		DuongDao dd = new DuongDao();
		
		
		ArrayList<Tinh_TP> ttps = ttpd.getTinh_TPs();
		ArrayList<Quan_Huyen> qhs = qhd.getAllQuan_Huyen();
		ArrayList<Phuong_Xa> pxs = pxd.getAllQuan_Huyen();
		ArrayList<Duong> ds = dd.getAllDuong();
	
		session.setAttribute("ttps", ttps);
		session.setAttribute("qhs", qhs);
		session.setAttribute("pxs", pxs);
		session.setAttribute("ds", ds);
		session.setAttribute("action", "");
		
		
		if (session.getAttribute("tk") == null)
		{
			request.setAttribute("tentaikhoan", "");
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		}
		else{
			TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
			String mact = tk.getTentk();
			request.setAttribute("tentaikhoan", mact);
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);
		}
	}

}
