<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form:form action="/login" method="POST">

		<fieldset class="form-group">
			<label>Name</label> <input name="name" type="text"
				placeholder="${name}" class="formcontrol" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password"
				class="formcontrol" />
		</fieldset>

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>