<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Update Book</h1>
    <form action="${pageContext.request.contextPath}/books/update/${book.id}" method="post">
        <label>Title: </label>
        <input type="text" name="title" value="${book.title}" required /><br/><br/>
        <label>Author: </label>
        <select name="author.id">
            <c:forEach items="${authors}" var="author">
                <option value="${author.id}" <c:if test="${author.id == book.author.id}">selected</c:if>>
                    ${author.name}
                </option>
            </c:forEach>
        </select><br/><br/>
        <input type="submit" value="Update"/>
    </form>
    <c:if test="${not empty errorMsg}">
        <p style="color:red;">${errorMsg}</p>
    </c:if>
</body>
</html>