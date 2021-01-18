import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import mypack.Validate;
public class MyLoginServ extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String lg = request.getParameter("lg");
        String pw = request.getParameter("pw");
        
        if(Validate.checkUser(lg, pw))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("Home.html");
           rs.include(request, response);
        }
    } 
} 