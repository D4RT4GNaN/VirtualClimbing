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
					<div class="nav flex-column nav-pills nav-sidebar position-fixed bg-dark" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-topo-tab" data-toggle="pill" href="#v-pills-topo" role="tab" aria-controls="v-pills-topo" aria-selected="true">Topo</a>
						<a class="nav-link" id="v-pills-site-tab" data-toggle="pill" href="#v-pills-site" role="tab" aria-controls="v-pills-site" aria-selected="false">Site</a>
						<a class="nav-link" id="v-pills-sector-tab" data-toggle="pill" href="#v-pills-sector" role="tab" aria-controls="v-pills-sector" aria-selected="false">Secteur</a>
						<a class="nav-link" id="v-pills-route-tab" data-toggle="pill" href="#v-pills-route" role="tab" aria-controls="v-pills-route" aria-selected="false">Voie</a>
					</div>
				</nav>
				
				<div class="col-lg-10 tab-content" id="v-pills-tabContent">
					
					<section class="form-sector tab-pane fade show active" id="v-pills-topo" role="tabpanel" aria-labelledby="v-pills-topo-tab">
						<form action="create_topo" method="post" enctype="multipart/form-data">
							<fieldset>
								<legend>Ajouter un Topo</legend>
								
								<s:actionmessage />
								<s:actionerror />
								
								<s:textfield name="topo.name" id="topo_name" placeholder="ex: SuperTopo"
											 class="form-control mb-2" label="Nom" requiredLabel="true" />
								
								<s:textfield name="topo.officialWebSite" id="topo_official_website"
											 placeholder="Laisser vide si inconnu" class="form-control mb-2" 
											 label="Site Officiel" />
		                        
		                        <s:textarea name="topo.description" id="topo_description" class="form-control" 
		                        			placeholder="Ecrivez une belle description" 
		                        			label="Description" requiredLabel="true" />
							  	
							  	<div class="form-group">
									<label for="upload">Bannière:</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" />
									    <label class="custom-file-label" for="banner">Choisir une bannière ...</label>
									</div>
							  	</div>
							  	
							  	<s:checkbox class="form-group" name="topo.privateTopo" label="Privée"/>
							  	
								<div class="form-group">
									<label>Ajouter des sites*:</label>
									<div class="scrollable-div">
										<s:checkboxlist list="listSite" name="checkboxSite" theme="vertical-checkbox"/>
									</div>
								</div>
								
								<div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="Envoyez" />
		                        </div>								
							</fieldset>
						</form>
					</section>
					
					<section class="form-sector tab-pane fade" id="v-pills-site" role="tabpanel" aria-labelledby="v-pills-site-tab">
						<form action="create_site" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>Ajouter un site</legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="site.name" placeholder="ex: Colima 100" 
		                        			 class="form-group form-control" label="Nom" requiredLabel="true" />
							  	
							  	<div class="form-group">
									<label for="upload">Bannière:</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" />
									    <label class="custom-file-label" for="banner">Choisir une bannière ...</label>
									</div>
							  	</div>
		                        
		                        <div class="form-group">
		                            <s:label>Coordonnées du site (en Degrès Décimal)*:</s:label>
		                            <div class="form-inline my-2">
		                            	<s:textfield name="site.latitude" placeholder="Latitude"
		                            				 class="form-control col-sm-6" />
		                                <s:textfield name="site.longitude" placeholder="Longitude"
		                                			 class="form-control col-sm-6" />
		                            </div>
		                        </div>
		                        
		                        <s:textfield name="site.location" placeholder="ex: Ravines Colimaçons - île de la Réunion"
		                        			 class="form-group form-control" label="Lieu" requiredLabel="true" />
		                        
		                        <s:textfield name="site.access" placeholder="ex: suivre tel chemins, tournés à ce rocher, ..."
		                        			 class="form-group form-control" label="Accès" requiredLabel="true" />
		                        
		                        <s:textfield name="site.rockType" placeholder="ex: Volcanique, Granit, Calcaire, ..."
		                        			 class="form-group form-control" label="Type de roche" requiredLabel="true" />
		                        
		                        <s:textfield name="site.profil" placeholder="ex: Dalle, Dièdre, Bloc, ..."
		                        			 class="form-group form-control" label="Profil(s)" requiredLabel="true" />
		                        
								<s:textfield name="site.anchorage" placeholder="ex: type COLLINOX scéllés"
											 class="form-group form-control" label="Ancrage" requiredLabel="true" />
		                        
		                        <s:textfield name="site.maxHeight" placeholder="ex: 20m" class="form-group form-control"
		                        			 label="Hauteur Max" requiredLabel="true" />
		                        
		                        <s:textfield name="site.minAltitude" placeholder="ex: 100m" class="form-group form-control"
		                        			 label="Altitude au pied des voies" requiredLabel="true" />
		                        
		                        <s:textfield name="site.orientation" placeholder="ex: SUD, NORD-EST, ..."
		                        			 class="form-group form-control" label="Orientation" requiredLabel="true" />
		                        
		                        <s:textarea name="site.note" placeholder="Ecrivez vos remarques"
		                        			class="form-group form-control" label="Remarque" />
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="Envoyez" />
		                        </div>
		                    </fieldset>
		                </form>
		            </section>

					<section class="form-sector tab-pane fade" id="v-pills-sector" role="tabpanel" aria-labelledby="v-pills-sector-tab">
						 <form action="create_sector" method="post" enctype="multipart/form-data">
		                    <fieldset>
		                        <legend>Ajouter un secteur</legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="sector.name" id="sector_name" placeholder="ex: DUNES"
		                        			class="form-group form-control" label="Nom" requiredLabel="true" />
		                        
		                        <div class="form-group">
									<label for="banner">Photo du secteur:</label>
									<div class="custom-file">
									    <s:file class="custom-file-input" name="banner" aria-describedby="sectorHelp" />
									    <label class="custom-file-label" for="banner">Choisir une bannière ...</label>
									    <small id="sectorHelp" class="form-text text-muted">Photo montrant le tracé de chaque voie qui constitue le secteur.</small>
								  	</div>
							  	</div>
							  	
							  	<div class="input-group mb-3">
									<s:textfield name="sector.site.name" id="siteForSector" class="form-control" placeholder="Sélectionner un site" data-toggle="modal" data-target="#modalSelect" />
									<div class="input-group-append">
										<a data-toggle="modal" class="btn btn-outline-secondary" href="#modalSelect">Choisir</a>
									</div>
								</div>
		                        
		                        <div class="text-center">
		                            <s:submit class="btn btn-outline-secondary" value="Envoyez" />
		                        </div>
		                    </fieldset>
		                </form>
					</section>

		            <section class="form-sector tab-pane fade" id="v-pills-route" role="tabpanel" aria-labelledby="v-pills-route-tab">
						<form action="create_route">
		                    <fieldset>
		                        <legend>Ajouter une voie</legend>
		                        
		                        <s:actionmessage />
								<s:actionerror />
		                        
		                        <s:textfield name="route.name" id="route_name" class="form-group form-control" 
		                        			 placeholder="ex: Jabba The Hutt" label="Nom" requiredLabel="true" />
		                        
		                        <s:label>Secteur*:</s:label>	 
		                        <div class="input-group mt-2 mb-3">
									<s:textfield id="sectorForRoute" name="route.sector.name" class="form-control modalSector" placeholder="Sélectionner un secteur" data-toggle="modal" data-target="#modalSelectSector" />
									<div class="input-group-append">
										<a data-toggle="modal" class="btn btn-outline-secondary modalSector" href="#modalSelectSector">Choisir</a>
									</div>
								</div>
		                        
		                        <s:textfield name="route.height" id="route_height" class="form-group form-control" 
		                        			 placeholder="ex: 15m" label="Hauteur" requiredLabel="true" />

		                        <s:textfield name="route.grade" id="route_grade" class="form-group form-control" 
		                        			 placeholder="ex: 6b" label="Cotation" requiredLabel="true" />

		                        <s:textarea name="route.note" id="route_note" class="form-group form-control"
		                        			placeholder="Ecrivez vos remarques : origine du nom, spécificité de la voie, conseils, ..." 
		                        			label="Remarque" />	
		                        	
		                        <div class="form-group text-center my-2">
		                            <s:submit class="btn btn-outline-secondary" value="Envoyez" />
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