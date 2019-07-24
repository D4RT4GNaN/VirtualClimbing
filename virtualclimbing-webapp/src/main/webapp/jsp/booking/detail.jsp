<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	<body id="search-body">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div id="main_wrapper" class="container-fluid d-flex main-wrapper-center">
			<div class="booking-div-booking">
				<table class="table table-striped m-0">
	   				<thead>
	   					<tr>
				    		<th scope="col">Nom</th>
					      	<th scope="col">Fin</th>
					      	<th scope="col">Accès</th>
					    </tr>
	   				</thead>
	           		<tbody id="nameList">
	              		<s:iterator value="listBooking" begin="listBooking.size()-1" end="0" step="-1">
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
	    	</div>
        </div>
        
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html>