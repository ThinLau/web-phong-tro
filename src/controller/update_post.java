package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.BaiDang;
import models.TaiKhoan;
import dao.BaiDangDao;
import dao.DiaChiDao;

@WebServlet("/update_post.html")
public class update_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String UPLOAD_DIRECTORY = "images";
	    // upload settings
	    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		
		String mact = tk.getTentk();
		request.setAttribute("tentaikhoan", mact);
		if (session.getAttribute("tk") == null)
			request.getRequestDispatcher("/views/home.jsp").forward(request,response);

		int mabd = Integer.parseInt(request.getParameter("mabd"));
		BaiDangDao bdd = new BaiDangDao();
		BaiDang bd = bdd.getBaiDang(mabd);
		
		request.setAttribute("baidang", bd);
		request.getRequestDispatcher("/views/re-post.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	 	request.setCharacterEncoding("utf-8");
	 	response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
		
        int mabd = Integer.parseInt(request.getParameter("mabd"));
        
        DiaChiDao dcd = new DiaChiDao();
		BaiDangDao bdd = new BaiDangDao();
		
		String ngaydang = request.getParameter("ngaydang");
		ngaydang = ngaydang.substring(6,10)+"-"+ ngaydang.substring(3, 5)+"-" + ngaydang.substring(0,2);
		String ngayhethan = request.getParameter("ngayhethan");
		ngayhethan = ngayhethan.substring(6,10)+"-"+ ngayhethan.substring(3, 5)+"-" + ngayhethan.substring(0,2);
		String giodang = request.getParameter("giodang");
		
		HttpSession session = request.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("tk");
		String mact = tk.getTentk();
		
        
     // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        
        try {
    		String tieude="";
    		String loaichuyenmuc="";
    		String giaphong="" ;
    		int songuoi=1;
    		int dientich = 0;
    		String doituong="";
    		String tinh_tp="";
    		String quan_huyen="";
    		String phuong_xa="";
    		String duong="";
    		String diachichinhxac="";
    		String mota="";
    		String anhbia="";
    		String toado="";
    		
        	int i = 0,j=0;
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
            	for (FileItem item : formItems) {
            	    // processes only fields that are not form fields
            	    if (item.isFormField()) {// not is input type="file"
            	        String fieldname = item.getFieldName();
            	        String fieldvalue = new String(item.getString().getBytes("ISO-8859-1"),"utf-8");
            	        if (fieldname.equals("tieude")) {
            	        	tieude = fieldvalue;
            	        } else if (fieldname.equals("loaichuyenmuc")) {
            	        	loaichuyenmuc = fieldvalue;
            	        } else if (fieldname.equals("giachothue")) {
            	        	giaphong = fieldvalue;
            	        } else if (fieldname.equals("songuoi")) {
            	        	songuoi = Integer.parseInt(fieldvalue);
            	        } else if (fieldname.equals("dientich")) {
            	        	dientich = Integer.parseInt(fieldvalue);
            	        } else if (fieldname.equals("doituong")) {
            	        	doituong = fieldvalue;
            	        } else if (fieldname.equals("tinh_tp")) {
            	        	tinh_tp = fieldvalue;
	           	        	if(tinh_tp.contains("-"))
	           	        		 tinh_tp="";
           	  		
            	        } else if (fieldname.equals("quan_huyen")) {
            	        	quan_huyen = fieldvalue;
           	        	 	if(quan_huyen.contains("-"))
                	  			quan_huyen="";
                	  		
            	        } else if (fieldname.equals("phuong_xa")) {
            	        	phuong_xa = fieldvalue;
           	        	 	if(phuong_xa.contains("-"))
           	        	 		phuong_xa="";
             	  		
            	        } else if (fieldname.equals("duong")) {
            	        	duong = fieldvalue;
            	        	if(duong.contains("-"))
                 	  			duong="";
            	        }else if (fieldname.equals("diachi")) {
            	        	diachichinhxac = fieldvalue;
            	        }else if (fieldname.equals("mota")) {
            	        	//String data = new String(fieldvalue.getBytes("ISO-8859-1"),"utf-8");
            	    		 mota= fieldvalue.replaceAll("(\r\n|\n)", "<br/>");
            	        }else if(fieldname.equals("toado")) {
            	        	toado = fieldvalue;
            	        	toado = toado.substring(1, toado.length()-1);
            	        }
            	    } else {
            	    		System.out.println(++j);
            	    	  String fileName = new File(item.getName()).getName();
            	    	  if(i == 0){
	                      		anhbia = fileName;
	                      		i++;
                      	  }
            	    	  String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY
            	    	  			+ File.separator + mabd;
            	    	 // creates the directory if it does not exist
            		        File uploadDir = new File(uploadPath);
            		        if (!uploadDir.exists()) {
            		            uploadDir.mkdir();
            		        }else {
            		        	uploadDir.delete();
            		        	uploadDir = new File(uploadPath);
            		        }
            	    	  	String filePath = uploadPath+ File.separator + fileName;
	            	        File storeFile = new File(filePath);
	            	        // saves the file on disk
	            	        item.write(storeFile);
            	    }
            	}
            }
    		dcd.insertDiaChi(mabd, tinh_tp, quan_huyen, phuong_xa, duong, diachichinhxac, toado);  
    		boolean flag = bdd.updateBaiDang(mabd, tieude, mact, loaichuyenmuc, mota, giaphong, songuoi, 
    				dientich, doituong, ngaydang, giodang, anhbia, ngayhethan);
    		
    		if(flag){
    			request.setAttribute("alertMsg", "chính sua thanh cong");
    			if(mact.equals("admin"))
    			{
    	    		getServletContext().getRequestDispatcher("/admin_manage.html").forward(request, response);
    			}
    			else
    				getServletContext().getRequestDispatcher("/account_manage.html").forward(request, response);
    		}
    		else {
    			request.setAttribute("alertMsg", "dang tin that bai");
    			getServletContext().getRequestDispatcher("/views/re-post.jsp").forward(request, response);
    		}
    		
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
	}
}
