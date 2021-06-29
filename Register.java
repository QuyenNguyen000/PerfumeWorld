package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:sqlserver://DESKTOP-9L996I3\\SQLFULL:1433;databaseName=fragrance;";
        String USER = "sa";
        String PASS = "cuong123";
        String fname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("country");
        
        
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection conn = DriverManager.getConnection(url,USER,PASS);
		    Statement stmt = conn.createStatement();
		    String sql;
		    sql = "INSERT INTO customer VALUES(?,?,?,?,null,null)";
		    PreparedStatement preparedStmt = conn.prepareStatement(sql);
		    preparedStmt.setString(1,email);
		    preparedStmt.setString(2,password);
		    preparedStmt.setString(3,address);
		    preparedStmt.setString(4,phone);
		    preparedStmt.execute();
		    conn.close();
		} catch (ClassNotFoundException ex) {} catch (SQLException ex) {}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
