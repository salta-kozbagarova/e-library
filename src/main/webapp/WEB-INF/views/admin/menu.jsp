<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextPath}/profile"><spring:message code="label.studentLibrary" /></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${contextPath}/admin"><span class="glyphicon glyphicon-user"></span>${pageContext.request.userPrincipal.name}</a></li>
      <li><a href="${contextPath}/admin/library"><spring:message code="label.library" /></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="?lang=ru">ru</a></li>
      <li><a href="?lang=en">en</a></li>
      <li>
      	<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <a onclick="document.forms['logoutForm'].submit()"><span style="padding-right:5px" class="glyphicon glyphicon-log-in"></span><spring:message code="label.logout" /></a>
      </li>
    </ul>
  </div>
</nav>

<script>
$(".nav a").on("click", function(){
   $(".nav").find(".active").removeClass("active");
   $(this).parent().addClass("active");
});
</script>