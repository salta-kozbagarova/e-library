<%@include file="../layout/menu.jsp"%>

<title>Profile</title>

<c:url var="uploadImgUrl" value="upload-image?id=${profileForm.libraryCard.id}&${_csrf.parameterName}=${_csrf.token}" />
<c:choose>
    <c:when test="${!profileForm.libraryCard.image.isEmpty() && profileForm.libraryCard.image.length()>0}">
        <c:url var="getImgUrl" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/uploads/${profileForm.libraryCard.image}"/>
    </c:when>
    <c:otherwise>
        <c:url var="getImgUrl" value="/resources/images/no-photo.png"/>
    </c:otherwise>
</c:choose>

<form:form method="POST" modelAttribute="profileForm" enctype="multipart/form-data" action="${uploadImgUrl}">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-2">
	        <spring:bind path="user.username">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="user.username">
						<spring:message code="user.username" />
					</form:label>
	                <form:input type="text" path="user.username" class="form-control" placeholder="Username"
	                            autofocus="true"></form:input>
	                <form:errors path="user.username"></form:errors>
	            </div>
	        </spring:bind>
	        <img src="${getImgUrl}" style="width: 181px; height: 180px" />
	        <spring:bind path="file">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="file">
						<spring:message code="label.uploadImage" />
					</form:label>
	                <form:input type="file" path="file" class="form-control"></form:input>
	                <form:errors path="file"></form:errors>
	            </div>
	        </spring:bind>
		</div>
		<div class="col-lg-4">
			<spring:bind path="libraryCard.firstname">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="libraryCard.firstname">
						<spring:message code="libraryCard.firstname" />
					</form:label>
	                <form:input type="text" path="libraryCard.firstname" class="form-control" placeholder="Firstname"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.firstname"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.lastname">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="libraryCard.lastname">
						<spring:message code="libraryCard.lastname" />
					</form:label>
	                <form:input type="text" path="libraryCard.lastname" class="form-control" placeholder="Lastname"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.lastname"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.course">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="libraryCard.course">
						<spring:message code="libraryCard.course" />
					</form:label>
	                <form:input type="text" path="libraryCard.course" class="form-control" placeholder="Course"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.course"></form:errors>
	            </div>
	        </spring:bind>
	        
	        <spring:bind path="libraryCard.admissionYear">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            	<form:label path="libraryCard.admissionYear">
						<spring:message code="libraryCard.admissionYear" />
					</form:label>
	                <form:input type="text" path="libraryCard.admissionYear" class="form-control" placeholder="Admission Year"
	                            autofocus="true"></form:input>
	                <form:errors path="libraryCard.admissionYear"></form:errors>
	            </div>
	        </spring:bind> 
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-lg-2 col-lg-offset-8">
			<button class="btn btn-md btn-primary btn-block" type="submit"><spring:message code="label.update" /></button>
		</div>
	</div>
</form:form>
	
	

    


<%@include file="../layout/footer.jsp"%>