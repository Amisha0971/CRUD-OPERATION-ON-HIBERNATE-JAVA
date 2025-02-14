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

        /* Button styling */
        .view-btn {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }

        .view-btn:hover {
            background-color: #45a049;
        }

        /* Centering the content */
        .center {
            text-align: center;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1 class="center">Student Dashboard</h1>

        <!-- Button to view student list -->
        <div class="center">
            <a href="ViewStudents" class="view-btn">View Students</a>
        </div>
    </div>
</body>
</html>
