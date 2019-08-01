<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	
	<body class="background-login">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div class="wrapper fadeInDown">
	  		<div id="formContent">
		    	<!-- Header -->
			    <div class="fadeIn first">
			      	<h3 class="modal-title">
			      		<s:text name="user.login.header" />
			      	</h3>
			      	
			      	<s:actionerror />
			    </div>
		
			    <!-- Login Form -->
			    <form id="login-form" action="login">
			    	<div class="form-group">
			    		<s:textfield class="fadeIn second form-control" name="user.pseudo" 
			    					 placeholder="%{getText('user.pseudo.placeholder')}" 
			    		/>
			    	</div>
			    	
			    	<div class="form-group">
			      		<s:password class="fadeIn third form-control" name="user.password" 
			      					placeholder="%{getText('user.password.placeholder')}" 
			      		/>
			      	</div>
			      	
			      	<s:submit class="btn btn-secondary fadeIn fourth" value="%{getText('user.login.submit')}" />
			    </form>
		
			    <!-- Remind Password / Signin -->
			    <div id="formFooter">
			      	<s:a class="underlineHover" href="#">
			      		<s:text name="user.login.button.forgottenPassword" />
			      	</s:a>
			      	
			      	<p> 
			      		<s:text name="user.login.message.signin" />
			      		<s:a class="underlineHover" action="register">
			      			<s:text name="user.login.button.signin" />
			      		</s:a>
			      	</p>
			    </div>
	  		</div>
		</div>
		
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html> 
