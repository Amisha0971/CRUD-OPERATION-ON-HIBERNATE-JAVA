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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Name= request.getParameter("name");
		String Email = request.getParameter("email");
		
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
			      
	    SessionFactory factory=cfg.buildSessionFactory();  
	    Session session=factory.openSession();  
	    Transaction tx=session.beginTransaction(); 
		
		Student s = new Student(Name, Email);
		session.save(s);
		request.getRequestDispatcher("ViewStudents").forward(request, response);
        out.print("<b>Succesfully Applied</b>");
	   
	    tx.commit();
	    session.close();
	    factory.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
