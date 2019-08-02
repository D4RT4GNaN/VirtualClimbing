<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/jsp/_include/structure/head.jsp" %>
		
	  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  	<link rel="stylesheet" href="/resources/demos/style.css">
	  	
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		<script>
  			$( function() {
  				$( "input[id^=endDate]" ).datepicker();
	  		} );
		</script>
	</head>
	
	<body>
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div>	
			<s:if test="!listTopo.isEmpty()">
				<section class="container-fluid main">
					<div class="row text-center pt-2">
						<s:iterator value="listTopo" status="stats">
							<div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 mb-4">
								<div class="card text-center">
									<!-- Card Header -->
									<div class="card-header">
										<h2 class="card-title">
											<s:property value="name" />
										</h2>
									</div>
									
									<!-- Card Body -->
									<div class="card-body">
										<p class="card-text card-overflow">
											<s:property value="description" />
										</p>
									</div>
									
									<!-- Card Footer -->
									<div class="card-footer">
										<form action="rent_topo">											
											<s:hidden name="booking.topo.name" value="%{name}" />
											<p>
												<s:text name="booking.search.expirationDate" />
												: 
												<s:textfield id="endDate%{#stats.index}" name="endDate" class="form-control datepicker" />
											</p>
											
											<s:submit class="btn btn-outline-secondary" value="%{getText('booking.search.submit')}" />
										</form>
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
				</section>
			</s:if>
			
			<s:else>
				<div class="center-topo-notfound">
					<h1 class="user-div">
						<s:text name="booking.search.noResult" />
					</h1>
				</div>
			</s:else>
        </div>
        
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html>