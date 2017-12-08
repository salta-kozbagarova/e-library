<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title><spring:message code="label.studentLibrary" /></title>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	<link href="${contextPath}/resources/css/style.css" rel="stylesheet">

  
</head>

<body>
  
<div class="container">
	<div class="info">
		<h1><spring:message code="label.studentLibrary" /></h1><span><a href="?lang=ru" style="padding-right:5px">RU</a><a href="?lang=en" style="padding-left:5px">EN</a></span>
	</div>
</div>
<div class="form">
  <div class="thumbnail"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg"/></div>
  <form:form method="POST" modelAttribute="registrationForm"  class="register-form" action="${contextPath}/registration">
       <spring:bind path="user.username">
       <spring:message code="user.username" var="usernamePlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="user.username" placeholder="${usernamePlaceholder }"
                           autofocus="true"></form:input>
               <form:errors path="user.username"></form:errors>
           </div>
       </spring:bind>

       <spring:bind path="user.password">
       <spring:message code="user.password" var="passwordPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="password" path="user.password" placeholder="${passwordPlaceholder }"></form:input>
               <form:errors path="user.password"></form:errors>
           </div>
       </spring:bind>

       <spring:bind path="user.confirmPassword">
       <spring:message code="user.confirmPassword" var="confirmPasswordPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="password" path="user.confirmPassword"
                           placeholder="${confirmPasswordPlaceholder }"></form:input>
               <form:errors path="user.confirmPassword"></form:errors>
           </div>
       </spring:bind>
       
       <spring:bind path="libraryCard.firstname">
       <spring:message code="libraryCard.firstname" var="firstnamePlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="libraryCard.firstname" placeholder="${firstnamePlaceholder }"
                           autofocus="true"></form:input>
               <form:errors path="libraryCard.firstname"></form:errors>
           </div>
       </spring:bind>
       
       <spring:bind path="libraryCard.lastname">
       <spring:message code="libraryCard.lastname" var="lastnamePlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="libraryCard.lastname" placeholder="${lastnamePlaceholder }"
                           autofocus="true"></form:input>
               <form:errors path="libraryCard.lastname"></form:errors>
           </div>
       </spring:bind>
       
       <spring:bind path="libraryCard.course">
       <spring:message code="libraryCard.course" var="coursePlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="libraryCard.course" placeholder="${coursePlaceholder }"
                           autofocus="true"></form:input>
               <form:errors path="libraryCard.course"></form:errors>
           </div>
       </spring:bind>
       
       <spring:bind path="libraryCard.admissionYear">
       <spring:message code="libraryCard.admissionYear" var="admissionYearPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="libraryCard.admissionYear" placeholder="${admissionYearPlaceholder }"
                           autofocus="true"></form:input>
               <form:errors path="libraryCard.admissionYear"></form:errors>
           </div>
       </spring:bind>

       <button><spring:message code="label.signup" /></button>
       <p class="message"><spring:message code="label.alreadyRegistered?" /> <a href="#"><spring:message code="label.signin" /></a></p>
	</form:form>
  <form method="POST" action="${contextPath}/login"  class="login-form">

       <div class="form-group ${error != null ? 'has-error' : ''}">
           <span>${message}</span>
           <input name="username" type="text" placeholder="${usernamePlaceholder }"
                  autofocus="true"/>
           <input name="password" type="password" placeholder="${passwordPlaceholder }"/>
           <span>${error}</span>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

           <button><spring:message code="label.signin" /></button>
       </div>
       <p class="message"><spring:message code="label.notRegistered?" /> <a href="#"><spring:message code="label.createAnAccount" /></a></p>
   </form>
</div>
<video id="video" autoplay="autoplay" loop="loop" poster="polina.jpg">
  <source src="http://andytran.me/A%20peaceful%20nature%20timelapse%20video.mp4" type="video/mp4"/>
</video>


	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="${contextPath}/resources/js/index.js"></script>

</body>
</html>
