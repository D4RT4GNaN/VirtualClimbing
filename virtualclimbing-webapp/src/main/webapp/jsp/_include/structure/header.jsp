<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand text-center" href="index">
        <img id="logo" alt="logo de Virtual Climbing" src="images/icon_virtual_climbing.png" />
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <s:a class="nav-link" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="search">
                	<s:param name="keyword" value="" />
                	Topos
                </s:a>
            </li>
            <s:if test="#session.user">
	            <li class="nav-item">
	                <s:a class="nav-link" action="private_topo_list">Réservations</s:a>
	            </li>
	            <li class="nav-item">
	                <s:a class="nav-link" action="create_content">Partager</s:a>
	            </li>
            </s:if>
        </ul>
        <div class="container-fluid">
            <div class="d-flex justify-content-end">
                <div id="login">
                	<s:if test="#session.user">
	                	<div class="dropdown dmenu">
	                		<a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			             		<span class="fas fa-user-circle"></span>
			             		<s:property value="#session.user.pseudo"/>
				           	</a>
				           	<div class="dropdown-menu dropdown-menu-right bg-dark">
	              				<s:a class="dropdown-item" action="detail_user">Mon compte</s:a>
	              				<a class="dropdown-item" href="all_booking">Mes réservations</a>
	              				<div class="dropdown-divider"></div>
	              				<s:a class="dropdown-item" action="logout">Déconnexion</s:a>
	            			</div>
	            		</div>
                	</s:if>
                	<s:else>
                    	<s:a href="/virtualclimbing-webapp/connect">Connexion</s:a>
                    </s:else>
                </div>
        
                <s:form action="search" class="searchbar">
                    <input type="text" class="search_input" name="keyword" placeholder="Recherche..." />
                    <a onclick="this.parentNode.submit(); return false;" class="search_icon">
                        <span class="fas fa-search"></span>
                    </a>
                </s:form>
            </div>
        </div>
    </div>
</nav>