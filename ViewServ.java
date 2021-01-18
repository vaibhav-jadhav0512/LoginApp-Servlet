import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewServ extends HttpServlet
{
	private Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			con=DriverManager.getConnection(url,"root","Vaibhav@123");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
			
		try
		{	
			PrintWriter out = response.getWriter();  
         		response.setContentType("text/html");  
         		out.println("<html><body>");  
			Statement stmt = con.createStatement();  
             		ResultSet rs = stmt.executeQuery("select * from register"); 
			out.println("<table border=1 width=50% height=50%>");  
             		out.println("<tr><th>name</th><th>address</th><th>email</th><th>loginId</th><tr>");
			while(rs.next())
			{
				String name=rs.getString("name");
				String address=rs.getString("address");
				String email=rs.getString("email");
				String loginId=rs.getString("loginId");
				out.println("<tr><td>" + name + "</td><td>" + address + "</td><td>" + email + "</td><td>" + loginId + "</td></tr>");   
			}

			out.println("</table>");  
             		out.println("</html></body>");  
             		con.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}