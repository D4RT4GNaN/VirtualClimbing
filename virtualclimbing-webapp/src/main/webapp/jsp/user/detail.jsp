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
            	<div class="booking-div p-0">
            		<s:if test="listBooking.isEmpty()">
            			<p class="text-center align-middle font-weight-bold font-italic pt-3">Aucune réservation en mémoire</p>
            		</s:if>
            		<s:else>
            			<table class="table table-striped m-0">
            				<thead>
            					<tr>
							    	<th scope="col">Nom</th>
							      	<th scope="col">Fin</th>
							      	<th scope="col">Accès</th>
							    </tr>
            				</thead>
		            		<tbody id="nameList">
		              			<s:iterator value="listBooking" begin="listBooking.size()-1" end="endIteration" step="-1">
									<tr>
										<td><s:property value="topo.name" /></td>
										<td><s:property value="endDate" /></td>
										<td>
											<s:if test="isAfter()">
												<s:a action="detail_topo" class="btn btn-outline-secondary">
													<s:param name="name" value="topo.name" />
													Voir
												</s:a>
											</s:if>
											<s:else>
												<s:a class="btn btn-outline-secondary disabled">Voir</s:a>
											</s:else>
										</td>
									</tr>
								</s:iterator>
							</tbody>
		            	</table>
            		</s:else>
            	</div>
            </div>
            
        </div>
        
		<%@ include file="/jsp/_include/footer.jsp" %>
	</body>
</html>