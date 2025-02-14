<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="Model.Student"%>
<%@ page import="java.util.List"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update Student</title>
<style>
    /* Apply a full height container */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #4CAF50; /* Optional background color */
    }

    .container {
        padding: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px; /* Set max-width for form size */
    }

    h1 {
        text-align: center;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    input, button {
        margin-bottom: 10px;
        padding: 10px;
        width: 80%;
    }

    button {
        cursor: pointer;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
    }

    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList"); 

    if (studentList != null && !studentList.isEmpty()) { 
        Student s = studentList.get(0); // Fetch the first student record
%>
    <div class="container">
        <h1>Update Student</h1>
        <form action="editStudent" method="post">
            <input type="hidden" name="id" value="<%=s.getId()%>">
            <b>Name:</b> 
            <input type="text" name="name" value="<%=s.getName()%>" required><br>
            <b>Email:</b> 
            <input type="email" name="email" value="<%=s.getEmail()%>" required><br>
            <button type="submit">Update Student</button>
        </form>
    </div>
<%
    } else {
%>
    <h2 style="color: white; text-align: center;">No student found for update.</h2>
<%
    }
%>
</body>
</html>
