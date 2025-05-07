<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books List</title>
    <%-- The external CSS link is removed --%>
    <style>
        /* CSS styles moved inline */
        body {
            font-family: 'Arial', sans-serif;
            line-height: 1.6;
            margin: 0; /* Reset default margin */
            background-color: #f4f4f4;
            color: #333;
            padding-top: 20px; /* Add some padding at the top */
        }

        .container {
            width: 80%; /* Match table width for alignment */
            margin: 0 auto; /* Center the container */
            padding: 20px; /* Add some padding inside the container */
            background-color: #fff; /* White background for the main content area */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Add shadow */
            border-radius: 8px; /* Rounded corners for the container */
        }

        h1 {
            color: #5a2d82; /* A shade of purple */
            text-align: center;
            margin-top: 0; /* Remove top margin */
            margin-bottom: 20px;
        }

        a {
            color: #5a2d82;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #7a4da6; /* Lighter shade on hover */
            text-decoration: underline;
        }

        .links-container {
            text-align: center; /* Center the inline links */
            margin-bottom: 20px; /* Space below the links */
        }

        .links-container a, .links-container span {
             margin: 0 10px; /* Add space between links and span */
        }


        table {
            width: 100%; /* Make table take full width of its container */
            border-collapse: collapse;
            /* Box shadow and background moved to container */
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #5a2d82;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.1em;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Zebra striping */
        }

        tr:hover {
            background-color: #e9e9e9; /* Highlight row on hover */
        }

        td a {
            margin-right: 5px; /* Adjusted margin for separator */
            color: #5a2d82;
        }

        td a:last-child {
            margin-right: 0;
        }

        .action-separator {
            margin: 0 5px; /* Margin for the separator */
            color: #333; /* Color of the separator */
        }

        /* Removed specific body > a rules */

    </style>
</head>
<body>
    <%-- Wrap content in a container to center it --%>
    <div class="container">
        <h1>Books</h1>
        <%-- Wrap links in a div to center them --%>
        <div class="links-container">
            <a href="${pageContext.request.contextPath}/books/new">Add New Book</a>
            <span> | </span>
            <a href="${pageContext.request.contextPath}/authors/new">Add Author</a>
        </div>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/books/edit/${book.id}">Edit</a>
                        <%-- Added separator between links --%>
                        <span class="action-separator">|</span>
                        <a href="${pageContext.request.contextPath}/books/delete/${book.id}"
                             onclick="return confirm('Are you sure you want to delete this book?');">
                             Delete
                          </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> <%-- End container --%>
</body>
</html>
