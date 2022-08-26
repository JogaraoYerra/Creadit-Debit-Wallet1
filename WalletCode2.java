

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WalletCode2
 */
@WebServlet("/WalletCode2")
public class WalletCode2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalletCode2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		long accountnumber=Long.parseLong(request.getParameter("n1"));
		double balance=Double.parseDouble(request.getParameter("n2"));
		
try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mdb","mdb");
			PreparedStatement ps=con.prepareStatement("update account set balance=balance-? where accountnumber=?");
			
			
			
			ps.setDouble(1,balance);
			ps.setLong(2,accountnumber);
			
			
			int i=ps.executeUpdate();
			
			out.print(i+"Amount debit");
			con.close();
			}
catch(Exception ex)
{
	out.print(ex);
	}


	}

}
