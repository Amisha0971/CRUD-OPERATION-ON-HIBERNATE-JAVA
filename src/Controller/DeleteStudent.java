package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int Id=Integer.parseInt(request.getParameter("id"));
		
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
			      
	    SessionFactory factory=cfg.buildSessionFactory();  
	    Session session=factory.openSession();  
	    Transaction tx=session.beginTransaction(); 
	    
	    try {
	    	  String hql = "DELETE FROM Student WHERE id = :id";
	    	  Query query = session.createQuery(hql);
	    	  query.setParameter("id",Id);
	    	  query.executeUpdate();
	    	  System.out.println("Successfully Deleted");
	    	  request.getRequestDispatcher("ViewStudents").include(request, response);
	    	  tx.commit();
	    	} catch (Throwable t) {
	    	  tx.rollback();
	    	  throw t;
	    	}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
