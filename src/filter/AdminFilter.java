package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.TaiKhoan;

import java.io.IOException;

public class AdminFilter  implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		if(tk != null){
			String tentk = tk.getTentk();
			if(tentk.equals("admin"))
				chain.doFilter(request, response); // thuc hien
		}
		// con cac truong hop con lai thi ko cho thuc hien
		req.getRequestDispatcher("/views/error_page.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
