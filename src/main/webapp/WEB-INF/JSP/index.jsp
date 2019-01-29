<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Welkom</title>
</head>
<body>
  <c:forEach var="album" items="${albums}">
    <li>${album.naam}</li>
  </c:forEach>
</body>
</html>