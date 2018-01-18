package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import connect.DBConnect;

/**
 * Servlet implementation class showimage
 */
@WebServlet("/showimage")
public class showimage extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showimage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Blob image = null;
		byte[] imgData = null ;
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			int mabaidang = Integer.parseInt(request.getParameter("mabaidang"));
			System.out.println(mabaidang);
			
			DBConnect connect = new DBConnect();
			con = (Connection) connect.getConnection();
            
			stmt = con.createStatement();
			rs = stmt.executeQuery("select anh from baidang where  MaBD = "+ mabaidang);
			if (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1,(int)image.length());
			} else {
				System.out.println("image not found for given id>");
				return;
			}

			// display the image
         response.setContentType("image/gif");
         OutputStream o = response.getOutputStream();
         o.write(imgData);
         o.flush();
         o.close();
		} catch (Exception e) {
			System.out.println("Unable To Display image");
			System.out.println("Image Display Error=" + e.getMessage());
			return;
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

}
