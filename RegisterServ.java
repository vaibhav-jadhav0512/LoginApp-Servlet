import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisterServ extends HttpServlet
{
	private Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			con=DriverManager.getConnection(url,"root","root");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			String name=req.getParameter("nm");
			String address=req.getParameter("ad");
			String email=req.getParameter("em");
			String login=req.getParameter("lg");
			String password=req.getParameter("pw");
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			pw.println("<br>");
			pw.println("in side register servlet<br>");
			PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,address);
			pst.setString(3,email);
			pst.setString(4,login);
			pst.setString(5,password);
			int k=pst.executeUpdate();
			if(k>0)
			{
				pw.println("Record has been added");
			}
			else
			{
				pw.println("cannot add");
			}
		}
		catch(Exception ee)
		{
			System.out.println("in catch     "+ee);
		}
	}
}
