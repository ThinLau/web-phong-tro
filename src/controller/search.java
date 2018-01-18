package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.BaiDang;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<BaiDang> bds = (List<BaiDang>) session.getAttribute("bd_temp");

		String loaitin = request.getParameter("loaitin");
		String giaphong = request.getParameter("giaphong");
		String doituong = request.getParameter("doituong");
		String dientich = request.getParameter("dientich");
		String tinh = request.getParameter("tinh");
		String quan = request.getParameter("quan");
		String phuong = request.getParameter("phuong");
		String duong = request.getParameter("duong");


		if(!loaitin.equals("0")){
			System.out.println("------------------");
			bds = SearchLoaiTin(bds, loaitin);
		}
		if(!giaphong.equals("0"))
			bds = SearchGiaPhong(bds,giaphong);
		if(!doituong.equals("0"))
			bds = SearchDoiTuong(bds, doituong);
		if(!dientich.equals("0"))
			bds = SearchDienTich(bds, dientich);
		if(!tinh.equals("0"))
			bds = SearchTinh_TP(bds, tinh);
		if(!quan.equals("0"))
			bds = SearchQuanHuyen(bds, quan);
		if(!phuong.equals("0"))
			bds = SearchPhuong_Xa(bds, phuong);
		if(!duong.equals("0"))
			bds = SearchDuong(bds, duong);
		
		session.setAttribute("list_bd", bds);
		session.setAttribute("action", "");
		request.getRequestDispatcher("/views/home.jsp").forward(request,
				response);
	}

	public List<BaiDang> SearchLoaiTin(List<BaiDang> bds, String loaitin) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getLoaitin().equals(loaitin))
				list_bd.add(item);
		}
		return list_bd;
	}

	public List<BaiDang> SearchGiaPhong(List<BaiDang> bds, String gp) {
		int giaphong = Integer.parseInt(gp);
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		switch(giaphong){
			
			case 5: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) <= 500000)
						list_bd.add(item);
				}
				return list_bd;
			case 10: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) > 500000 && Double.parseDouble(item.getGiaphong()) <= 1000000)
						list_bd.add(item);
				}
				return list_bd;
			case 15: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) > 1000000 && Double.parseDouble(item.getGiaphong()) <= 1500000)
						list_bd.add(item);
				}
				return list_bd;
			case 25: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) > 1500000 && Double.parseDouble(item.getGiaphong()) <= 2500000)
						list_bd.add(item);
				}
				return list_bd;
			case 30: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) > 2500000 && Double.parseDouble(item.getGiaphong()) <= 3000000)
						list_bd.add(item);
				}
				return list_bd;
			case 31: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (Double.parseDouble(item.getGiaphong()) > 3000000)
						list_bd.add(item);
				}
				return list_bd;
		}
		return list_bd;
	}

	public List<BaiDang> SearchDoiTuong(List<BaiDang> bds, String doituong) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getDoituong().equals(doituong))
				list_bd.add(item);
		}
		return list_bd;
	}

	public List<BaiDang> SearchDienTich(List<BaiDang> bds, String dt) {
		int dientich = Integer.parseInt(dt);
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		switch(dientich){
			case 20: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (item.getDientich() <= 20)
						list_bd.add(item);
				}
				return list_bd;
			case 30: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (item.getDientich() > 20 && item.getDientich() <= 30)
						list_bd.add(item);
				}
				return list_bd;
			case 50: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (item.getDientich() > 30 && item.getDientich() <= 50)
						list_bd.add(item);
				}
				return list_bd;
			case 51: 
				for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
					BaiDang item = i.next();
					if (item.getDientich() > 50)
						list_bd.add(item);
				}
				return list_bd;
		}
		return list_bd;
	}

	public List<BaiDang> SearchTinh_TP(List<BaiDang> bds, String tinh_tp) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getDiachi().getTinh_tp().equals(tinh_tp))
				list_bd.add(item);
		}
		return list_bd;
	}
	public List<BaiDang> SearchDuong(List<BaiDang> bds, String duong) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getDiachi().getDuong().equals(duong))
				list_bd.add(item);
		}
		return list_bd;
	}
	public List<BaiDang> SearchQuanHuyen(List<BaiDang> bds, String quan_huyen) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getDiachi().getQuan_huyen().equals(quan_huyen))
				list_bd.add(item);
		}
		return list_bd;
	}
	public List<BaiDang> SearchPhuong_Xa(List<BaiDang> bds, String phuong_xa) {
		List<BaiDang> list_bd = new ArrayList<BaiDang>();
		for (Iterator<BaiDang> i = bds.iterator(); i.hasNext();) {
			BaiDang item = i.next();
			if (item.getDiachi().getXa_phuong().equals(phuong_xa))
				list_bd.add(item);
		}
		return list_bd;
	}
}
