<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="fileUpload" method="POST" enctype="multipart/form-data">
    <input type=file name="files" accept="image/*">
    <input type="submit" value="提交"/>
</form>
</body>
</html>
