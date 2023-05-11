

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class for Servlet: RegSer
 *
 */
 public class RegSer extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public RegSer() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	RegBean o=new RegBean();
	o.setFirstname(firstname);
	o.setlastname(lastname);
	o.setUsername(username);
	o.setPassword(password);
	Reg ra= new Reg();
	boolean status=ra.registerdetails(o);
	if(status){
		RequestDispatcher r = getServletContext().getRequestDispatcher("/RegisterSuccess.jsp");
		r.forward(request,response);
	}else{
		response.sendRedirect("RegisterUnSuccess.jsp");
	}
	
}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  	  	    
}