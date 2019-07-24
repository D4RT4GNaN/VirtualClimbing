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
		      	<h3 class="modal-title">S'inscrire</h3>
		      	<s:actionerror />
		    </div>
		
		    <!-- Login Form -->
		    <form id="login-form" action="signin">
		    	<div class="form-group">
            		<s:textfield class="form-control" placeholder="Pseudo" name="user.pseudo" />
            	</div>
            	<div class="form-group">
            		<s:textfield class="form-control" placeholder="Prénom" name="user.firstName" />
            	</div>
            	<div class="form-group">
              		<s:textfield class="form-control" placeholder="Nom" name="user.lastName" />
              	</div>
              	<div class="form-group">
              		<s:password class="form-control" placeholder="Mot de passe" name="user.password" />
            	</div>
		      	<s:submit class="btn btn-secondary fadeIn fourth" value="S'inscrire" />
		    </form>
		
		    <!-- Remind Passowrd -->
		    <div id="formFooter">
          		<p> Vous avez déjà un compte ? <s:a href="/virtualclimbing-webapp/connect">Se connecter</s:a></p>
		    </div>
		
		  </div>
		</div>
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html> 