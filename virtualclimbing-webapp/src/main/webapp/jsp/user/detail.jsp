<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
    
<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	
	<body class="container-fluid">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div id="main_wrapper" class="main-wrapper-vertical-center main-wrapper-spacearound row">
            <div class="user-div col-md-5">
            	<div class="m-0 p-0">
	            	<h3 class="d-flex justify-content-between">
	            		<s:property value="#session.user.pseudo" />
	            	</h3>
	            	
	           		<s:textfield class="underline-input form-group" value="%{#session.user.firstName}" readOnly="true" />
	           		<s:textfield class="underline-input form-group" value="%{#session.user.lastName}" readOnly="true" />
	           	</div>

            	<form class="password-form" action="change_password">
            		<fieldset>
            			<legend>
            				<s:text name="user.detail.password.legend" />
            			</legend>
            			
	            		<s:password name="user.password" class="form-group form-control" 
	            					placeholder="%{getText('user.password.placeholder')}" 
	            		/>
	            		
	            		<s:password name="confirmPassword" class="form-group form-control" 
	            					placeholder="%{getText('user.detail.password.confirmPassword.placeholder')}" 
	            		/>
	            		
	            		<div class="text-center">
                            <s:submit class="btn btn-outline-secondary" value="%{getText('user.detail.password.submit')}" />
                        </div>		
            		</fieldset>
            	</form>
            </div>
            
            <div class="user-div col-md-5">
            	<h3>
            		<s:text name="user.detail.booking.header" />
            	</h3>
            	
            	<div class="booking-div p-0">
            		<s:if test="listBooking.isEmpty()">
            			<p class="text-center align-middle font-weight-bold font-italic pt-3">
            				<s:text name="user.detail.booking.noBooking" />
            			</p>
            		</s:if>
            		<s:else>
            			<table class="table table-striped table-responsive-sm th-lg m-0">
            				<thead>
            					<tr>
							    	<th scope="col">
							    		<s:text name="booking.detail.thead.name" />
							    	</th>
							      	<th scope="col">
							      		<s:text name="booking.detail.thead.end" />
							      	</th>
							      	<th scope="col">
							      		<s:text name="booking.detail.thead.access" />
							      	</th>
							    </tr>
            				</thead>
		            		<tbody id="nameList">
		              			<s:iterator value="listBooking" begin="listBooking.size()-1" end="endIteration" step="-1">
									<tr>
										<td>
											<s:property value="topo.name" />
										</td>
										
										<td>
											<s:property value="endDate" />
										</td>
										
										<td>
											<s:if test="isAfter()">
												<s:a action="detail_topo" class="btn btn-outline-secondary">
													<s:param name="name" value="topo.name" />
													<s:text name="booking.detail.access.link" />
												</s:a>
											</s:if>
											<s:else>
												<s:a class="btn btn-outline-secondary disabled">
													<s:text name="booking.detail.access.link" />
												</s:a>
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
        
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html>