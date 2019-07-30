<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Footer -->
<footer class="page-footer font-small blue">
  	<!-- Copyright -->
  	<div class="footer-copyright text-center py-3">
  		<p> Copyright © 2019 Virtual Climbing. All rights reserved </p>
  	</div>
  	<!-- Copyright -->
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function () {
		$('.dmenu').hover(function () {
		        $(this).find('.dropdown-menu-right').first().stop(true, true).slideDown(150);
		    }, function () {
		        $(this).find('.dropdown-menu-right').first().stop(true, true).slideUp(105)
		    });
		});
	</script>
</footer>
<!-- Footer -->