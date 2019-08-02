<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="/jsp/_include/structure/head.jsp" %>
	<body>
		<%@ include file="/jsp/_include/structure/header.jsp" %>
	
		<div id="main_wrapper" class="container-fluid">
            
            <section class="index-section">
                <h1>
                	<s:text name="index.title" />
                </h1>
            </section>
            
            <section class="container-fluid index-section">
                <div class="row">
                    <aside class="col-md-6" >
                        <img class="img-fluid img-thumbnail" 
                        	 alt="Carte avec les montagnes en relief" 
                        	 src="https://cdn.pixabay.com/photo/2017/05/08/03/28/maps-2294275_960_720.jpg" 
                       	/>
                    </aside>
                    <article class="col-md-6 align-self-center">
                        <h2>
                        	<s:text name="index.share.title" />
                        </h2>
                        <ul class="list-inline">
                        	<s:if test="#session.user">
	                            <li class="list-inline-item">
	                            	<s:a class="link" action="create_topo" >
	                            		<s:text name="index.share.link.share" />
	                            		<span class="fas fa-angle-right"></span>
	                            	</s:a>
	                            </li>
	                            <li class="list-inline-item">
		                            <s:a class="link" action="private_topo_list" >
		                            	<s:text name="index.share.link.booking" /> 
		                            	<span class="fas fa-angle-right"></span>
		                            </s:a>
	                            </li>
                            </s:if>
                            <s:else>
                            	<li class="list-inline-item">
	                            	<s:a class="link" action="login" >
	                            		<s:text name="index.share.link.share" />
	                            		<span class="fas fa-angle-right"></span>
	                            	</s:a>
	                            </li>
	                            <li class="list-inline-item">
		                            <s:a class="link" action="login" >
		                            	<s:text name="index.share.link.booking" /> 
		                            	<span class="fas fa-angle-right"></span>
		                            </s:a>
	                            </li>
                            </s:else>
                        </ul>
                    </article>
                </div>
            </section>
            
            <section class="index-section">
                <p>
					<s:text name="index.section.text.1" />
				</p>
            </section>
            
            <section class="index-section">
                <h2>
	               <q><s:text name="index.proverb" /></q> 
	               - 
	               <s:text name="index.proverb.author" />
                </h2>
               	<s:a class="link" action="search">
               		<s:param name="keyword" value="" />
               		<s:text name="index.proverb.link" /> 
               		<span class="fas fa-angle-right"></span>
               	</s:a>
            </section>
            
            <section class="index-section">
                <p>
                	<s:text name="index.section.text.2" />
                </p>
            </section>
            
        </div>
        
		<%@ include file="/jsp/_include/structure/footer.jsp" %>
	</body>
</html>