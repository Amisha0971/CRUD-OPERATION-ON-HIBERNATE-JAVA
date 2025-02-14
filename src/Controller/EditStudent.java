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

import Model.Student;


@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   int Id = Integer.parseInt(request.getParameter("id"));
		   String Name=request.getParameter("name");
		   String Email=request.getParameter("email");
		  
		// Hibernate configuration setup
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			Student s = new Student(Id, Name, Email);

			 session.update(s);
		  	 request.getRequestDispatcher("ViewStudents").include(request, response);
		  	    
			 tx.commit();
			 session.close(); 
			 factory.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
