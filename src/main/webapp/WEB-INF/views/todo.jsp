<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<H1>Add a Todo</H1>
	<%--Regular form --%>
	<%-- <form method="post">

			<fieldset class="form-group">
				<label>Description</label> <input name="desc" type="text"
					class="form-control" required="required"/>
			</fieldset>
			<input type="submit" value="Add" class="btn btn-success" />

		</form> --%>

	<%--using command bean--%>

	<form:form method="post" commandName="todo">

		<fieldset class="form-group">
			<%--while updating the desc these values will sent as hiddent values--%>
			<form:hidden path="id" />
			<%--hidden parameters will be visible so prefer using session value --%>
			<%-- <form:hidden path="user"/> --%>

			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning"></form:errors>

			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>

		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>