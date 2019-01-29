<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<vdab:head title="Album"/>
</head>
<body>
  <h1>${album.naam}</h1>
  <h2>${album.artiest.naam}</h2>
  <table>
    <tr>
      <th>Track</th>
      <th>Duur</th>
    </tr>
  <c:forEach var="track" items="${album.tracks}">
    <tr>
      <td>${track.naam}</td>
      <td>${track.tijd}</td>
    </tr>
  </c:forEach>
    </table>
</body>
</html>