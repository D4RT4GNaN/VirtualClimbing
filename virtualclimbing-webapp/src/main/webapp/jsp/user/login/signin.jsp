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
		      		<s:text name="user.signin.header" />
		      	</h3>
		      	
		      	<s:actionerror />
		    </div>
		
		    <!-- Login Form -->
		    <form id="login-form" action="signin">
           		<s:textfield class="form-group form-control" name="user.pseudo" 
           					 placeholder="%{getText('user.pseudo.placeholder')}" 
           		/>
				
           		<s:textfield class="form-group form-control" name="user.firstName" 
           					 placeholder="%{getText('user.signin.firstName.placeholder')}" 
           		/>
            	
           		<s:textfield class="form-group form-control" name="user.lastName" 
           					 placeholder="%{getText('user.signin.lastName.placeholder')}" 
           		/>
              	
           		<s:password class="form-group form-control" name="user.password" 
           					placeholder="%{getText('user.password.placeholder')}" 
           		/>
				
		      	<s:submit class="btn btn-secondary fadeIn fourth" value="%{getText('user.signin.submit')}" />
		    </form>
		
		    <!-- Remind Passowrd -->
		    <div id="formFooter">
          		<p>  
          			<s:text name="user.signin.message.login" />
          			<s:a action="connect" class="underlineHover">
          				<s:text name="user.signin.button.login" />
          			</s:a>
          		</p>
		    </div>
		  </div>
		</div>
		
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html> 