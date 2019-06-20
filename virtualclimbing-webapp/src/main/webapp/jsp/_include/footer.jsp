<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <footer class="page-footer font-small bg-dark">
	<p class="footer-copyright text-center"> Copyright © 2019 Virtual Climbing. All rights reserved </p>
	
</footer> -->

<!-- Footer -->
<footer class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">
  	<p> Copyright © 2019 Virtual Climbing. All rights reserved </p>
  </div>
  <!-- Copyright -->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script>
		var mymap = L.map('leafmapid').setView([-21.1525000, 55.2825000], 15);
		L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
		            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		            maxZoom: 18,
		            id: 'mapbox.streets',
		            accessToken: 'pk.eyJ1IjoiZDR0NGduYW4iLCJhIjoiY2p1MnFtZ3NnMGUzODRldGF4NGx1b3d6dSJ9.ARJozZy1FxDunFo7yGxU9A'
		            }).addTo(mymap);
		var marker = L.marker([-21.1525000, 55.2825000]).addTo(mymap);
	</script>
</footer>
<!-- Footer -->