<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="loginPopUp" tabindex="-1" role="dialog" aria-labelledby="loginPopUpTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
		
			<!-- header -->
	        <div class="modal-header">
	        	<h3 class="modal-title">Se connecter</h3>
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        		<span aria-hidden="true">&times;</span>
	        	</button>
	        </div>
	        
        	<!-- body -->
        	<div class="modal-body">
          		<form>
	            	<div class="form-group">
	              		<input type="email" class="form-control" placeholder="Email"/>
	              		<input type="password" class="form-control" placeholder="Password" />
	            	</div>
          		</form>
        	</div>
        	
        	<!-- footer -->
        	<div class="modal-footer">
          		<button class="btn btn-secondary btn-block">Connexion</button>
          		<p> Vous n'avez pas encore de compte ? <a  data-dismiss="modal" data-toggle="modal" href="#signUpPopUp">S'inscrire</a></p>
        	</div>
        	
		</div>
	</div>
</div> 

<div class="modal fade" id="signUpPopUp" tabindex="-1" role="dialog" aria-labelledby="loginPopUpTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
		
			<!-- header -->
	        <div class="modal-header">
	        	<h3 class="modal-title">Se connecter</h3>
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        		<span aria-hidden="true">&times;</span>
	        	</button>
	        </div>
	        
        	<!-- body -->
        	<div class="modal-body">
          		<form>
	            	<div class="form-group">
	            		<input type="text" class="form-control" placeholder="Pseudo" name="pseudo" />
	            	</div>
	            	<div class="form-group">
	            		<input type="text" class="form-control" placeholder="Prénom" name="firstName" />
	            	</div>
	            	<div class="form-group">
	              		<input type="text" class="form-control" placeholder="Nom" name="lastName" />
	              	</div>
	              	<div class="form-group">
	              		<input type="password" class="form-control" placeholder="Mot de passe" name="password" />
	            	</div>
          		</form>
        	</div>
        	
        	<!-- footer -->
        	<div class="modal-footer">
          		<button class="btn btn-secondary btn-block">S'inscrire</button>
          		<p> Vous avez déjà un compte ? <a  data-dismiss="modal" data-toggle="modal" href="#loginPopUp">Se connecter</a></p>
        	</div>
        	
		</div>
	</div>
</div> 