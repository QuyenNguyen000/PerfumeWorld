package project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

import project.User;

@WebServlet("/CookieRememberLoginOutput")
public class CookieRememberLoginOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String username = "admin";
    public String password = "12345bow";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        boolean check = false;
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        
        String url = "jdbc:sqlserver://DESKTOP-9L996I3\\SQLFULL:1433;databaseName=fragrance;";
        String USER = "sa";
        String PASS = "cuong123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url,USER,PASS);
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM customer";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                if(name.equals(username)&& pass.equals(password)){
                    check =true;
                     HttpSession user = request.getSession(true);
                    user.setAttribute("uname", username);
                    break;
                }
                    
                else check = false;
               
                request.setAttribute("uname", username);
                request.setAttribute("password", password);
                
            }
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
            
        Cookie cookieUserName = null;
        Cookie cookiePassword = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookieUserName = cookie;
                }
                if (cookie.getName().equals("password")) {
                    cookiePassword = cookie;
                }
            }
        }

        if (cookieUserName == null || cookiePassword == null){
            if (name.equalsIgnoreCase(username) && pass.equals(password) && check){
                Cookie cUsername = new Cookie("username", name);
                Cookie cPassword = new Cookie("password", pass);
                response.addCookie(cUsername);
                response.addCookie(cPassword);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Category.jsp");
                dispatcher.forward(request, response);
            } else {
            	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.html");
                dispatcher.forward(request, response);
            }
        } else if (cookieUserName.getValue().equalsIgnoreCase(username) && cookiePassword.getValue().equals(password)){
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Category.jsp");
            dispatcher.forward(request, response);
        }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}