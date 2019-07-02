<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/head.jsp" %>
	<body id="search-body">
		<%@ include file="/jsp/_include/header.jsp" %>
		<%@ include file="/jsp/_include/login.jsp" %>
		
		<div id="main_wrapper" class="container-fluid">
			<div class="row">
				<nav class="col-lg-2">
					<div class="nav flex-column nav-pills nav-sidebar position-fixed bg-dark" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-topo-tab" data-toggle="pill" href="#v-pills-topo" role="tab" aria-controls="v-pills-topo" aria-selected="true">Topo</a>
						<a class="nav-link" id="v-pills-site-tab" data-toggle="pill" href="#v-pills-site" role="tab" aria-controls="v-pills-site" aria-selected="false">Site</a>
						<a class="nav-link" id="v-pills-sector-tab" data-toggle="pill" href="#v-pills-sector" role="tab" aria-controls="v-pills-sector" aria-selected="false">Secteur</a>
						<a class="nav-link" id="v-pills-route-tab" data-toggle="pill" href="#v-pills-route" role="tab" aria-controls="v-pills-route" aria-selected="false">Voie</a>
					</div>
				</nav>
				
				<section class="col-lg-10 tab-content" id="v-pills-tabContent">
					<s:if test="!listTopo.isEmpty()">
						<section class="search-section tab-pane fade show active" id="v-pills-topo" role="tabpanel" aria-labelledby="v-pills-topo-tab">
							<h1>Topo</h1>
							<div class="search-div">
								<div class="row text-center search-page">
									<s:iterator value="listTopo">
										<div class="col-lg-3 col-md-6 mb-4">
											<div class="card h-100">
												<img class="card-img-top card-img-top-test" src="images/banner_colima100.jpg" alt="" />
												<div class="card-body">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
													<p class="card-text">
														<s:property value="description" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="detail_topo" class="btn btn-outline-secondary">
														<s:param name="topoName" value="name" />
														Voir
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
						<section class="search-section tab-pane fade" id="v-pills-site" role="tabpanel" aria-labelledby="v-pills-site-tab">
							<h1>Site</h1>
							<div class="search-div">
								<div class="row text-center search-page">
									<s:iterator value="listSite">
										<div class="col-lg-3 col-md-6 mb-4">
											<div class="card h-100">
												<img class="card-img-top card-img-top-test" src="images/banner_colima100.jpg" alt="" />
												<div class="card-body">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
													<p class="card-text">
														<s:property value="location" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="" class="btn btn-outline-secondary">Voir</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
					
					<s:if test="!listSector.isEmpty()">
						<section class="search-section tab-pane fade" id="v-pills-sector" role="tabpanel" aria-labelledby="v-pills-sector-tab">
							<h1>Secteur</h1>
							<div class="search-div">
								<div class="row text-center search-page">
									<s:iterator value="listSector">
										<div class="col-lg-3 col-md-6 mb-4">
											<div class="card h-100">
												<img class="card-img-top card-img-top-test" src="images/banner_colima100.jpg" alt="" />
												<div class="card-body">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
												</div>
												<div class="card-footer">
													<s:a action="" class="btn btn-outline-secondary">Voir</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
		            
		            <s:if test="!listRoute.isEmpty()">
			            <section class="search-section tab-pane fade" id="v-pills-route" role="tabpanel" aria-labelledby="v-pills-route-tab">
							<h1>Voie</h1>
							<div class="search-div">
								<div class="row text-center search-page">
									<s:iterator value="listRoute">
										<div class="col-lg-3 col-md-6 mb-4">
											<div class="card h-100">
												<img class="card-img-top card-img-top-test" src="images/banner_colima100.jpg" alt="" />
												<div class="card-body">
													<h2 class="card-title">
														<s:property value="name" />
													</h2>
													<p class="card-text">
														<s:property value="note" />
													</p>
												</div>
												<div class="card-footer">
													<s:a action="" class="btn btn-outline-secondary">Voir</s:a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</div>
						</section>
					</s:if>
				</section>
			</div>
            
        </div>
        
		<%@ include file="/jsp/_include/footer.jsp" %>
	</body>
</html>