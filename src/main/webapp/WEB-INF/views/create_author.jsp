<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Author</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Add Author</h1>
    <form action="${pageContext.request.contextPath}/authors" method="post">
        Name: <input type="text" name="name" required /><br/><br/>
        Country: <input type="text" name="country" required /><br/><br/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>