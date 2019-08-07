<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	
	<body>
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div class="container-fluid h-100">
			<div class="row h-100 bg-dark">
				<nav class="col-md-2 col-sm-12 bg-dark sidebar">
					<ul class="nav nav-pills nav-stacked pr-1">
						<li>
							<s:a class="nav-link active" data-toggle="tab" href="#v-pills-topo">
								<s:text name="content.pills.topo" />
							</s:a>
						</li>
						
						<li>
							<s:a class="nav-link" data-toggle="tab" href="#v-pills-site">
								<s:text name="content.pills.site" />
							</s:a>
						</li>
						
						<li>
							<s:a class="nav-link" data-toggle="tab" href="#v-pills-sector">
								<s:text name="content.pills.sector" />
							</s:a>
						</li>
						
						<li>
							<s:a class="nav-link" data-toggle="tab" href="#v-pills-route">
								<s:text name="content.pills.route" />
							</s:a>
						</li>
						<li>
							<button class="d-md-none btn nav-link" type="button" 
						    		data-toggle="collapse" data-target="#filter" 
						    		aria-controls="filter" aria-expanded="false" 
						    		aria-label="Toggle filter">
						        <i class="fas fa-filter"></i>
						    </button>
						</li>
					</ul>
					
					<form id="filter" action="filter" class="mt-md-5 px-2 py-2 collapse dont-collapse-md">
						<s:hidden name="keyword" value="%{keyword}" />
						
						<s:select name="filter.numberOfSite" list="filter.listNumberSite" 
								  headerKey="-1" headerValue="%{getText('content.search.filter.sitePlaceholder')}" 
								  class="form-group form-control" 
						/>
						<s:select name="filter.numberOfSector" list="filter.listNumberSector" 
								  headerKey="-1" headerValue="%{getText('content.search.filter.sectorPlaceholder')}" 
								  class="form-group form-control" 
						/>
						<s:select name="filter.numberOfRoute" list="filter.listNumberRoute" 
								  headerKey="-1" headerValue="%{getText('content.search.filter.routePlaceholder')}" 
								  class="form-group form-control" 
						/>
						
						<s:submit class="form-control btn btn-outline-light" value="%{getText('content.search.filter.submit')}" />
					</form>
				</nav>
			
			
				<div class="col-md-10 ml-sm-auto px-4 tab-content main">
					<s:if test="!listTopo.isEmpty()">
						<section class="tab-pane fade show active" id="v-pills-topo">
							<h1 class="shadow-title text-light">
								<s:text name="content.pills.topo" />
							</h1>
							
							<div class="container-fluid">
								<div class="row">
									<s:iterator value="listTopo">
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card text-center">
												<div class="card-header">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
												</div>
												<div class="card-body">
													<p class="card-text card-overflow">
														<s:property value="description" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="detail_topo" class="btn btn-outline-secondary">
														<s:param name="name" value="name" />
														<s:text name="content.search.button.overview" />
													</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
					
					<s:if test="!listSite.isEmpty()">
						<section class="tab-pane fade" id="v-pills-site">
							<h1 class="shadow-title text-light">
								<s:text name="content.pills.site" />
							</h1>
							
							<div class="container-fluid">
								<div class="row">
									<s:iterator value="listSite">
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card text-center">
												<div class="card-header">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
												</div>
												<div class="card-body">
													<p class="card-text">
														<s:property value="location" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="detail_site" class="btn btn-outline-secondary">
														<s:param name="name" value="name" />
														<s:text name="content.search.button.overview" />
													</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
					
					<s:if test="!listSector.isEmpty()">
						<section class="tab-pane fade" id="v-pills-sector">
							<h1 class="shadow-title text-light">
								<s:text name="content.pills.sector" />
							</h1>
							
							<div class="container-fluid">
								<div class="row">
									<s:iterator value="listSector">
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card text-center">
												<div class="card-header">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
												</div>
												<div class="card-body">
													<p class="card-text">
														<s:text name="content.search.message.siteCard" />
														<s:property value="site.name" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="detail_sector" class="btn btn-outline-secondary">
														<s:param name="name" value="name" />
														<s:text name="content.search.button.overview" />
													</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
		            
		            <s:if test="!listRoute.isEmpty()">
			            <section class="tab-pane fade" id="v-pills-route">
							<h1 class="shadow-title text-light">
								<s:text name="content.pills.route" />
							</h1>
							
							<div class="container-fluid">
								<div class="row">
									<s:iterator value="listRoute">
										<div class="col-lg-4 col-md-6 mb-4">
											<div class="card text-center">
												<div class="card-header">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
												</div>
												<div class="card-body">
													<p class="card-text card-overflow">
														<s:property value="note" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="detail_route" class="btn btn-outline-secondary">
														<s:param name="name" value="name" />
														<s:text name="content.search.button.overview" />
													</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
					
			        <div class="text-light">
						<%@ include file="/jsp/_include/structure/footer.jsp" %>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>