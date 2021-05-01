<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>HomePage!</title>
</head>
<body>
	<div class="conainer mt-3">
		<!-- creating a container and adding margin from top by 3 unit and adding class text-center so that the text are centerted -->

		<h1 class="text-center">This is the HomePage</h1>


		<div class="row mt-5 ml-5">
			<!-- Each row has 12 grids -->
			<div class="col-md-2">
				<h3 class="text-center">Options</h3>
				<!--  Giving this column 2 grids and centering the text -->


				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">
						Menu</button>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action">Add ToDo</a> <a
						href='<c:url value='/home'></c:url>'
						class="list-group-item list-group-item-action">View Todos</a>
				</div>


			</div>

			<div class="col-md-10">
				<h3 class="text-center">Contents</h3>


				<c:if test="${page=='home'}">
					<h1 class="text-center">View Todos</h1>
				</c:if>

				<c:if test="${page=='add'}">
					<h1 class="text-center">Add Todos</h1>
					    <!-- action="saveToDo" adds relative url -->
					<form:form action="saveTodo" method="post" modelAttribute="todo">
						 <!-- the todo of modelAttribute="todo" comes from the controller which tells spring what entity to used for mapping-->
						<!-- the action and method part of the form is traditional -->
						<!-- the model attribute value will be used in the controller to recognize the form to be mapped with the entity -->

						<div class="form-group">
							<form:input cssClass="form-control"
								placeholder="Enter your todo title" path="todoTitle" />
										<!-- the path has to match exactly the variable name in the entity class-->
						</div>

						<div class="form-group">
							<form:textarea cssClass="form-control" cssStyle="height:300px"
								placeholder="Enter your todo Content" path="todoContent" />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add Todo</button>
						</div>

					</form:form>
				
				</c:if>

				<!--  Giving this column remaining 10 grids and centering the text -->
			</div>

		</div>

	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>