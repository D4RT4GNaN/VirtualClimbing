<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<section class="container px-5">
	<s:actionerror />
	<s:actionmessage />
	<s:if test="!topo.isEmpty() && #session.user">
		<form class="user-div mx-5" action="send_comment_topo">
			<s:hidden name="topo.name" value="%{topo.name}" />
			<s:hidden id="nameSector" name="comment.sector.name" value="%{listSector.get(0).name}" />
			<s:textfield name="comment.title" placeholder="Choisissez un titre" class="form-group form-control" />
			<s:textarea name="comment.description" placeholder="Ecrivez votre commentaire ici" class="form-group form-control" />
			<s:submit value="Poster" class="btn btn-outline-secondary" />
		</form>
	</s:if>
	<s:elseif test="#session.user">
		<form class="user-div mx-5" action="send_comment_site">
			<s:hidden id="nameSector" name="comment.sector.name" value="%{sector.name}" />
			<s:textfield name="comment.title" placeholder="Choisissez un titre" class="form-group form-control" />
			<s:textarea name="comment.description" placeholder="Ecrivez votre commentaire ici" class="form-group form-control" />
			<s:submit value="Poster" class="btn btn-outline-secondary" />
		</form>
	</s:elseif>
	<s:else>
		<div class="user-div mx-5">
			<p>Vous devez être connecté pour répondre</p>
		</div>
	</s:else>
</section>