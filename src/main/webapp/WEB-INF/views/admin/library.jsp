<%@include file="menu.jsp"%>
<title><spring:message code="label.library" /></title>


<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th><spring:message code="book.id" /></th>
				<th><spring:message code="book.name" /></th>
				<th><spring:message code="book.author" /></th>
				<th><spring:message code="book.publisher" /></th>
				<th><spring:message code="book.city" /></th>
				<th><spring:message code="book.genre" /></th>
				<th><spring:message code="book.quantity" /></th>
				<th><spring:message code="book.isInStock" /></th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<c:url var="giveBookUrl" value="give-a-book?id=${book.id}" />
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.publisher.name}" /></td>
					<td><c:out value="${book.city.name}" /></td>
					<td><c:out value="${book.genre.name}" /></td>
					<td><c:out value="${book.quantity}" /></td>
					<td><span class="${book.quantity>0?'glyphicon glyphicon-ok':'glyphicon glyphicon-minus'}" aria-hidden="true"></span></td>
					<td><a href="${giveBookUrl}" class="takeBook">
							<spring:message	code="book.giveBook" />
						</a></td>
				</tr>
			</c:forEach>
			<c:if test="${empty books}">
				<td colspan="9"><spring:message code="label.nodata" />.</td>
			</c:if>
		</tbody>
	</table>
</div>

<script>
/* $(document).ready(function(){
	$('.takeBook').click(function(e){
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: '${takeBookUrl}',
			success : function(data) {
				console.log("SUCCESS: ", data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		
	});
}); */
</script>

<%@include file="../layout/footer.jsp"%>