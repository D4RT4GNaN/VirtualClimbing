<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>

	<body>
		<%@ include file="/jsp/_include/structure/header.jsp" %>
		
		<section id="main_banner" style="background-image: url(${topo.imageUrl});">
             <div id="banner_title">
                 <h1>
                 	<s:property value="topo.name" />
                 </h1>
        	</div>
        </section>
        
        <section id="site" class="container mt-3">
			<header class="border-bottom row">
				<s:form class="col-sm-6">
					<s:select class="form-control" id="selectSite" name="site" list="listSite" 
		  					  listKey="name" listValue="name" onchange="onSelectSiteChange()" />
				</s:form>

				<h2 class="d-flex justify-content-end col-sm-6">
					<s:text name="content.detail.site" />
				</h2>
			</header>

			<article class="row">
    			<div id="leafmapid" class="col-md-6 rounded"></div>
    
    			<div id="information" class="col-md-6 align-self-center">
        			<table class="table table-stripped table-sm">
            			<tr>
                			<td>
                				<s:text name="content.detail.site.location" />:
							</td>
							<td id="locationTD">
								<s:property value="listSite.get(0).getLocation()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.access" />:
							</td>
							<td id="accessTD">
								<s:property value="listSite.get(0).getAccess()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.rock" />:
							</td>
							<td id="rockTD">
								<s:property value="listSite.get(0).getRockType()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.profil" />:
							</td>
							<td id="profilTD">
								<s:property value="listSite.get(0).getProfil()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.anchorage" />:
							</td>
							<td id="anchorageTD">
								<s:property value="listSite.get(0).getAnchorage()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.maxHeight" />:
							</td>
							<td id="maxHeightTD">
								<s:property value="listSite.get(0).getMaxHeight()" />m
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.minAltitude" />:
							</td>
							<td id="minAltitudeTD">
								<s:property value="listSite.get(0).getMinAltitude()" />m
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.orientation" />:
							</td>
							<td id="orientationTD">
								<s:property value="listSite.get(0).getOrientation()" />
    						</td>
						</tr>

						<tr>
    						<td>
    							<s:text name="content.detail.site.note" />:
							</td>
							<td id="noteTD">
								<s:property value="listSite.get(0).getNote()" />
                			</td>
            			</tr>
        			</table>
    			</div>
			</article>
		</section>
		
		<section id="sector" class="container">
        	<header class= "border-bottom row my-2">
            	<s:form class="col-sm-6">
			    	<s:select class="form-control" id="selectSector" name="sector" list="listSector" 
		    		  		  listKey="name" listValue="name" onchange="onSelectSectorChange()" />
				</s:form>
			
              	<h2 class="d-flex justify-content-end col-sm-6">
              		<s:text name="content.detail.sector" />
              	</h2>
         	</header>
              
            <div id="banner_sector" class="d-flex justify-content-center">
            	<img class="border border-dark img-fluid" 
                  	 src="${listSector.get(0).getImageUrl()}" 
                  	 alt="Ensemble des voie du secteur" 
                />
            </div>
       	</section>
       	
       	<section id="route" class="container">
        	<header class= "border-bottom">
            	<h2 class="d-flex justify-content-end">
             		<s:text name="content.detail.route" />
             	</h2>
             </header>
             
             <div id="route-table">
             	<table class="table table-striped table-responsive w-100 text-center">
                	<thead class="thead-dark">
                    	<tr>
                        	<th>
                          		<s:text name="content.detail.route.thead.id" />
                          	</th>
                          	<th>
                          		<s:text name="content.detail.route.thead.name" />
                          	</th>
                          	<th>
                          		<s:text name="content.detail.route.thead.height" />
                          	</th>
                          	<th>
                          		<s:text name="content.detail.route.thead.grade" />
                          	</th>
                          	<th>
                          		<s:text name="content.detail.route.thead.note" />
                          	</th>
                      	</tr>
                  	</thead>
                  	<tbody id="bodyTable">
                  		<s:iterator value="listRoute" status="stats">
                       		<tr>
                       			<td><s:property value="%{#stats.index}" /></td>
                           		<td><s:property value="name" /></td>
                           		<td><s:property value="height" /></td>
                           		<td><s:property value="grade" /></td>
                           		<td><s:property value="note" /></td>
                       		</tr>
                      	</s:iterator>
                  	</tbody>
              	</table>
      		</div>
       	</section>
       	
       	<section id="comments" class="container">
			<header class= "border-bottom">
                <h2 class="d-flex justify-content-center justify-content-sm-end">
                	<s:text name="content.detail.comment" />
            	</h2>
			</header>
                
			<div id="route-table">
	            <table class="table table-striped w-100">
	            	<tbody id="bodyComment">
	            		<s:iterator value="listComment">
		            		<tr class="row">
		            			<td class="align-middle text-center col-sm-2">
		            				<p class="font-weight-bold fas fa-user-circle">
		            					<s:property value="user.pseudo" />
		            				</p>
		            			</td>
		            				
		            			<td class="col-sm-10">
		            				<p class="font-weight-bold">
		            					<s:property value="title" />
		            				</p>
		            					
		            				<p>
		            					<s:property value="description" />
		            				</p>
		            			</td>
		            		</tr>
	            		</s:iterator>
	            	</tbody>
	        	</table>
        	</div>
        </section>
        
        <%@ include file="/jsp/_include/comment/send.jsp" %>
					
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
        <script>
			var strLat = "<s:property value="listSite.get(0).getLatitude()" />".replace(",", ".");
			var strLon = "<s:property value="listSite.get(0).getLongitude()" />".replace(",", ".");
			
			var urlDetailSite = "<s:url action="ajax_getDetailSite"/>";
			var urlListSector = "<s:url action="ajax_getListSector"/>";
			var urlDetailSector = "<s:url action="ajax_getDetailSector"/>";
			var urlListRoute = "<s:url action="ajax_getListRoute"/>";
			var urlListComment = "<s:url action="ajax_getListComment"/>";
		</script>
		<script type="text/javascript" src="javascript/ajax_overview.js"></script>
		<script type="text/javascript" src="javascript/map.js"></script>
	</body>
</html>