<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
                <a class="nav-link" href="/virtualclimbing-webapp/index">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/virtualclimbing-webapp/search">Topos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Réservations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/virtualclimbing-webapp/add">Partager</a>
            </li>
        </ul>
        <div class="container-fluid">
            <div class="d-flex justify-content-end">
                <div id="login">
                    <a data-toggle="modal" href="#loginPopUp">Connexion</a>
                </div>
        
                <form method="post" class="searchbar" action="/virtualclimbing-webapp/search">
                    <input class="search_input" type="text" name="searchBar" placeholder="Recherche...">
                    <a href="" onclick="form.submit()" class="search_icon">
                        <span class="fas fa-search"></span>
                    </a>
                </form>
            </div>
        </div>
    </div>
</nav>