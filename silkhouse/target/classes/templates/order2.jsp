<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/dbms/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<%@ page isELIgnored="false"%>
<title>order2</title>
</head>
<body style="background: #ffe6e6">
<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background: #ffcccc !important">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RANJAN DECORATORS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/dbms/user"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
				<li class="active"><a href="/dbms/allcat">CATEGORIES</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			<li><a href="/dbms/buyitem/cart"><span class="glyphicon glyphicon-shopping-cart"></span>CART</a></li>
				<li><c:if test="${pageContext.request.userPrincipal.name != null}">
					 <a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if><li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div class="container">
	<table class="table table-striped">
		<thead>
		<th>Location</th>
		<th>Booking date</th>
		<th>Event</th>
		<th>Price</th>
		</thead>
		<tbody>
		<tr>
		<td>${list[0].lname }</td>
		<td>${list[0].bdate }</td>
		<td>${list[0].event }</td>
		<td>${list[0].price }</td>
		</tr>
		</tbody>
		<table class="table table-striped">
		<thead>
		<th>name</th>
		<th>quantity</th>
		<th>subtotal</th>
		</thead>
		<tbody>
<c:forEach items="${list }" var="order">
<tr>
<td>${order.name }</td>
<td>${order.quantity }</td>
<td>${order.tprice }</td>
</tr>

</c:forEach> 
</tbody>
</table>

</div>
<script src="/dbms/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="/dbms/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>