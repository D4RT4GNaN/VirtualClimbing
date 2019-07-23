<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
    
<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/head.jsp" %>
	<body class="container-fluid">
		<%@ include file="/jsp/_include/header.jsp" %>
		
		<div id="main_wrapper" class="main-wrapper-vertical-center main-wrapper-spacearound row">
            
            <div class="user-div col-sm-5">
            	<h3 class="d-flex justify-content-between">
            		<s:property value="#session.user.pseudo" />
            		<i class="fas fa-edit"></i>
            	</h3>
            	<s:actionmessage />
            	<s:actionerror />
            	<form action="">
            		<s:textfield class="underline-input form-group" value="%{#session.user.firstName}" readOnly="true" />
            		<s:textfield class="underline-input form-group" value="%{#session.user.lastName}" readOnly="true" />
            		<div class="text-center" hidden>
                        <s:submit class="btn btn-outline-secondary" value="Envoyez" />
                    </div>	
            	</form>
            	<form action="change_password">
            		<fieldset>
            			<legend>Changer de mot de passe</legend>
	            		<s:password name="user.password" class="form-group form-control" placeholder="Mot de passe" />
	            		<s:password name="confirmPassword" class="form-group form-control" placeholder="Confirme Mot de passe" />
	            		<div class="text-center">
                            <s:submit class="btn btn-outline-secondary" value="Envoyez" />
                        </div>		
            		</fieldset>
            	</form>
            </div>
            <div class="user-div col-sm-5">
            	<h3>Réservations</h3>
            </div>
            
        </div>
        
		<%@ include file="/jsp/_include/footer.jsp" %>
	</body>
</html>