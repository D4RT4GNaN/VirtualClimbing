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
    			$( "#datepicker" ).datepicker();
	  		} );
		</script>
	</head>
	<body id="search-body">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div id="main_wrapper" class="container-fluid">
				
			<s:if test="!listTopo.isEmpty()">
				<section class="search-section">
					<div class="search-div">
						<div class="row text-center search-page">
							<s:iterator value="listTopo">
								<div class="col-lg-3 col-md-6 mb-4">
									<div class="card h-100">
										<img class="card-img-top" src="images/781x250.svg" alt="" />
										<div class="card-body">
											<h2 class="card-title">
												<s:property value="name" />
											</h2>
											<p class="card-text">
												<s:property value="description" />
											</p>
										</div>
										<form action="rent_topo" class="card-footer">
											<s:actionmessage />
											<s:actionerror />
											<s:textfield name="booking.topo.name" value="%{name}" hidden="true" />
											<p>Date d'expiration: <input type="text" name="endDate" id="datepicker" class="form-control"></p>
											<s:submit class="btn btn-outline-secondary" value="Réserver" />
										</form>
									</div>
								</div>
							</s:iterator>
						</div>
					</div>
				</section>
			</s:if>
			<s:else>
				<div class="center-topo-notfound">
					<h1 class="user-div">Aucun Topo trouvé</h1>
				</div>
			</s:else>

        </div>
        
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html>