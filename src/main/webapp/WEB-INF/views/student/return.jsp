<%@include file="../layout/menu.jsp"%>
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
				<th><spring:message code="logbook.book_issuing_type" /></th>
				<th><spring:message code="logbook.checkOutDate" /></th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${logbooks}" var="logbook">
				<c:url var="returnBookUrl" value="return-book?id=${logbook.id}" />
				<tr>
					<td><c:out value="${logbook.book.id}" /></td>
					<td><c:out value="${logbook.book.name}" /></td>
					<td><c:out value="${logbook.book.author}" /></td>
					<td><c:out value="${logbook.book.publisher.name}" /></td>
					<td><c:out value="${logbook.book.city.name}" /></td>
					<td><c:out value="${logbook.book.genre.name}" /></td>
					<td><c:out value="${logbook.bookIssuingType}" /></td>
					<td><c:out value="${logbook.checkOutDate}" /></td>
					<td><a href="${returnBookUrl}" class="returnBook">
							<spring:message	code="book.returnBook" />
						</a></td>
				</tr>
			</c:forEach>
			<c:if test="${empty logbooks}">
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