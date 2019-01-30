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
    <thead>
      <tr>
        <th>Naam</th>
        <th>Duur</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="track" items="${album.tracks}">
      <tr>
        <td>${track.naam}</td>
        <td>${track.tijd}</td>
      </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr class='border-top'>    
        <td>Totale duur</td>
        <td>${album.tijd}</td>
      </tr>
    </tfoot>
  </table>
</body>
</html>