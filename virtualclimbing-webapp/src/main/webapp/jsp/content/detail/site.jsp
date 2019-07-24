<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/head.jsp" %>
	<body>
		<%@ include file="/jsp/_include/header.jsp" %>
		
		<div id="main_wrapper" class="container-fluid">
            
            <section id="main_banner" style="background-image: url(<s:property value="site.imageUrl" />);">
                <div id="banner_title">
                    <h1><s:property value="site.name" /></h1>
                </div>
            </section>
            <section id="site" class="container mt-3">
                <article class="row">
                    <div id="leafmapid" class="col-md-6 rounded"></div>
                    <div id="information" class="col-md-6 align-self-center">
                        <table class="table table-stripped table-sm">
                            <tr>
                                <td>Lieu:</td>
                                <td id="locationTD"><s:property value="site.getLocation()" /></td>
                            </tr>
                            <tr>
                                <td>Accès:</td>
                                <td id="accessTD"><s:property value="site.getAccess()" /></td>
                            </tr>
                            <tr>
                                <td>Roche:</td>
                                <td id="rockTD"><s:property value="site.getRockType()" /></td>
                            </tr>
                            <tr>
                                <td>Profils:</td>
                                <td id="profilTD"><s:property value="site.getProfil()" /></td>
                            </tr>
                            <tr>
                                <td>Ancrage:</td>
                                <td id="anchorageTD"><s:property value="site.getAnchorage()" /></td>
                            </tr>
                            <tr>
                                <td>Hauteur max:</td>
                                <td id="maxHeightTD"><s:property value="site.getMaxHeight()" />m</td>
                            </tr>
                            <tr>
                                <td>Altitude au pied des voies:</td>
                                <td id="minAltitudeTD"><s:property value="site.getMinAltitude()" />m</td>
                            </tr>
                            <tr>
                                <td>Orientation:</td>
                                <td id="orientationTD"><s:property value="site.getOrientation()" /></td>
                            </tr>
                            <tr>
                                <td>Remarque:</td>
                                <td id="noteTD"><s:property value="site.getNote()" /></td>
                            </tr>
                        </table>
                    </div>
                </article>
            </section>
            <section id="sector" class="container">
            
                <header class= "border-bottom row my-2">
                	<s:form class="col-sm-6">
					    <s:select class="form-control" id="selectSector" name="sector" list="listSector" 
					    		  listKey="name" listValue="name" onchange="onSelectSectorChange()" value="sector.getName()"/>
					</s:form>
                	<h2 class="d-flex justify-content-end col-sm-6">Secteur</h2>
                </header> 
                <div id="banner_sector" class="d-flex justify-content-center">
                    <img class="border border-dark" src="<s:property value="sector.getImageUrl()" />" alt="Ensemble des voie du secteur" />
                </div>
            </section>
            <section id="route" class="container">
                <header class= "border-bottom">
                	<h2 class="d-flex justify-content-end">Voie</h2>
                </header>
                <div id="route-table">
	                <table class="table table-striped text-center">
	                    <thead class="thead-dark">
	                        <tr>
	                            <th>ID</th>
	                            <th>Nom</th>
	                            <th>Hauteur</th>
	                            <th>Cotation</th>
	                            <th>Remarque</th>
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
            
        </div>
        
		<%@ include file="/jsp/_include/footer.jsp" %>
		<script>
			
			var strLat = "<s:property value="site.getLatitude()" />".replace(",", ".");
			var strLon = "<s:property value="site.getLongitude()" />".replace(",", ".");
			
			var urlDetailSite = "<s:url action="ajax_getDetailSite"/>";
			var urlListSector = "<s:url action="ajax_getListSector"/>";
			var urlDetailSector = "<s:url action="ajax_getDetailSector"/>";
			var urlListRoute = "<s:url action="ajax_getListRoute"/>";
		
		</script>
		<script type="text/javascript" src="javascript/ajax_overview.js"></script>
		<script type="text/javascript" src="javascript/map.js"></script>
	</body>
</html>