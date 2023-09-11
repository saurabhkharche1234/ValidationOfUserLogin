package loginServletPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h3>Welcome To Login Page</h3><br/>");
		request.getRequestDispatcher("link.html").include(request, response); 
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(password.equals("naruto")) {
		out.print("Welcome "+name);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		}else {
			out.print("Invalid Password! Please try again!");
			request.getRequestDispatcher("login.html").include(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
