<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     <spring:url value="/stable/add" var="el_add" />
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
<body>
<h1>Add new stable:</h1>
  
<form:form method= "POST" action="${el_add}" modelAttribute="newstable">
	<form:hidden path="id"  />
	<form:label path="name" >Stable name:</form:label>
	<form:input path="name"  />
	<form:label path="city" >Stable city:</form:label>
	<form:input path="city"  />
	
	<form:button type="submit">OK</form:button>
</form:form>

<a href= "<c:url value="/stable/show" />">show horses</a>
</body>
</html>