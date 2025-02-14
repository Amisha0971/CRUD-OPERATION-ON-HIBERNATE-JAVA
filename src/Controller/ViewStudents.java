package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Student;

@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Hibernate configuration setup
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Fetching all students from the database
		Query query = session.createQuery("FROM Student");  // Get all students from the Student table
		List<Student> studentList = query.list();  // Execute the query and store the result in studentList

		// Set the student list as a request attribute to pass to the JSP
		request.setAttribute("studentList", studentList);

		// Forward the request to ViewStudents.jsp
		request.getRequestDispatcher("ViewStudents.jsp").forward(request, response);
		
		// Commit and close the session
		tx.commit();
		session.close();
		factory.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
