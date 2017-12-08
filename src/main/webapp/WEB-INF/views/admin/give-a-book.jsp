<%@include file="../layout/menu.jsp"%>

<c:url var="giveBookUrl" value="give-a-book?id=${bookId}" />

<form:form method="POST" modelAttribute="logbook" action="${giveBookUrl}">

<div class="row">

	<spring:bind path="libraryCard.user.username">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="libraryCard.user.username">
				<spring:message code="user.username" />
			</form:label>
			<form:select path="libraryCard.id" cssClass="field-select">
				<form:option value="">---</form:option>
				<form:options items="${libraryCards}" itemValue="id" itemLabel="user.username" />
			</form:select> <form:errors path="libraryCard.user.username" cssClass="error" element="div" />
		</div>
	</spring:bind>

</div>
<hr>
<div class="row">
	<div class="col-lg-2 col-lg-offset-8">
		<button class="btn btn-md btn-primary btn-block" type="submit"><spring:message code="label.update" /></button>
	</div>
</div>
</form:form>
<%@include file="../layout/footer.jsp"%>