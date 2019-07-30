<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	
	<body id="search-body">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div id="main_wrapper" class="container-fluid">
			<div class="row">
				<nav class="col-lg-2">
					<div class="nav flex-column nav-pills nav-sidebar position-fixed bg-dark" id="v-pills-tab" 
						 role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-topo-tab" data-toggle="pill" 
						   href="#v-pills-topo" role="tab" aria-controls="v-pills-topo" 
						   aria-selected="true">
							<s:text name="content.pills.topo" />
						</a>
						
						<a class="nav-link" id="v-pills-site-tab" data-toggle="pill" 
						   href="#v-pills-site" role="tab" aria-controls="v-pills-site" 
						   aria-selected="false">
							<s:text name="content.pills.site" />
						</a>
						
						<a class="nav-link" id="v-pills-sector-tab" data-toggle="pill" 
						   href="#v-pills-sector" role="tab" aria-controls="v-pills-sector" 
						   aria-selected="false">
							<s:text name="content.pills.sector" />
						</a>
						
						<a class="nav-link" id="v-pills-route-tab" data-toggle="pill" 
						   href="#v-pills-route" role="tab" aria-controls="v-pills-route" 
						   aria-selected="false">
							<s:text name="content.pills.route" />
						</a>
					</div>
				</nav>
				
				<div class="col-lg-10 tab-content" id="v-pills-tabContent">
					<section class="form-sector tab-pane fade show active" id="v-pills-topo" 
							 role="tabpanel" aria-labelledby="v-pills-topo-tab">
						<form action="create_topo" method="post" enctype="multipart/form-data">
							<fieldset>
								<legend>
									<s:text name="content.new.topo.legend" />
								</legend>
								
								<s:actionmessage />
								<s:actionerror />
								
								<s:textfield name="topo.name" class="form-control mb-2" 
											 placeholder="%{getText('content.new.topo.title.placeholder')}"
											 label="%{getText('content.new.topo.title.label')}" requiredLabel="true" 
								/>
								
								<s:textfield name="topo.officialWebSite" class="form-control mb-2"
											 placeholder="%{getText('content.new.topo.website.placeholder')}"  
											 label="%{getText('content.new.topo.website.label')}" 
								/>
		                        
		                        <s:textarea name="topo.description" class="form-control" 
		                        			placeholder="%{getText('content.new.topo.description.placeholder')}" 
		                        			label="%{getText('content.new.topo.description.label')}" requiredLabel="true" 
		                        />
							  	
							  	<div class="form-group">
									<label for="upload">
										<s:text name="content.new.banner.title" />:
									</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" />
									    <label class="custom-file-label" for="banner">
									    	<s:text name="content.new.banner.placeholder" />
									    </label>
									</div>
							  	</div>
							  	
							  	<s:checkbox class="form-group" name="topo.privateTopo" 
							  				label="%{getText('content.new.topo.privateCheckbox.label')}" 
							  	/>
							  	
								<div class="form-group">
									<label>
										<s:text name="content.new.toposite.title" />*:
									</label>
									<div class="scrollable-div">
										<s:checkboxlist list="listSite" name="checkboxSite" theme="vertical-checkbox" />
									</div>
								</div>
								
								<div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="%{getText('content.new.submit')}" />
		                        </div>								
							</fieldset>
						</form>
					</section>
					
					<section class="form-sector tab-pane fade" id="v-pills-site" 
							 role="tabpanel" aria-labelledby="v-pills-site-tab">
						<form action="create_site" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.site.legend" />
		                        </legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="site.name" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.title.placeholder')}"
		                        			 label="%{getText('content.new.site.title.label')}" requiredLabel="true" 
		                        />
							  	
							  	<div class="form-group">
									<label for="upload">
										<s:text name="content.new.banner.title" />:
									</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" />
									    <label class="custom-file-label" for="banner">
									    	<s:text name="content.new.banner.placeholder" />:
									    </label>
									</div>
							  	</div>
		                        
		                        <div class="form-group">
		                            <s:label>
		                            	<s:text name="content.new.site.coordinate.label" />*:
		                            </s:label>
		                            <div class="form-inline my-2">
		                            	<s:textfield name="site.latitude" class="form-control col-sm-6" 
		                            				 placeholder="%{getText('content.new.site.latitude.placeholder')}" 
		                            	/>
		                                
		                                <s:textfield name="site.longitude" class="form-control col-sm-6" 
		                                			 placeholder="%{getText('content.new.site.longitude.placeholder')}"
		                                />
		                            </div>
		                        </div>
		                        
		                        <s:textfield name="site.location" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.location.placeholder')}"
		                        			 label="%{getText('content.new.site.location.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textfield name="site.access" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.access.placeholder')}"
		                        			 label="%{getText('content.new.site.access.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textfield name="site.rockType" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.rock.placeholder')}"
		                        			 label="%{getText('content.new.site.rock.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textfield name="site.profil" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.profil.placeholder')}"
		                        			 label="%{getText('content.new.site.profil.label')}" requiredLabel="true" 
		                        />
		                        
								<s:textfield name="site.anchorage" class="form-group form-control" 
											 placeholder="%{getText('content.new.site.anchorage.placeholder')}"
											 label="%{getText('content.new.site.anchorage.label')}" requiredLabel="true" 
								/>
		                        
		                        <s:textfield name="site.maxHeight" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.maxHeight.placeholder')}" 
		                        			 label="%{getText('content.new.site.maxHeight.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textfield name="site.minAltitude" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.minAltitude.placeholder')}" 
		                        			 label="%{getText('content.new.site.minAltitude.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textfield name="site.orientation" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.orientation.placeholder')}"
		                        			 label="%{getText('content.new.site.orientation.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:textarea name="site.note" class="form-group form-control" 
		                        			placeholder="%{getText('content.new.site.note.placeholder')}"
		                        			label="%{getText('content.new.site.note.label')}" 
		                        />
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
		            </section>

					<section class="form-sector tab-pane fade" id="v-pills-sector" 
							 role="tabpanel" aria-labelledby="v-pills-sector-tab">
						 <form action="create_sector" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.sector.legend" />
		                        </legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="sector.name" class="form-group form-control"
		                        			 placeholder="%{getText('content.new.sector.title.placeholder')}"
		                        			 label="%{getText('content.new.sector.title.label')}" requiredLabel="true" 
		                        />
		                        
		                        <div class="form-group">
									<label for="banner">
										<s:text name="content.new.sector.banner.label" />:
									</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" aria-describedby="sectorHelp" />
									    <label class="custom-file-label" for="banner">
									    	<s:text name="content.new.banner.placeholder" />
									    </label>
									    <small id="sectorHelp" class="form-text text-muted">
									    	<s:text name="content.new.sector.banner.help" />
									    </small>
								  	</div>
							  	</div>
							  	
							  	<div class="input-group mb-3">
									<s:textfield name="sector.site.name" id="siteForSector" class="form-control" 
												 placeholder="%{getText('content.new.sector.selectSite.placeholder')}" 
												 data-toggle="modal" data-target="#modalSelect" 
									/>
									
									<div class="input-group-append">
										<s:a data-toggle="modal" class="btn btn-outline-secondary" href="#modalSelect">
											<s:text name="content.new.buttonModal" />
										</s:a>
									</div>
								</div>
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>

		            <section class="form-sector tab-pane fade" id="v-pills-route" 
		            		 role="tabpanel" aria-labelledby="v-pills-route-tab">
						<form action="create_route">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.route.legend" />
		                        </legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="route.name" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.route.title.placeholder')}" 
		                        			 label="%{getText('content.new.route.title.label')}" requiredLabel="true" 
		                        />
		                        
		                        <s:label>
		                        	<s:text name="content.new.route.selectSector.label" />*:
		                        </s:label>	 
		                        <div class="input-group mt-2 mb-3">
									<s:textfield id="sectorForRoute" name="route.sector.name" class="form-control modalSector" 
												 placeholder="%{getText('content.new.route.selectSector.placeholder')}" 
												 data-toggle="modal" data-target="#modalSelectSector" 
									/>
									
									<div class="input-group-append">
										<s:a data-toggle="modal" class="btn btn-outline-secondary modalSector" href="#modalSelectSector">
											<s:text name="content.new.buttonModal" />
										</s:a>
									</div>
								</div>
		                        
		                        <s:textfield name="route.height" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.route.height.placeholder')}" 
		                        			 label="%{getText('content.new.route.height.label')}" requiredLabel="true" 
		                        />

		                        <s:textfield name="route.grade" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.route.grade.placeholder')}" 
		                        			 label="%{getText('content.new.route.grade.label')}" requiredLabel="true" 
		                        />

		                        <s:textarea name="route.note" class="form-group form-control"
		                        			placeholder="%{getText('content.new.route.note.placeholder')}" 
		                        			label="%{getText('content.new.route.note.label')}" 
		                        />	
		                        	
		                        <div class="form-group text-center my-2">
		                            <s:submit class="btn btn-outline-secondary" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>
				</div>
			</div>   
        </div>
        
        <%@ include file="/jsp/_include/modal/site.jsp" %>
        <%@ include file="/jsp/_include/modal/sector.jsp" %>
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
		
		<script>	
			$("input[type=file]").change(function (e){
				$(this).next('.custom-file-label').text(e.target.files[0].name);
			});
		
			$("#nameList tr").click(function(){ 
			   var value=$(this).find('td:first').html();
			   var $input=jQuery("#siteForSector");
			   $input.empty();
			   $input.val(value);
			   $("#modalSelect").modal('hide');
			});
			
			$("#nameList tr").click(function(){ 
				   var value=$(this).find('td:first').html();
				   var $input=jQuery("#sectorForRoute");
				   $input.empty();
				   $input.val(value);
				   $("#modalSelectSector").modal('hide');
				});
			
			function filterFunction() {
				// Declare variables
			  	var input, filter, table, tr, td, i, txtValue;
			  	input = document.getElementById("filter");
			  	filter = input.value.toUpperCase();
			  	table = document.getElementById("nameList");
			  	tr = table.getElementsByTagName('tr');
		
			  	// Loop through all list items, and hide those who don't match the search query
			  	for (i = 0; i < tr.length; i++) {
		    		td = tr[i].getElementsByTagName("td")[0];
		    		if (td) {
		      			txtValue = td.textContent || td.innerText;
		      			if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        			tr[i].style.display = "";
		      			} else {
		        			tr[i].style.display = "none";
		      			}
		    		} 
		  		}
			}
			
		</script>
	</body>
</html>