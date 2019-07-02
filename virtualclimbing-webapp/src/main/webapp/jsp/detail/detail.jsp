<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/head.jsp" %>
	<body>
		<%@ include file="/jsp/_include/header.jsp" %>
		<%@ include file="/jsp/_include/login.jsp" %>
		
		<div id="main_wrapper" class="container-fluid">
            
            <section id="banner_topo" style="background-image: url(images/banner_colima100.jpg);">
                <div id="banner_title">
                    <h1><s:property value="topo.name" /></h1>
                </div>
            </section>
            <section id="site" class="container">
                <header class="border-bottom"><h2 class="d-flex justify-content-end">Site</h2></header>
                <s:form>
				    <s:select id="selectSite" name="site" list="listSite" listKey="name" listValue="name" onchange="" />
				</s:form>
                <article class="row">
                    <div id="banner_site" class="col-md-12">
                        <img class="img-thumbnail" src="images/banner_site_colima100.jpg" alt="Bannière du site colima'100" />
                    </div>
                    <div id="leafmapid" class="col-md-6 rounded"></div>
                    <div id="information" class="col-md-6 align-self-center">
                        <table class="table table-stripped table-sm">
                            <tr>
                                <td>Lieu:</td>
                                <td id="locationTD"><s:property value="listSite.get(0).getLocation()" /></td>
                            </tr>
                            <tr>
                                <td>Accès:</td>
                                <td id="accessTD"><s:property value="listSite.get(0).getAccess()" /></td>
                            </tr>
                            <tr>
                                <td>Roche:</td>
                                <td id="rockTD"><s:property value="listSite.get(0).getRockType()" /></td>
                            </tr>
                            <tr>
                                <td>Profils:</td>
                                <td id="profilTD"><s:property value="listSite.get(0).getProfil()" /></td>
                            </tr>
                            <tr>
                                <td>Ancrage:</td>
                                <td id="anchorageTD"><s:property value="listSite.get(0).getAnchorage()" /></td>
                            </tr>
                            <tr>
                                <td>Hauteur max:</td>
                                <td id="maxHeightTD"><s:property value="listSite.get(0).getMaxHeight()" />m</td>
                            </tr>
                            <tr>
                                <td>Altitude au pied des voies:</td>
                                <td id="minAltitudeTD"><s:property value="listSite.get(0).getMinAltitude()" />m</td>
                            </tr>
                            <tr>
                                <td>Orientation:</td>
                                <td id="orientationTD"><s:property value="listSite.get(0).getOrientation()" /></td>
                            </tr>
                            <tr>
                                <td>Remarque:</td>
                                <td id="noteTD"><s:property value="listSite.get(0).getNote()" /></td>
                            </tr>
                        </table>
                    </div>
                </article>
            </section>
            <section id="sector" class="container">
                <header class= "border-bottom"><h2 class="d-flex justify-content-end">Secteur</h2></header>
                <div id="select-sector">
                    <select class="form-control">
                        <option>DUNES</option>
                        <option>SDF</option>
                        <option>FICUS</option>
                    </select>
                </div>
                <div class="d-flex justify-content-center">
                    <img class="border border-dark" src="images/banner_sector_dunes_colima100.jpg" alt="Ensemble des voie du secteur" />
                </div>
            </section>
            <section id="route" class="container">
                <header class= "border-bottom"><h2 class="d-flex justify-content-end">Voie</h2></header>
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
	                    <tbody>
	                        <tr>
	                            <td>1</td>
	                            <td>Jabba The Hutt</td>
	                            <td>/</td>
	                            <td>6b</td>
	                            <td>Voie obèse, des plis sur le ventre, Position en dalle popularisé en 1980 dans le crux, équipée de la veille d'un "jedi" ... on dirait question pour un champion</td>
	                        </tr>
	                        <tr>
	                            <td>2</td>
	                            <td>Mano Négra</td>
	                            <td>/</td>
	                            <td>5a</td>
	                            <td>1m^3 de terre descendu de la fissure, de quoi se salir les pattes ! Et un groupe atypique ...</td>
	                        </tr>
	                        <tr>
	                            <td>3</td>
	                            <td>khjlhlmhlh</td>
	                            <td>/</td>
	                            <td>6a</td>
	                            <td>/</td>
	                        </tr>
	                        <tr>
	                            <td>4</td>
	                            <td>Théorème</td>
	                            <td>/</td>
	                            <td>7b</td>
	                            <td>Belle ligne, une vire à protéger, un mousquetonage difficile, un équipement à réfléchir, 2 lignes qui se croisent, mathématiquement compliquée ...</td>
	                        </tr>
	                        <tr>
	                            <td>5</td>
	                            <td>Diago Folle</td>
	                            <td>/</td>
	                            <td>5b</td>
	                            <td>Ligne évidente, un clin d'oeil au trailer responsable de l'équipement des sites de la région qui me fourni en matos.</td>
	                        </tr>
	                        <tr>
	                            <td>6</td>
	                            <td>Belle de Nuit</td>
	                            <td>/</td>
	                            <td>6b</td>
	                            <td>Ouverte il y a 20 ans par J-Marc Caron avec un leger abus du perfo ... Une autre époque, une belle ligne à faire !</td>
	                        </tr>
	                        <tr>
	                            <td>7</td>
	                            <td>Liane Folle</td>
	                            <td>15m</td>
	                            <td>6a</td>
	                            <td>Ha cette liane, interrogarion: coupe, coupe pas, soyons fou !!!</td>
	                        </tr>
	                        <tr>
	                            <td>8</td>
	                            <td>Plomb en Biais</td>
	                            <td>/</td>
	                            <td>7a</td>
	                            <td>Une canalisation "lianesque" trop belle pour être coupée, un vol à se mettre de travers, ouarf trop drôle tout trouvé !</td>
	                        </tr>
	                        <tr>
	                            <td>9</td>
	                            <td>Squamate</td>
	                            <td>/</td>
	                            <td>7/8</td>
	                            <td>Ligne dantesque, projet ambitieux, début de voie en écart/opposition, reptile à écaille qui change régulièrement de peau, si tu en es ...</td>
	                        </tr>
	                        <tr>
	                            <td>10</td>
	                            <td>Prix à Prisme</td>
	                            <td>/</td>
	                            <td>8a</td>
	                            <td>Phantasmé pendant des jours de terrassement par un prof de math (yvan), angulaire, le salut du pas de bloc de départ est dans le prisme ... Je bande (priaprisme) pour cette voie. Merci à Thierry Caillot pour la validation du projet. Et oui je n'ai pas encore ce niveau ... ;-)</td>
	                        </tr>
	                        <tr>
	                            <td>11</td>
	                            <td>Archange</td>
	                            <td>/</td>
	                            <td>7a</td>
	                            <td>Une arche évidente pour s'envoler ... de toute beauté, variante: essayer sans les arêtes à partir du 5ème points (7b+) qu'est ce qu'on rigole !</td>
	                        </tr>
	                        <tr>
	                            <td>12</td>
	                            <td>Théorie Quantique</td>
	                            <td>/</td>
	                            <td>7/8</td>
	                            <td>Projet, une ligne qui fait rêver, au delà la physique traditionnelle, en théorie "faisable" mais pas encore observée ...</td>
	                        </tr>
	                        <tr>
	                            <td>13</td>
	                            <td>Ta dû l'faire</td>
	                            <td>/</td>
	                            <td>7a</td>
	                            <td>Oui, oui, elle est facile ! A l'origine "Yo c mythique" récemment ouverte sur 3 Bass, variante: la dalle sans l'arêre 4ème pt, old school, proposée 7c</td>
	                        </tr>
	                        <tr>
	                            <td>14</td>
	                            <td>Callipyge</td>
	                            <td>/</td>
	                            <td>7b</td>
	                            <td>Belle croupe arrondie, lisse, old school, en hommage à mes lectures "SAS"ienne du siècle dernier, ha ce "Malko Linge" quel fripon...</td>
	                        </tr>
	                        <tr>
	                            <td>15</td>
	                            <td>123</td>
	                            <td>/</td>
	                            <td>6c</td>
	                            <td>Mono, bi, tri ... Vous comprendrez, une fois dedans !</td>
	                        </tr>
	                        <tr>
	                            <td>16</td>
	                            <td>Coup de Sang</td>
	                            <td>/</td>
	                            <td>7a</td>
	                            <td>Ou l'art de s'éclater le doigt avec l'ampoule lors du scellement d'un point...</td>
	                        </tr>
	                        <tr>
	                            <td>17</td>
	                            <td>L'antre Deux</td>
	                            <td>/</td>
	                            <td>6b</td>
	                            <td>Entre deux mon coeur balance, au dernier point, rester dans la dalle dans l'axe du relais à gauche de l'arête, à droite c'est du "5" bande de petits malins</td>
	                        </tr>
	                        <tr>
	                            <td>18</td>
	                            <td>Vague à lames</td>
	                            <td>/</td>
	                            <td>6a</td>
	                            <td>Des vagues après la vire, des lames après le surplomb ... Vous comprendrez ...</td>
	                        </tr>
	                        <tr>
	                            <td>19</td>
	                            <td>Génèse</td>
	                            <td>/</td>
	                            <td>5b</td>
	                            <td>Toute première voie équipée du secteur, parfaite pour s'échauffer, tranquillou</td>
	                        </tr>
	                    </tbody>
	                </table>
                </div>
            </section>
            
        </div>
        
		<%@ include file="/jsp/_include/footer.jsp" %>
	</body>
</html>