<th:block th:include="header"></th:block>
<head>
<title>register</title>
</head>
<body style="background: #ffe6e6">
<div class="container">
	<form:form method="post" modelAttribute="user" action="register" class="form-inline">
	<div class="form-group">
            <label for="">USERNAME</label>
            <br>
            <form:input type="text" class="form-control" path="username" placeholder="username" value="aaa" />
            <form:errors path="username" />
        </div>
			<br>
			<br>
			<div class="form-group">
			<label for="">PASSWORD</label>
			<br>
				<form:input path="password" type="password" class="form-control" placeholder="password" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="password" />
			</div>
			<br>
			<br>
			<div class="form-group">

				<label for="">Confirm password</label>
				<br>
				<form:input path="mpassword" type="password" class="form-control" value="aaa" />
				<!-- bind to user.name-->
				<form:errors path="mpassword" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">NAME</label>
			<br>
				<form:input path="name" type="text" class="form-control" placeholder="@name" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="name" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">EMAIL</label>
			<br>
				<form:input path="email" type="text" class="form-control" placeholder="@email" value="aaa"/>
				<!-- bind to user.name-->
				<form:errors path="email" />
			</div>
			<br>
			<br>
			<div class="form-group">
			<label for="">PHONE</label>
			<br>
				<form:input path="phone" type="text" class="form-control" placeholder="@phone" value="111"/>
				<!-- bind to user.name-->
				<form:errors path="phone" />
			</div>
			<br>
			<br>

			<button type="submit" class="btn btn-primary">Submit</button>
				
				<td>${error}</td>
			
	</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <th:block th:include="tail"></th:block>
</body>
