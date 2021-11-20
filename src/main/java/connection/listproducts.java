package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class listproducts
 */

@WebServlet("/listproducts")
public class listproducts extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String DB_URL="jdbc:mysql://localhost:3306/company";
	
    private static final String DB_USER="root";
    
    private static final String DB_PWD="sreelakshmi";
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public listproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=response.getWriter();
		writer.append("<html><body>");		
		
		try {
			DBConnectionUtil dbConnectionUtil =new  DBConnectionUtil(DB_URL,DB_USER,DB_PWD);
			Connection connection= dbConnectionUtil.getConnection();
			
			Statement statement=connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from company");
			
			while(resultSet.next()) {
				
				int id =resultSet.getInt("ID");
				String name =resultSet.getString("name");
				int price = resultSet.getInt("price");
				
				writer.append(id+" " +name+" "+price);
				writer.append("<br/>");
			}
			writer.append("</body></html>");
			connection.close();
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
