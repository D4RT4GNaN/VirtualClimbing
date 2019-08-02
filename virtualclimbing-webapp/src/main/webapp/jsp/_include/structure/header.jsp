<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <s:a class="navbar-brand text-center logo-link" action="index">
        <img id="logo" alt="Virtual Climbing" src="images/icon_virtual_climbing.png" />
    </s:a>
    
    <button class="navbar-toggler" type="button" 
    		data-toggle="collapse" data-target="#navbarSupportedContent" 
    		aria-controls="navbarSupportedContent" aria-expanded="false" 
    		aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <s:a class="nav-link" action="index">
                	<s:text name="nav.index" />
                </s:a>
            </li>
            
            <li class="nav-item">
                <s:a class="nav-link" action="search">
                	<s:param name="keyword" value="" />
                	<s:text name="nav.beanList" />
                </s:a>
            </li>
            
            <s:if test="#session.user">
	            <li class="nav-item">
	                <s:a class="nav-link" action="private_topo_list">
	                	<s:text name="nav.booking" />
	                </s:a>
	            </li>
	            
	            <li class="nav-item">
	                <s:a class="nav-link" action="create_content">
	                	<s:text name="nav.share" />
	                </s:a>
	            </li>
            </s:if>
        </ul>
        
       	<div id="login">
           	<s:if test="#session.user">
            	<ul class="user-button">
                	<li>
	                	<a class="dropdown-toggle" id="navbardrop" >
			            	<span class="fas fa-user-circle"></span>
			             	<s:property value="#session.user.pseudo"/>
				        </a>
				           	
				        <ul class="user-menu bg-dark">
	              			<li>
		              			<s:a class="dropdown-item" action="detail_user">
		              				<s:text name="nav.user.account" />
		              			</s:a>
		              		</li>
	              			
	              			<li>
		              			<s:a class="dropdown-item" action="all_booking">
		              				<s:text name="nav.user.booking" />
		              			</s:a>     			
	              			</li>
	              			
	              			<li>
	              				<div class="dropdown-divider"></div>
	              			</li>
	              				
	              			<li>
		              			<s:a class="dropdown-item" action="logout">
		              				<s:text name="nav.user.logout" />
		              			</s:a>
	              			</li>
	            		</ul>
	            	</li>
           		</ul>
            </s:if>
            <s:else>
                <s:a action="connect">
                	<s:text name="nav.user.login" />
            	</s:a>
        	</s:else>
        </div>
       
     	<form action="search" class="searchbar">
       		<s:textfield class="search_input" 
          			 	 name="keyword" 
          			 	 placeholder="%{getText('nav.search.placeholder')}" 
          	/>
       		
       		<s:a onclick="this.parentNode.submit(); return false;" class="search_icon">
          		<span class="fas fa-search"></span>
      		</s:a>
  		</form>
    </div>
    
    <s:actionerror />
    <s:actionmessage />
</nav>