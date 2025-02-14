<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="Model.Student"%>
<%@ page import="java.util.List"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student List</title>
    <style>
        /* Basic styling for the container */
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        /* Styling the table */
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        /* Button styling */
        .add-btn {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }

        .add-btn:hover {
            background-color: #45a049;
        }

        .btn-info {
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border-radius: 5px;
            margin: 0 5px;
        }

        .btn-info:hover {
            background-color: #45a049;
        }

        /* Centering the content */
        .center {
            text-align: center;
        }

        /* Styling the table buttons for Edit/Delete */
        .table-buttons {
            text-align: center;
        }

        .table-buttons a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="center">Student List</h1>
        
        <!-- Button for adding new student -->
        <div class="center">
            <button class="add-btn" onclick="window.location.href='AddStudent.jsp'">Add Student</button>
        </div>

        <% 
            List<Student> studentList = (List<Student>) request.getAttribute("studentList");
            if(studentList != null && !studentList.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Actions</th> <!-- Added Actions column for Edit/Delete -->
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for(Student s : studentList) { 
                    %>
                        <tr>
                            <td><%=s.getId()%></td>
                            <td><%=s.getName()%></td>
                            <td><%=s.getEmail()%></td>
                            <td class="table-buttons">
                                <a href="getStudent?id=<%=s.getId()%>" class="btn-info">Edit</a>
                                <a href="deleteStudent?id=<%=s.getId()%>" class="btn-info">Delete</a>
                            </td>
                        </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        <% 
            } else { 
        %>
            <p>No students found.</p>
        <% } %>
    </div>
</body>
</html>
