package servlet;

import java.io.IOException
;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserserviceImpl;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"} )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.getWriter().write("login get received"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        HttpSession session = request.getSession();
	        UserService userService = new UserserviceImpl();
	        String msg = userService.doLogin(username, password, session);
	        request.setAttribute("msg", msg);
	        //response.getWriter().write("login post received");
	        request.getRequestDispatcher("/login_result.jsp").forward(request, response);
		
	}

}
