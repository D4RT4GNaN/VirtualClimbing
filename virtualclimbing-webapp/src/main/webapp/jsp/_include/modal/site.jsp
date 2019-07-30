<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="modal fade" id="modalSelect" tabindex="-1" role="dialog" aria-labelledby="modalSelectTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<!-- header -->
	        <div class="modal-header">
	        	<h3 class="modal-title">
	        		<s:text name="modal.site.title" />
	        	</h3>
	        	
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        		<span aria-hidden="true">&times;</span>
	        	</button>
	        </div>
	        
        	<!-- body -->
        	<div class="modal-body">
          		<form>
          			<div class="scrollable-div-no-padding">
		            	<table class="table table-striped table-hover m-0">
		            		<tbody id="nameList">
			              		<s:iterator value="listSite">
									<tr>
										<td><s:property value="name" /></td>
									</tr>
								</s:iterator>
							</tbody>
		            	</table>
	            	</div>
          		</form>
        	</div>
        	
        	<!-- footer -->
        	<div class="modal-footer">
          		<s:textfield name="research" id="filter" class="form-control" 
          					 placeholder="%{getText('modal.search.placeholder')}"  
          					 onkeyup="filterFunction()" 
          		/>
        	</div>
		</div>
	</div>
</div> 
