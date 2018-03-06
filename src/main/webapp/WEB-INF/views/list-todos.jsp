<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<H1>Hi ${name} Your Todos</H1>
	<div>
		<table class="table table-striped">
			<caption>Your Todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>User</th>
					<th>IsCompleted?</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}"
								pattern="MM/dd/yyyy" /></td>
						<td>${todo.done}</td>
						<td><a class="btn btn-success"
							href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a class="btn btn-danger"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
	<div>
		<a class="btn btn-success" href="/add-todo">Add</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>