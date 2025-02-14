package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/getStudent")
public class GetStudent extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int Id = Integer.parseInt(request.getParameter("id")); // Get ID from request

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Fetch student by ID using session.get() instead of HQL
        Student student = session.get(Student.class, Id);
        
        if (student != null) {
            List<Student> studentList = new ArrayList<>(); // ✅ Corrected method
            studentList.add(student);
            request.setAttribute("studentList", studentList);
        }

        tx.commit(); // Commit before forwarding
        session.close();
        factory.close();

        // Forward the request to getStudent.jsp
        request.getRequestDispatcher("getStudent.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
