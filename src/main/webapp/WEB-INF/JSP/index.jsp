<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>

<!DOCTYPE html>
<html>
<head>
<vdab:head title="Welkom"/>
</head>
<body>
    <table>
      <tr>
        <th>Album</th>
        <th>Artiest</th>
      </tr>
      <c:forEach var="album" items="${albums}">
        <spring:url value="/albums/{id}" var="url">
          <spring:param name="id" value="${album.id}"/>
        </spring:url>
      <tr>
        <td><a href="${url}">${album.naam}</a></td>
        <td>${album.artiest.naam}</td>
      </tr>
      </c:forEach>
    </table>
</body>
</html>