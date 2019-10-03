<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/titletag.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js">
  </script>
</head>
<body style= "background-image: url('images/pferd.jpg')">

<h1>The Stables:</h1><a href= "<c:url value="/horse/show" />">--> to the horses...</a>
<table>
	<thead>
		<tr>
		<th>id______________</th>
		<th>name____________</th>
		<th>city______________________</th>
		<th>edit____________</th>
		<th>remove__________</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${lstable}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.city}</td>
				<td><a href= "<c:url value="/stable/edit/${p.id}" />">edit</a></td>
				<td><a href= "<c:url value="/stable/delete/${p.id}" />">delete</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h6>Functions: </h6>
	<a href= "<c:url value="/stable/show" />">update</a>
	<a href= "<c:url value="/stable/add" />">add new stable</a>
	
</body>
</html>