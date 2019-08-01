<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<section class="container px-0 px-sm-5">
	<s:actionerror />
	<s:actionmessage />
	
	<s:if test="!topo.isEmpty() && #session.user">
		<form class="comment-div" action="send_comment_topo">
			<s:hidden name="topo.name" value="%{topo.name}" />
			<s:hidden id="nameSector" name="comment.sector.name" value="%{listSector.get(0).name}" />
			<s:textfield name="comment.title" class="form-group form-control" 
						 placeholder="%{getText('send.title.placeholder')}" 
			/>
			<s:textarea name="comment.description" class="form-group form-control" 
						placeholder="%{getText('send.description.placeholder')}" 
			/>
			<s:submit value="%{getText('send.submit')}" class="btn btn-outline-secondary" />
		</form>
	</s:if>
	
	<s:elseif test="#session.user">
		<form class="comment-div" action="send_comment_site">
			<s:hidden id="nameSector" name="comment.sector.name" value="%{sector.name}" />
			<s:textfield name="comment.title" class="form-group form-control" 
						 placeholder="%{getText('send.title.placeholder')}" 
			/>
			<s:textarea name="comment.description" class="form-group form-control" 
						placeholder="%{getText('send.description.placeholder')}" 
			/>
			<s:submit value="%{getText('send.submit')}" class="btn btn-outline-secondary" />
		</form>
	</s:elseif>
	
	<s:else>
		<div class="comment-div">
			<p>
				<s:text name="send.message.connect" />
			</p>
		</div>
	</s:else>
</section>