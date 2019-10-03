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

<h1>The horses:</h1><a href= "<c:url value="/stable/show" />">--> to the stables...</a>
<table>
	<thead>
		<tr>
		<th>id______________</th>
		<th>name____________</th>
		<th>birthday________</th>
		<th>color___________</th>
		<th>stable____________________</th>
		<th>edit____________</th>
		<th>remove__________</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${lhorse}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.birthday}</td>
				<td>${p.color}</td>
				<td>${p.myStable.getName()}</td>
				<td><a href= "<c:url value="/horse/edit/${p.id}" />">edit</a></td>
				<td><a href= "<c:url value="/horse/delete/${p.id}" />">delete</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h6>Functions: </h6>
	<a href= "<c:url value="/horse/show" />">update</a>
	<a href= "<c:url value="/horse/add" />">add new horse</a>
</body>
</html>