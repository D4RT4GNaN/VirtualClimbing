<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	<body>
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		<div class="wrapper fadeInDown">
		  <div id="formContent">
		    <!-- Tabs Titles -->
		
		    <!-- Icon -->
		    <div class="fadeIn first">
		      	<h3 class="modal-title">Se connecter</h3>
		      	<s:actionerror />
		    </div>
		
		    <!-- Login Form -->
		    <form id="login-form" action="login">
		    	<div class="form-group">
		    		<s:textfield class="fadeIn second form-control" name="user.pseudo" placeholder="Pseudo" />
		    	</div>
		    	<div class="form-group">
		      		<s:textfield class="fadeIn third form-control" name="user.password" placeholder="Mot de passe" />
		      	</div>
		      	<s:submit class="btn btn-secondary fadeIn fourth" value="Connexion" />
		    </form>
		
		    <!-- Remind Passowrd -->
		    <div id="formFooter">
		      	<s:a class="underlineHover" href="#">Mot de passe oublié?</s:a>
		      	<p> 
		      		Vous n'avez pas encore de compte ? 
		      		<s:a class="underlineHover" href="/virtualclimbing-webapp/register">S'inscrire</s:a>
		      	</p>
		    </div>
		
		  </div>
		</div>
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html> 
