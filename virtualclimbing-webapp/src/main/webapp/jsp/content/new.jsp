<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>

	<body class="bg-dark">
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<div class="container-fluid h-100">
			<div class="row h-100">
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
					</ul>
				</nav>
			
			
				<div class="col-md-10 ml-sm-auto px-0 pb-0 tab-content main">
					<section class="tab-pane fade show active" id="v-pills-topo">
						<form class="py-2 px-3 px-md-4" action="create_topo" method="post" enctype="multipart/form-data">
							<fieldset>
								<legend>
									<s:text name="content.new.topo.legend" />
								</legend>
								
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
							  	
							  	<s:checkbox id="topo-private" class="form-group" name="topo.privateTopo" 
							  				label="%{getText('content.new.topo.privateCheckbox.label')}" 
							  	/>
							  	
								<div class="form-group">
									<label class="label">
										<s:text name="content.new.toposite.title" />*:
									</label>
									<div class="scrollable-div">
										<s:checkboxlist list="listSite" name="checkboxSite" theme="vertical-checkbox" />
									</div>
								</div>
								
								<div class="text-center">
		                            <s:submit class="btn btn-outline-light" value="%{getText('content.new.submit')}" />
		                        </div>								
							</fieldset>
						</form>
					</section>
					
					<section class="tab-pane fade" id="v-pills-site">
						<form class="py-2 px-3 px-md-5" action="create_site" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.site.legend" />
		                        </legend>
		                        
		                        <s:textfield name="site.name" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.site.title.placeholder')}"
		                        			 label="%{getText('content.new.site.title.label')}" requiredLabel="true" 
		                        />
							  	
							  	<div class="form-group">
									<label for="upload" class="label">
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
		                            <label class="label">
		                            	<s:text name="content.new.site.coordinate.label" />*:
		                            </label>
		                            <div class="form-inline">
		                            	<s:textfield name="site.latitude" class="form-control col-sm-5" 
		                            				 placeholder="%{getText('content.new.site.latitude.placeholder')}" 
		                            	/>
		                                
		                                <s:textfield name="site.longitude" class="form-control col-sm-5 offset-sm-2" 
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
		                        			label="%{getText('content.new.site.note.label')}" requiredLabel="true" 
		                        />
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-light" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>
					
					<section class="tab-pane fade h-90" id="v-pills-sector">
						<form class="py-2 px-3 px-md-4 h-100" action="create_sector" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.sector.legend" />
		                        </legend>
		                        
		                        <s:textfield name="sector.name" class="form-group form-control"
		                        			 placeholder="%{getText('content.new.sector.title.placeholder')}"
		                        			 label="%{getText('content.new.sector.title.label')}" requiredLabel="true" 
		                        />
		                        
		                        <div class="form-group">
									<label for="banner" class="label">
										<s:text name="content.new.sector.banner.label" />:
									</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" aria-describedby="sectorHelp" />
									    <label class="custom-file-label" for="banner">
									    	<s:text name="content.new.banner.placeholder" />
									    </label>
									    <small id="sectorHelp" class="form-text text-light">
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
										<s:a data-toggle="modal" class="btn btn-outline-light" href="#modalSelect">
											<s:text name="content.new.buttonModal" />
										</s:a>
									</div>
								</div>
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-light" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>
		            
		            <section class="tab-pane fade h-90" id="v-pills-route">
						<form class="py-2 px-3 px-md-4 h-100" action="create_route">
		                    <fieldset>
		                        <legend>
		                        	<s:text name="content.new.route.legend" />
		                        </legend>
		                        
		                        <s:textfield name="route.name" class="form-group form-control" 
		                        			 placeholder="%{getText('content.new.route.title.placeholder')}" 
		                        			 label="%{getText('content.new.route.title.label')}" requiredLabel="true" 
		                        />
		                        
		                        <label class="label">
		                        	<s:text name="content.new.route.selectSector.label" />*:
		                        </label>	 
		                        <div class="input-group mt-2 mb-3">
									<s:textfield id="sectorForRoute" name="route.sector.name" class="form-control modalSector" 
												 placeholder="%{getText('content.new.route.selectSector.placeholder')}" 
												 data-toggle="modal" data-target="#modalSelectSector" 
									/>
									
									<div class="input-group-append">
										<s:a data-toggle="modal" class="btn btn-outline-light modalSector" href="#modalSelectSector">
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
		                            <s:submit class="btn btn-outline-light" value="%{getText('content.new.submit')}" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>
					
					<div class="footer-light">
						<%@ include file="/jsp/_include/structure/footer.jsp" %>
					</div>
				</div>
			</div>
		</div>
        
        <%@ include file="/jsp/_include/modal/site.jsp" %>
        <%@ include file="/jsp/_include/modal/sector.jsp" %>
		
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